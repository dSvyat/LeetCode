package CodeGym.HardLevel;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/*
View the java.nio.file.FileVisitor interface and its basic implementation java.nio.file.SimpleFileVisitor.
While searching the file tree using the Files.walkFileTree(Path start, FileVisitor<? super Path> visitor) method
we use the FileVisitor object to perform the necessary operations on the found Path objects.

Our search class will be called SearchFileVisitor and will extend SimpleFileVisitor.

You will be able to search by the following criteria:
- An expression occurring in the file name (String);
- Expression found in the content of the file (String);
- maximum and minimum file size (int).
You can specify either one or several search criteria at once.

I wrote code in main that uses the ready-made SearchFileVisitor to search for files; you have an easy task to implement it.
Tip 1: The methods get... , set... - are getters and setters of the fields. The basic search logic of the class is done in the visitFile(Path file, BasicFileAttributes attrs) method.
Tip 2: Use only classes from the java.nio package to work with files.

Requirements:
- In the SearchFileVisitor class, you must create partOfName, partOfContent, minSize, maxSize fields and setters for them.
- In SearchFileVisitor class you need to create foundFiles field and getter for it. The field must be initialized immediately.
- If SearchFileVisitor has a partOfName search criterion, the visitFile method should add the file to foundFiles if the name contains the partOfName string.
- If SearchFileVisitor has the search criterion partOfContent, the visitFile method should add the file to foundFiles if the content contains the string partOfContent.
- If SearchFileVisitor has the maxSize search criterion, the visitFile method should add the file to foundFiles if the file size is less than maxSize.
- If SearchFileVisitor has the search criterion minSize, the visitFile method should add the file to foundFiles if the file size is larger than minSize.
- The visitFile method must be implemented to take several search criteria into account at once.
 */
public class AdvancedFileSearch {
    public static void main(String[] args) throws IOException {
        SearchFileVisitor searchFileVisitor = new SearchFileVisitor();

        searchFileVisitor.setPartOfName("amigo");
        searchFileVisitor.setPartOfContent("programmer");
        searchFileVisitor.setMinSize(500);
        searchFileVisitor.setMaxSize(10000);

        Files.walkFileTree(Paths.get("D:/SecretFolder"), searchFileVisitor);

        List<Path> foundFiles = searchFileVisitor.getFoundFiles();
        for (Path file : foundFiles) {
            System.out.println(file);
        }
    }
}

class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;

    private List<Path> foundFiles = new ArrayList<>();

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        // check if file name contains search string
        if (partOfName != null && !file.getFileName().toString().contains(partOfName)) return FileVisitResult.CONTINUE;

        // read file content
        byte[] content = Files.readAllBytes(file);

        //check size of file
        if ((maxSize > 0 && content.length > maxSize) || (minSize > 0 && content.length < minSize)) return FileVisitResult.CONTINUE;

        // check contents of file
        if (partOfContent != null && !partOfContent.isEmpty()) {
            String contentString = new String(content);
            if (!contentString.contains(partOfContent)) return FileVisitResult.CONTINUE;
        }

        // if all checks are passed, add file to result list
        foundFiles.add(file);
        return super.visitFile(file, attrs);
    }
}
