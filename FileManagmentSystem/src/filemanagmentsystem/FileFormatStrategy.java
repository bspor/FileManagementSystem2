/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanagmentsystem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author bspor
 */
public interface FileFormatStrategy <V> {
    public abstract List<V> formatFile(List<V> type)
            throws FileNotFoundException,IOException;
}
