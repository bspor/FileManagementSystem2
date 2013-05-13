package filemanagmentsystem;
import java.util.List;
import java.util.Map;
/**
 * My file formating interface.
 * @author bspor
 */
public interface FileFormatStrategy <V> {
    /**
     * Decode method required of all implementations.
     * @param type any type of value.
     * @return a list of generic values.
     */
    public abstract List<V> decode(List<V> type);
    /**
     * Encode method required of all implementations.
     * @param type any type of value.
     * @return a list of generic values.
     */
    public abstract List<V> encode(List<V> type);
    /**
     * Write the generic list of values to a file required by any implementations.
     * @param type any type of value.
     * @return a list of generic values.
     */
    public abstract String getFormatedList(List<Map> type);
}
