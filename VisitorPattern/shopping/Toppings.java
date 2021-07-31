/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;

/**
 * @author Nayeong Kim (s1006313)
 */
public abstract class Toppings extends Ice {
    protected Ice ice;
    
    public Toppings(Ice ice){
        this.ice = ice;
    }
    
    @Override
    public int price(){
        return ice.price();
    }
}