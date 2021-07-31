/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;

/**
 * @author Nayeong Kim (s1006313)
 */
public class ChocolateDip extends Toppings{
    
    public ChocolateDip(Ice ice){
        super(ice);
    }
    
    @Override
    public int price(){
        if(ice instanceof WhippedCream){
            return 0;
        }
        return super.price() + 30;
    }

    @Override
    public String giveDescription() {
        if(ice instanceof WhippedCream){
            return "Combination not allowed";
        }
        return ice.giveDescription() + ", chocolate dip";
    }
}