/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanagmentsystem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Text file reader interface.
 * @author bspor
 */
public interface FileReaderStrategy<V>  {

    /**
     * Method to read any text file.
     * @param filePath file path to read file.
     * @return returns a list of values.
     * @throws FileNotFoundException
     * @throws IOException
     */
    public abstract List<V> readFile(String filePath)
            throws FileNotFoundException,IOException;
}
