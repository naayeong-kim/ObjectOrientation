
package qtrees;

import java.io.Writer;

/**
 * @author Nayeong Kim (s1006313)
 */
public interface QTNode {
    public void fillBitmap( int x, int y, int width, Bitmap bitmap );
    public void writeNode( Writer out );
    public int countBlacks(int size);
}
