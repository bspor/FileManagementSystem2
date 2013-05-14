package filemanagmentsystem;

import java.util.List;
import java.util.Map;

/**
 *
 * @author bspor
 */
public class FileFormatService <T> {
    private List<T> in;
    private String out;    
    FileFormatStrategy fileFormat;;

    public FileFormatService(List<T> in, FileFormatStrategy fileFormat) {
        this.in = in;
        this.fileFormat = fileFormat;
    }
    
    
    public String getFormattedString () {
        return fileFormat.getFormatedList(in);
    }
}
