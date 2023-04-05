package CodeGym.Medium;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
The main method comes with three parameters:
1) fileName - file path;
2) number - number, position in the file;
3) text - text.
Write text to fileName starting from position number.
The text should be written over the old data in the file.
If the file is too short, write it to the end of the file.
Use RandomAccessFile and its seek and write methods.

Requirements:
- You must use RandomAccessFile in the main method of the Solution class.
- In the main method of the Solution class, the program must write data to the file using the write method of the RandomAccessFile class.
- The file must be written from a specified position and content must be replaced.
- If the file is too short, the text must be written to the end of the file.
 */
public class WritingInExistingFile {
    public static void main(String... args) {
        try (RandomAccessFile raf = new RandomAccessFile(args[0], "rw")) {
            long number = Long.parseLong(args[1]);
            long length = raf.length();
            number = number > length ? length : number;
            raf.seek(number);
            raf.write(args[2].getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
