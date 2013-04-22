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
public class TextFileReader<T> implements FileReaderStrategy {
    BufferedReader in = null;
    String line = "";
    List<String> myList = new ArrayList<>();
    @Override
    public List<T> readFile(String filePath) throws IOException {
        
        try {
            in = new BufferedReader(new FileReader(filePath));

            while ((line = in.readLine()) != null) {
                myList.add(line);
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
//        for (String s: myList) {
//            System.out.println(s + "here I am ");
//        }
        return (List<T>) myList;
    }   
}