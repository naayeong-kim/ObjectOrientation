package qtrees;

import java.io.StringReader;
import java.io.StringWriter;

/**
 * @author Nayeong Kim (s1006313)
 */

public class Qtrees {

    public static void main(String[] args) {
        StringWriter sb = new StringWriter();
        
        String test_tekst = "10011010001010010001010101100011000101000000";
        StringReader input = new StringReader(test_tekst);
        QTree qt = new QTree( input );
        qt.writeQTree(sb);
        System.out.println(sb);     //Test from binary to QTree, then write QTree in stringbuilder
        
        Bitmap bitmap = new Bitmap(8, 8);
        qt.fillBitmap( bitmap );
        System.out.println(bitmap.toString()); //Test from QTree to bitmap
        
        StringWriter sb2 = new StringWriter(); //new stringbuilder
        
        (QTree.bitmap2QTree(0, 0, bitmap.getWidth(), bitmap)).writeNode(sb2); 
        System.out.println(sb2); //Use the bitmap we created in line 17 to test our bitmap2QTree function
                                 //Because you can't really print QTree, we use the writer again.
                                 //Our main code is long, because these are all test cases the TA's can use ;)
                                 
                                
    }

}
