package CodeGym.Medium;

import java.io.*;

/*
Implement the logic of the getAllDataFromInputStream method. It should return a StringWriter containing all data from the passed stream.
The returned object must not be null under any circumstances.
The main method is not involved in testing.

Requirements:
- The public static getAllDataFromInputStream (InputStream) method must exist.
- The getAllDataFromInputStream (InputStream) method must return StringWriter.
- The getAllDataFromInputStream (InputStream) method should return a StringWriter that contains all the data from the passed stream.
- The returned object must not be null under any circumstances.
 */
public class ReadingFromStream {
    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter writer = new StringWriter();
        if (is != null) {
            char[] buffer = new char[1024];
            try (Reader reader = new BufferedReader(new InputStreamReader(is))) {
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            }
        }
        return writer;
    }
}
