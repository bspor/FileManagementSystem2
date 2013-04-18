/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanagmentsystem;

/**
 *
 * @author bspor
 */
public class FileFormatService {
    //take a file and a format and format
       //Takes filereader/write as componants and delegates the work
    private FileReaderStrategy readFile ;
    private FileWriterStrategy writeFile;
    
    
    
    //read input
    //write file
    //copy file

    public FileFormatService(FileReaderStrategy readFile, FileWriterStrategy writeFile) {
        this.readFile = readFile;
        this.writeFile = writeFile;
    }
    
    public void writeFormatedFile () {
        writeFile.writeFile(null, null, true);
    }
    
    public void readFormatedFile () {
        readFile.readFile("filepath");
    }
}
