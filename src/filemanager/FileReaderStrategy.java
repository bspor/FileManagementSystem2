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
    public Object[] readFile(String filePath);
}
