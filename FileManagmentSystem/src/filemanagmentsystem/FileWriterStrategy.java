package filemanagmentsystem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author bspor
 */
public interface FileWriterStrategy <T>{
//Mabe enforce list or map
    public abstract void writeFile(String filePath, List<T> type, boolean append)
            throws FileNotFoundException,IOException;
}
