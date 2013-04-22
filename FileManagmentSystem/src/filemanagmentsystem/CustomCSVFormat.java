package filemanagmentsystem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomCSVFormat <T> implements FileFormatStrategy {
//            //C:\Users\bspor\Documents\IO-Labs\IO-Labs\src\lab1\test
//        String filePath = "src" + File.separatorChar + "lab1"
//                + File.separatorChar + "test";

    private String regexPattern = ".*\\(|\\).*";
    private String keyVal = "";
    private String split = ":";
    private String splitComma = ",";
    private static final String CRLF = "\n";

    @Override
    public List<Map> decode(List type){
        //Put my type list into an array list, making it of type String
        List<String> myList = new ArrayList<>(type);

        //The custom format will store each record as a map.
        Map<String, String> record = new LinkedHashMap<>();
        //Each record will have a key to make easy queries
        Map<String, Map> key = new LinkedHashMap<>();
        //Each record will then be placed into my record list 
        List<Map> recordList = new ArrayList<>();

        for (String s : myList) {
            Pattern pattern = Pattern.compile(regexPattern);
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) {
                System.out.println(s); //this satisfies the first step
                keyVal = s;
            } else {
                //System.out.println("Add this to the record " + line);
                System.out.println(s);
                String[] parts = s.split(split);
                record.put(parts[0], parts[1]);
                key.put(keyVal, new LinkedHashMap(record));
            }
        }
        recordList.add(key);
        return recordList;
    }

    @Override
    public List encode(List type) {
        //Put my type list into an array list, making it of type String
        List<String> myList = new ArrayList<>(type);

        //The custom format will store each record as a map.
        Map<String, String> record = new LinkedHashMap<>();
        //Each record will have a key to make easy queries
        Map<String, Map> key = new LinkedHashMap<>();
        //Each record will then be placed into my record list 
        List<Map> recordList = new ArrayList<>();
        //assumes header for now
        String possibleHeader = myList.get(0);
        String[] headerList = possibleHeader.split(splitComma);
        
       
        for (int i = 1; i < myList.size(); i ++ ) {
            //System.out.println(myList.get(i) + "?");
            
            String temp = myList.get(i);
            String[] values = temp.split(splitComma);
            for (int j = 0; j < headerList.length; j++) {
                record.put(headerList[j] + split, values[j]);
            }
            keyVal = "(" + i + ")";
            key.put(keyVal, new LinkedHashMap(record));
            
        }
        recordList.add(key);
        return recordList;
    }
    
    @Override
    public List writeToFile  (List type) {
        Collection<T> myCollection = encode(type);
        //List<T> tempList = encode(type);
        List<StringBuilder> myList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
      Iterator itr = myCollection.iterator();
      
      while(itr.hasNext()) {
         Map element = (Map) itr.next();
         String[] key;
         for (Object o: element.keySet()) {
             sb.append(o).append(CRLF);
             Map myRecord = (Map) element.get(o);
             for (Object o2: myRecord.keySet()) {
                 sb.append(o2).append(myRecord.get(o2));
                 sb.append(CRLF);
             }
         }
         myList.add(sb);
      }
        return myList;        
    }
}
