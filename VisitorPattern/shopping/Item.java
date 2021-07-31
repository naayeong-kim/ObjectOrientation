/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;

/**
 * @author Nayeong Kim (s1006313)
 */
public abstract class Item{
    protected String description = "Unknown";
    
    public abstract double price();
    public abstract double shipping();
    public abstract String giveDescription();
}
