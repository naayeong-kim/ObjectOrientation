package qtrees;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Nayeong Kim (s1006313)
 */
public class QTree {

    QTNode root;

    public QTree(Reader input) {
        root = readQTree(input);
    }

    public QTree(Bitmap bitmap) {
        root = bitmap2QTree(0, 0, bitmap.getWidth(), bitmap);
    }

    public void fillBitmap(Bitmap bitmap) {
        root.fillBitmap(0, 0, bitmap.getWidth(), bitmap);
    }

    public void writeQTree(Writer sb) {
        root.writeNode(sb);
    }

    private static QTNode readQTree(Reader input) {
        try {
            int c = 0;
            while ((c = input.read()) >= 0) {
                switch ((char) c) {
                    case '1':
                        QTNode gray = new GrayNode(input);
                        return gray;
                    case '0':
                        c = input.read();
                        if ((char) c == '0') {
                            QTNode black = new BlackLeaf();
                            return black;
                        } else if ((char) c == '1') {
                            QTNode white = new WhiteLeaf();
                            return white;
                        }
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(QTree.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private static boolean checkWhite(Bitmap bitmap, int width, int x, int y) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                if(!(bitmap.getBit(i+x, j+y)))
                    return false;
            }
        }
        return true;
    }
    private static boolean checkBlack(Bitmap bitmap, int width, int x, int y) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                if(bitmap.getBit(i+ x, j+y))
                    return false;
            }
        }
        return true;
    }

    public static QTNode bitmap2QTree(int x, int y, int width, Bitmap bitmap) {
        if(checkWhite(bitmap, width, x, y)){
            QTNode white = new WhiteLeaf();
            return white;
        }
        if(checkBlack(bitmap, width, x ,y)){
            QTNode black = new BlackLeaf();
            return black;
        }
        else{
            QTNode gray = new GrayNode(x, y, width, bitmap);
            return gray;
        }
        
    }

    public static QTNode getRecursiveCall(Reader input) {
        return readQTree(input);
    }

}
