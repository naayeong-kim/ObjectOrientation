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
public class ShoppingCart {

    private List<Item> items;
    private int watermelon;
    private int wineglasses;
    private int washingmachines;
    private double price = 0;
    PaymentStrategy strategy;
    private boolean paid = false;

    public ShoppingCart() {
        items = new ArrayList();
        strategy = new IDeal("ING", "Charles", 1234);
    }

    public List<Item> getItems() {
        return this.items;
    }

    public boolean addItem(Item item) {
        if (paid) {
            return false;
        } else {
            items.add(item);
            showCart();
            return true;
        }

    }

    public void removeItem(Item item) {
        int itemIdx = 100;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) == item) {
                itemIdx = i;
            }
        }
        if (itemIdx != 100) {
            items.remove(itemIdx);
        } else {
            System.out.println(item.description + " is not in your shopping cart");
        }

        showCart();
    }

    public void showCart() {
        watermelon = 0;
        washingmachines = 0;
        wineglasses = 0;
        
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).price() == 499) {
                washingmachines++;
                if (washingmachines == 1) {
                    this.price += items.get(i).shipping();
                }
            } else if (items.get(i).price() == 4.50) {
                watermelon++;
                if (watermelon == 1) {
                    this.price += items.get(i).shipping();
                }
            } else {
                wineglasses++;
                if (wineglasses == 1) {
                    this.price += items.get(i).shipping();
                }
            }
        }

        System.out.println("\n\t[Your shopping cart]\n"
                + "\tWaterMelon X " + watermelon + "\n"
                + "\tWine Glasses X " + wineglasses + "\n"
                + "\tWashing Machines X " + washingmachines);

        totalPrice(price);
    }

    public void changePaymentMethod(PaymentStrategy p) {
        strategy = p;
    }

    public void totalPrice(double price) {
        for (Item item : items) {
            this.price += item.price();
        }

        System.out.println("\t=>Total Price: " + this.price);
        this.price = 0;
    }

    public boolean pay() {
        double sum = price;
        if (paid || sum == 0.0) {
            return false;
        } else {
            return paid = strategy.pay(sum);
        }
    }
}
