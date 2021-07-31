/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;

/**
 * @author Nayeong Kim (s1006313)
 */
public class WaterMelon extends Item {
    private final double price = 4.50;
    private final double shipping = 6.75;
    protected String description = "WaterMelon";

    
    @Override
    public double price() {
        return price;
    }

    @Override
    public double shipping() {
        return shipping;
    }

    @Override
    public String giveDescription() {
        return description;
    }
   
}
