package filemanagmentsystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is a generic text file writing class.
 *
 * @author bspor
 */
public class TextFileWriter<T> implements FileWriterStrategy {
    private static final String CRLF = "\n";

    /**
     * Method to write a text file.
     *
     * @param filePath required filepath for file to be opened.
     * @param type any type of list.
     * @param append set to true to append to file, false to overwrite
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public void writeFile(String filePath, List type, boolean append)
            throws FileNotFoundException, IOException {
        File data = new File(filePath);
        PrintWriter out = new PrintWriter(
                new BufferedWriter(new FileWriter(data, append)));
        try {
            List<T> myList = new ArrayList<>(type);
            // if file doesnt exists, then create it
            if (!data.exists()) {
                data.createNewFile();
            }

            for (T t : myList) {
                out.write(t + CRLF);
            }
            out.close();

        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    /**
     * Method to write a text file.
     *
     * @param filePath required filepath for file to be opened.
     * @param s a String to be written to file
     * @param append set to true to append to file, false to overwrite
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public void writeFile(String filePath, String s, boolean append)
            throws FileNotFoundException, IOException {
        File data = new File(filePath);
        PrintWriter out = new PrintWriter(
                new BufferedWriter(new FileWriter(data, append)));
        try {
            // if file doesnt exists, then create it
            if (!data.exists()) {
                data.createNewFile();
            }
            out.write(s + CRLF);

            out.close();

        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
