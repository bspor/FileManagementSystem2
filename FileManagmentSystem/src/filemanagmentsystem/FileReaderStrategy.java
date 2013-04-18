/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanagmentsystem;

/**
 *
 * @author bspor
 */
public interface FileReaderStrategy {
    //Mabe enforce list or map
    public Object[] readFile(String filePath);
}
