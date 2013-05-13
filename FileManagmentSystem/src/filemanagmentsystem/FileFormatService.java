package filemanagmentsystem;

import java.util.List;
import java.util.Map;

/**
 *
 * @author bspor
 */
public class FileFormatService {
    private List in;
    private String out;    
    FileFormatStrategy fileFormat;;

    public FileFormatService(List in, FileFormatStrategy fileFormat) {
        this.in = in;
        this.fileFormat = fileFormat;
    }
    
    
    public String getFormattedString () {
        return fileFormat.getFormatedList(in);
    }
}
