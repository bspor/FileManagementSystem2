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
public class FileFormatService {
    //take a file and a format and format
       //Takes filereader/write as componants and delegates the work
    private FileReaderStrategy readFile ;
    private FileWriterStrategy writeFile;
    


    public FileFormatService(FileReaderStrategy readFile, FileWriterStrategy writeFile) {
        this.readFile = readFile;
        this.writeFile = writeFile;
    }
    
    public void writeFormatedFile () throws FileNotFoundException, IOException {
        writeFile.writeFile(null, null, true);
    }
    
    public void readFormatedFile () throws FileNotFoundException, IOException {
        readFile.readFile("filepath");
    }
}
