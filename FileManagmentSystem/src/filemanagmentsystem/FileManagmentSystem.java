/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanagmentsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author bspor
 */
public class FileManagmentSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileReaderStrategy readFile = new TextFileReader();
        FileWriterStrategy writeFile = new TextFileWriter();
        FileFormatStrategy fileFormat = new CustomCSVFormat();


        String filePath = "src" + File.separatorChar + "filemanagmentsystem"
                + File.separatorChar + "test23";
        String filePath2 = "src" + File.separatorChar + "filemanagmentsystem"
                + File.separatorChar + "test";
        String test = "src" + File.separatorChar + "filemanagmentsystem"
                + File.separatorChar + "test_comma_only.csv";
        boolean append = false;

        FileFormatService ffService = new FileFormatService(readFile, writeFile, 
                                            fileFormat, test, filePath, append);
        ffService.writeFormatedFile();
    }
}
