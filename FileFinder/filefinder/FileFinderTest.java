package filefinder;

import java.io.IOException;

/**
 * @author Nayeong Kim (S1006313)
 */
public class FileFinderTest {

    public FileFinderTest() {
        try {
            String goal = "WTF.jpg";
            String root = "/Users";
            FileFinder ff = new FileFinder(root); 
            ff.findFile(goal);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void FileFinderTest() {
        try {
            String goal = "WTF.jpg";
            String root = "/Users";
            FileFinder ff = new FileFinder(root);
            ff.findFile(goal);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
