/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;

/**
 * @author Nayeong Kim (s1006313)
 */
public class Sprinkles extends Toppings{
        
    public Sprinkles(Ice ice){
        super(ice);
    }
    
    @Override
    public int price(){
        return super.price();
    }

    @Override
    public String giveDescription() {
         return ice.giveDescription() + ", sprinkles";
    }
}