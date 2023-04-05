package CodeGym.Medium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/*
Implement getProperties method, which should read properties from passed fileName.
FileName can have any extension - either xml or no extension at all.
It is necessary to ensure that the properties are read correctly.
If an error occurs, an empty object must be returned.
The main method is not involved in the testing.

Hint: you may need File.separator.

Requirements:
- The Solution class must contain the Properties getProperties(String fileName) method.
- The getProperties method must read the properties from the xml file correctly.
- The getProperties method must correctly read properties from any other file with any extension.
- The getProperties method must return an empty object if an error occurred while reading the properties.

 */
public class ReadingConfigs {
    public Properties getProperties(String fileName) {
        Properties properties = new Properties();
        Path path = Paths.get(fileName);

        try (InputStream is = new FileInputStream(fileName)) {
            String ext = getExtension(path);
            if ("xml".equals(ext)) {
                properties.loadFromXML(is);
            } else {
                properties.load(is);
            }

        } catch (IOException e) {
        }

        return properties;
    }

    private String getExtension(Path path) {
        String p = path.toAbsolutePath().toString();
        int index = p.lastIndexOf(File.separator);
        if (index >= 0) {
            int index2 = p.lastIndexOf(".");
            if (index2 > index) {
                return p.substring(index2 + 1);
            }
            return p;
        } else {
            return p;
        }
    }
}
