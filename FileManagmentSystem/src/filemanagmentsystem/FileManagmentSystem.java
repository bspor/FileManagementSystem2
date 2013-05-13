package filemanagmentsystem;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
/**
 *
 * @author bspor
 */
public class FileManagmentSystem {
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
        
        
        List s = readFile.readFile(test);
        FileFormatService ffs1 = new FileFormatService(s, fileFormat);
        String lol = ffs1.getFormattedString();
        System.out.println(lol);
        
        
        //FileService ffService = new FileService(readFile, writeFile, 
                                            //fileFormat, test, filePath, append);
        //ffService.writeFileToFile();
        writeFile.writeFile(filePath2, lol, false);
    }
}
