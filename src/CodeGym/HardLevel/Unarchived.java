package CodeGym.HardLevel;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
The main method comes with a list of arguments.
The first argument is the resultFileName file name, the other arguments are file names fileNamePart.
Each file (fileNamePart) is a piece of a zip archive. We need to unzip the whole file by assembling it from the pieces.
Write the unzipped file to resultFileName.
The archive can contain a long file, e.g. 50Mb.
The archive can contain a file with any name.

Example of input data. There is one file inside the archive with the name abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002

Requirements:
- In the main method, you need to create a ZipInputStream for an archive assembled from pieces of files. The files come as arguments to main, starting with the second one.
- Create a stream to write to the file that comes as the first argument in main. Write the contents of the file from the archive there.
- The stream to read from the archive must be closed.
- The thread for writing to the file must be closed.
 */
public class Unarchived {
    public static void main(String[] args) throws IOException {
        File result = new File(args[0]);    //Файл результата, по совместительству имя этого файла мы ищем в архиве
        if (!result.exists()) {
            result.createNewFile();
        }
        List<FileInputStream> fileInputStreams = new ArrayList<>(); //Список входящих стримов из разных кусков архива

        //Расставляем имена файлов архива в нужном нам порядке
        List<String> fileNames = new ArrayList<>();
        fileNames.addAll(Arrays.asList(args).subList(1, args.length));
        Collections.sort(fileNames);

        //Создаем входящий стрим для каждого куска архива
        for (String name : fileNames) {
            fileInputStreams.add(new FileInputStream(name));
        }

        try (ZipInputStream is = new ZipInputStream(new SequenceInputStream(Collections.enumeration(fileInputStreams))))    //Входящий стрим общего архива
        {
            while (true) {
                ZipEntry entry = is.getNextEntry();
                if (entry == null) break;

                try (OutputStream os = new BufferedOutputStream(new FileOutputStream(result))) {
                    final int bufferSize = 1024;
                    byte[] buffer = new byte[bufferSize];
                    for (int readBytes; (readBytes = is.read(buffer, 0, bufferSize)) > -1; ) {
                        os.write(buffer, 0, readBytes);
                    }
                    os.flush();
                }
            }
        }
    }
}
