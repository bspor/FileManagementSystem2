/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanagmentsystem;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author bspor
 */
public interface FileReaderStrategy<V>  {
    //Mabe enforce list or map
    public V readFile(String filePath)throws FileNotFoundException,IOException;
}
