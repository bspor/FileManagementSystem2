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
    public List formatFile(String filePath) throws FileNotFoundException, IOException {
         File data = new File(filePath);



        Map<String, Map> key = new LinkedHashMap<String, Map>();
        Map<String, String> record = new LinkedHashMap<String, String>();
        List<Map> recordList = new ArrayList<Map>();


        BufferedReader in = null;
        String line = "";
        try {
            in = new BufferedReader(new FileReader(data));
            while (line != null) {
                //System.out.println(line);
                line = in.readLine();  // strips out any carriage return chars
                if (line != null) {
                    System.out.println(line); //this satisfies the first step
                    Pattern pattern = Pattern.compile(regexPattern);
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        //System.out.println(line); //this satisfies the first step
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
        }        
        return null;
    }
}
