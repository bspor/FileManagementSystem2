package filemanagmentsystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author bspor
 */
public class TextFileWriter implements FileWriterStrategy {
    @Override
    public Object writeFile(String filePath, Object type, boolean append) 
            throws FileNotFoundException, IOException {
        File data = new File(filePath);
        PrintWriter out = new PrintWriter(
                new BufferedWriter(new FileWriter(data, append)));
        try {
            File file = new File(filePath);

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            out.write(type.toString());
            out.close();

            System.out.println("Done");

        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }
        return "LOSt";
    }
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //C:\Users\Brandon\Documents\NetBeansProjects\FileManagementSystem2\FileManagmentSystem\src\filemanagmentsystem\test
        String filePath = "src" + File.separatorChar + "filemanagmentsystem"
            + File.separatorChar + "test2";
        String filePath2 = "src" + File.separatorChar + "filemanagmentsystem"
            + File.separatorChar + "test";
        FileReaderStrategy frs = new TextFileReader();
        //System.out.println(frs.readFile(filePath));
        FileWriterStrategy frw = new TextFileWriter();
        System.out.println(frw.writeFile(filePath, frs.readFile(filePath2), true));
       
    }
}
