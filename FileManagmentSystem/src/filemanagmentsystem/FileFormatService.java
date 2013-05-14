package filemanagmentsystem;

import java.util.List;
import java.util.Map;

/**
 *
 * @author bspor
 */
public class FileFormatService<T> {

    private List<T> in;
    private String out;
    FileFormatStrategy fileFormat;

    ;

    /**
     * Takes a list and formats it to a specification as constructors.
     * @param in a List of T.
     * @param fileFormat file format interface.
     */
    public FileFormatService(List<T> in, FileFormatStrategy fileFormat) {
        if (fileFormat == null || in.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            this.in = in;
            this.fileFormat = fileFormat;
        }
    }

    /**
     * Get the formatted string.
     *
     * @return formatted string.
     */
    public String getFormattedString() {
        return fileFormat.getFormatedList(in);
    }
}
