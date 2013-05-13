package filemanagmentsystem;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Generic text file reader class.
 *
 * @author bspor
 */
public class TextFileReader<T> implements FileReaderStrategy {

    BufferedReader in = null;
    String line = "";
    List<String> myList = new ArrayList<>();

    /**
     * Method for opening and reading any text file.
     *
     * @param filePath required path of file
     * @return List of Strings.
     * @throws IOException
     */
    @Override
    public List<T> readFile(String filePath) throws IOException {
        
        try {
            in = new BufferedReader(new FileReader(filePath));

            while ((line = in.readLine()) != null) {
                myList.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e.getMessage());
        } catch (IOException e) {
           throw new IllegalArgumentException(e.getMessage());
        } finally {
            if (in != null) {
                in.close();
            }
        }
        return (List<T>) myList;
    }
}