package filemanagmentsystem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author bspor
 */
public interface FileWriterStrategy <T>{

    /**
     * Method to write a text file.
     * @param filePath required filepath for file to be opened.
     * @param type any type 
     * @param append set to true to append to file, false to overwrite
     * @throws FileNotFoundException
     * @throws IOException
     */
    public abstract void writeFile(String filePath, List<T> type, boolean append)
            throws FileNotFoundException,IOException;
}
