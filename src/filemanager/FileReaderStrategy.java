/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanager;

/**
 *
 * @author bspor
 */
public interface FileReaderStrategy {
    //Mabe enforce list or map
    public Object[] readFile(String filePath);
}
