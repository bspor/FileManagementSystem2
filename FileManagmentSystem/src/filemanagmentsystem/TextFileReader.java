/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanagmentsystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bspor
 */
public class TextFileReader implements FileReaderStrategy {

    //C:\Users\bspor\Documents\IO-Labs\IO-Labs\src\lab1\test
    String filePath = "src" + File.separatorChar + "lab1"
            + File.separatorChar + "test";
    File data = new File(filePath);
    String regexPattern = ".*\\(|\\).*";
    int recordLength = 7;
    String keyVal = "";
    List<String> myList = new ArrayList<>();
    BufferedReader in = null;
    String line = "";

    @Override
    public List<String> readFile(String filePath) throws IOException {
        try {
            in = new BufferedReader(new FileReader(filePath));

            while ((line = in.readLine()) != null) {
                myList.add(line + "\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        } finally {
            if (in != null) {
                in.close();
            }
        }
        return myList;
    }
 
 
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //C:\Users\Brandon\Documents\NetBeansProjects\FileManagementSystem2\FileManagmentSystem\src\filemanagmentsystem\test
        String filePath = "src" + File.separatorChar + "filemanagmentsystem"
            + File.separatorChar + "test";
        FileReaderStrategy frs = new TextFileReader();
        System.out.println(frs.readFile(filePath));
       
    }
}