/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanagmentsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Brandon
 */
public class CustomFormat   {
    //C:\Users\bspor\Documents\IO-Labs\IO-Labs\src\lab1\test
    String filePath = "src" + File.separatorChar + "lab1"
                + File.separatorChar + "test";
    File data = new File(filePath);
    String regexPattern = ".*\\(|\\).*";
    
}
