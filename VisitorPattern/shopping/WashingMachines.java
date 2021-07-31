/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;

/**
 * @author Nayeong Kim (s1006313)
 */
public class WashingMachines extends Item{
    private final double price = 499;
    private final double shipping = 30.00;
    protected String description = "Washing Machines";

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
