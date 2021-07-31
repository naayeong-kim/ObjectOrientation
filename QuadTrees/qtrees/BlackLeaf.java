/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qtrees;

import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Nayeong Kim (s1006313)
 */
public class BlackLeaf implements QTNode{
    private String colorCode = "00";
    
    public BlackLeaf(){
    }
    
    @Override
    public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
        bitmap.fillArea(x, y, width, false);
    }

    @Override
    public void writeNode(Writer out) {
        try {
            out.write(colorCode);
        } catch (IOException ex) {
            Logger.getLogger(BlackLeaf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public int countBlacks(int size){
        return size * size;
    }
    
}
