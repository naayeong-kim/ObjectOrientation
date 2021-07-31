/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;

import java.util.*;

/**
 * @author Nayeong Kim (s1006313)
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Ice> ices = new LinkedList<>();

        ices.add(new VanillaIce());
        ices.add(new WhippedCream(new YoghurtIce()));
        ices.add(new Sprinkles(new ChocolateDip(new ChocolateDip(new VanillaIce()))));
        ices.add(new WhippedCream(new ChocolateDip(new YoghurtIce())));
        ices.add(new ChocolateDip(new WhippedCream(new Sprinkles(new YoghurtIce()))));

        System.out.println("[ICE SHOP]");
        for (Ice ice : ices) {
            System.out.println(ice.giveDescription() + ": " + ice.price() +" cents");
        }
        
        System.out.println("=================================");
        
        System.out.println("[WELCOME TO ONLINE STORE]");
        
        ShoppingCart cart = new ShoppingCart();
        WaterMelon waterMelon = new WaterMelon();
        WaterMelon waterMelon2 = new WaterMelon();
        WashingMachines washingMachines = new WashingMachines();
        
        cart.addItem(waterMelon);
        cart.addItem(waterMelon2);
        cart.addItem(washingMachines);
        cart.removeItem(waterMelon);
        
        cart.changePaymentMethod(new CreditCard("card1", "12/08/2019"));
        cart.pay();
    }

}