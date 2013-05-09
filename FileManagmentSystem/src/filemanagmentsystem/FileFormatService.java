package filemanagmentsystem;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This class uses the Text FileReader/FileWriter classes and formats them based
 * on the desired format passed.
 *
 * @author bspor
 */
public class FileFormatService {
    private FileReaderStrategy readFile;
    private FileWriterStrategy writeFile;
    private FileFormatStrategy fileFormat;
    private String filePathIn;
    private String filePathOut;
    private boolean append;

    /**
     * In order to format a file all of these objects must be passed to
     * instantiate this class and for it to do its work.
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
    public FileFormatService(FileReaderStrategy readFile, FileWriterStrategy writeFile,
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
     * This method writes the file to the specifications passed on the class
     * initialization.
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void writeFormatedFile() throws FileNotFoundException, IOException {
        writeFile.writeFile(filePathOut, fileFormat.writeToFile(readFile.readFile(filePathIn)), append);
        //writeFile.writeFile(null, null, true);
    }

    public void readFormatedFile() throws FileNotFoundException, IOException {
        readFile.readFile("filepath");
    }
}
