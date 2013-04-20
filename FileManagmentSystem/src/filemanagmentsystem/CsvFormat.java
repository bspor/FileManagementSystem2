package filemanagmentsystem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author bspor
 */
public class CsvFormat implements FileFormatStrategy {

    //Returns encoded form of data
//    public List<LinkedHashMap<String, String>> decode(List<String> csvData,
//            boolean hasHeader ) {
//        /*
//         * retrieve a keyset of keys
//         * loop through the list and retrieve each map as unique record
//         * loop through value collection and add to a string followed by a comma
//         * 
//         */
//        return null;
//    }

    @Override
    public List<LinkedHashMap<String, String>> formatFile(List type) throws FileNotFoundException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
