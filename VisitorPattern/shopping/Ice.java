/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;

/**
 * @author Nayeong Kim (s1006313)
 */
public abstract class Ice{
    protected String description = "unknown ice";
    
    public abstract int price();  
    public abstract String giveDescription();
}