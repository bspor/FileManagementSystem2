package filemanagmentsystem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * This class uses the Text FileReader/FileWriter classes and formats them based
 * on the desired format passed.
 *
 * @author bspor
 */
public class FileService {
    private FileReaderStrategy readFile;
    private FileWriterStrategy writeFile;
    private FileFormatStrategy fileFormat;
    private String filePathIn;
    private String filePathOut;
    private boolean append;

    
    /**
     * Default constructor.
     */
    public FileService() {
    }
    
    
    /**
     * In order to format from one file to another file all of these objects
     * must be passed to instantiate this class and for it to do its work.
     *
     * @param readFile This is the basic text file reader interface type.
     * @param writeFile This is the basic text file writer interface type.
     * @param fileFormat This is the desired formatting strategy to be used for
     * output.
     * @param filePathIn the filepath to read from.
     * @param filePathOut the file path to write to.
     * @param append Pass true if you want to append to the output file, or
     * false if you want to overwrite the output file.
     */
    public FileService(FileReaderStrategy readFile, FileWriterStrategy writeFile,
            FileFormatStrategy fileFormat, String filePathIn, String filePathOut, boolean append) {
        if (readFile == null || writeFile == null || fileFormat == null || filePathIn == null
                || filePathOut == null || filePathIn.length() == 0 || filePathOut.length() == 0) {
            throw new IllegalArgumentException();
        } else {
            this.readFile = readFile;
            this.writeFile = writeFile;
            this.fileFormat = fileFormat;
            this.filePathIn = filePathIn;
            this.filePathOut = filePathOut;
            this.append = append;
        }
    }

    /**
     * This method writes data from a file to a file. This method cannot be called
     * if the default constructor has been called.
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void writeFileToFile() throws FileNotFoundException, IOException {
        writeFile.writeFile(filePathOut, fileFormat.getFormatedList(readFile.readFile(filePathIn)),append);
    }


    /**
     * This method takes a string and writes it to a file.
     * @param s The string to be written to file.
     * @param filePathOut the filepath to write the file to as a string.
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void writeStringToFile(String filePathOut, List s) throws FileNotFoundException, IOException {
        writeFile.writeFile(filePathOut, fileFormat.getFormatedList(s),append);
    }
    
    public void readFormatedFile() throws FileNotFoundException, IOException {
        readFile.readFile("filepath");
    }
}
