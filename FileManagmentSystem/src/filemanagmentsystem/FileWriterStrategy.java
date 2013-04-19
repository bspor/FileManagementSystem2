package filemanagmentsystem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author bspor
 */
public interface FileWriterStrategy<T> {
    public T writeFile(String filePath, T type, boolean append)
            throws FileNotFoundException, IOException;
}
