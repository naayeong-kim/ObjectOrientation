/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qtrees;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Nayeong Kim (s1006313)
 * @author Lizzy Grootjen (s1001148)
 */
public class GrayNode implements QTNode {

    private final QTNode[] children;
    private String code = "1";

    public GrayNode(Reader input) {
        QTNode[] children = new QTNode[4];

        for (int i = 0; i < children.length; i++) {
            QTNode child = QTree.getRecursiveCall(input);
            children[i] = child;
        }

        this.children = children;
    }

    public GrayNode(int x, int y, int width, Bitmap bitmap) {
        QTNode[] children = new QTNode[4];
        
        width = width/2;
        
        children[0] = QTree.bitmap2QTree(x, y, width, bitmap);
        children[1] = QTree.bitmap2QTree(x + width, y, width, bitmap);
        children[2] = QTree.bitmap2QTree(x + width, y + width, width, bitmap);
        children[3] = QTree.bitmap2QTree(x, y + width, width, bitmap);       
        
        this.children = children;
    }

    @Override
    public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
        if (countBlacks(width) == 0) {
            bitmap.fillArea(x, y, width, true);
        }
        if (countBlacks(width * width) == width) {
            bitmap.fillArea(x, y, width, false);
        } else {
            width = width / 2;
            children[0].fillBitmap(x, y, width, bitmap);
            children[1].fillBitmap(x + width, y, width, bitmap);
            children[2].fillBitmap(x + width, y + width, width, bitmap);
            children[3].fillBitmap(x, y + width, width, bitmap);

        }
    }

    @Override
    public void writeNode(Writer out) {
        try {
            out.write(code);
            for (QTNode child : children) {
                child.writeNode(out);
            }
        } catch (IOException ex) {
            Logger.getLogger(GrayNode.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public int countBlacks(int size) {
        int blacks = 0;
        for (QTNode node : children) {
            blacks += node.countBlacks(size / 2);
        }
        return blacks;
    }

}
