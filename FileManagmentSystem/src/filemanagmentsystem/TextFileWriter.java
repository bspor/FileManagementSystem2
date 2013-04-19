package filemanagmentsystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bspor
 */
public class TextFileWriter implements FileWriterStrategy {
    @Override
   public void writeFile(String filePath, List type, boolean append) 
            throws FileNotFoundException, IOException {
        File data = new File(filePath);
        PrintWriter out = new PrintWriter(
                new BufferedWriter(new FileWriter(data, append)));
        try {
            //File file = new File(filePath);
           
            System.out.println(type.getClass());
            List<String> myList = new ArrayList<>(type);

            // if file doesnt exists, then create it
            if (!data.exists()) {
                data.createNewFile();
            }
            for (String s: myList) {
                out.write(s);
            }
            //out.write();
            out.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }
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
        
        frw.writeFile(filePath, frs.readFile(filePath2), false);
        System.out.println("Done Did");
        //System.out.println(frw.writeFile(filePath, frs.readFile(filePath2), true));
       
    }
}
