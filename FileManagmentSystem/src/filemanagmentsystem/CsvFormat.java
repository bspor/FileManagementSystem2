package filemanagmentsystem;
import java.util.List;
/**
 * Standard CSV formatter.
 * @author bspor
 */
public class CsvFormat implements FileFormatStrategy {

    /**
     * Decode method for any 
     * @param type
     * @return
     */
    @Override
    public List decode(List type) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List encode(List type) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List writeToFile(List type) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
