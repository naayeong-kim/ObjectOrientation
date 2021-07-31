/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;

/**
 * @author Nayeong Kim (s1006313)
 */
public class YoghurtIce extends Ice{
    private final int price = 200;
    protected String description = "Yoghurt Ice";
    
    @Override
    public int price() {
        return price;
    }
    
    @Override
     public String giveDescription(){
        return description;
    }
}