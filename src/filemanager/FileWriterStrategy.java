package filemanager;
/**
 *
 * @author bspor
 */
public interface FileWriterStrategy {
    public String writeFile(String filePath, Object[] objects, boolean append);
}
