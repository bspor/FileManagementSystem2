package filemanagmentsystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomCSVFormat implements FileFormatStrategy {
//            //C:\Users\bspor\Documents\IO-Labs\IO-Labs\src\lab1\test
//        String filePath = "src" + File.separatorChar + "lab1"
//                + File.separatorChar + "test";

    private String regexPattern = ".*\\(|\\).*";
    private String keyVal = "";

    @Override
    public List<LinkedHashMap<String, String>> formatFile(List type)
            throws FileNotFoundException, IOException {
        //Put my type list into an array list, making it of type String
        List<String> myList = new ArrayList<>(type);

        //The custom format will store each record as a map.
        Map<String, String> record = new LinkedHashMap<>();
        //Each record will then be placed into my record list 
        List<Map> recordList = new ArrayList<>();
        
        for (String s: myList) {
            System.out.println(s);
        }

        //Pattern pattern = Pattern.compile(regexPattern);
       // Matcher matcher = pattern.matcher(line);
//        if (matcher.find()) {
//            //System.out.println(line); //this satisfies the first step
//            keyVal = line;
//        } else {
//            //System.out.println("Add this to the record " + line);
//            String[] parts = line.split(":");
//            record.put(parts[0], parts[1]);
//        }
//        recordList.add(record);
        //key.put(keyVal, new LinkedHashMap(record))     
        return null;
    }
}
