/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filemanagmentsystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


        Map<String, String> record = new LinkedHashMap<>();
        List<Map> recordList = new ArrayList<>();


        BufferedReader in = null;
        String line = "";
        try {
            in = new BufferedReader(new FileReader(data));
            while (line != null) {
                try {
                    // strips out any carriage return chars
                    line = in.readLine();  // strips out any carriage return chars
                } catch (IOException ex) {
                    Logger.getLogger(TextFileReader.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (line != null) {
                    Pattern pattern = Pattern.compile(regexPattern);
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        //System.out.println(line);
                        keyVal = line;
                    } else {
                        //System.out.println("Add this to the record " + line);
                        String[] parts = line.split(":");
                        record.put(parts[0], parts[1]);
                    }
                    key.put(keyVal, new LinkedHashMap(record));
                }
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } finally {
            try {
                in.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
            }
//        }
}

    @Override
    public Object[] readFile(String filePath) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}