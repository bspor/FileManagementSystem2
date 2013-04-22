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
    private FileFormatStrategy fileFormat;
    private String filePathIn;
    private String filePathOut;
    private boolean append;

    //Many different constructors for this class for ease of use

    public FileFormatService(FileReaderStrategy readFile, FileWriterStrategy writeFile, FileFormatStrategy fileFormat, String filePathIn, String filePathOut, boolean append) {
        this.readFile = readFile;
        this.writeFile = writeFile;
        this.fileFormat = fileFormat;
        this.filePathIn = filePathIn;
        this.filePathOut = filePathOut;
        this.append = append;
    }
    
    
    public void writeFormatedFile () throws FileNotFoundException, IOException {
        writeFile.writeFile(filePathOut, fileFormat.writeToFile(readFile.readFile(filePathIn)), append);
        //writeFile.writeFile(null, null, true);
    }
    
    public void readFormatedFile () throws FileNotFoundException, IOException {
        readFile.readFile("filepath");
    }
}
