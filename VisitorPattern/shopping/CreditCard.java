/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;

import java.util.Scanner;

/**
 * @author Nayeong Kim (s1006313)
 */
public class CreditCard implements PaymentStrategy {
    private String  card;
    private String  expiration;
    
    public CreditCard(String card, String expiration) {
        this.card = card;
        this.expiration = expiration;
    }

    @Override
    public boolean pay(double amount) {
        System.out.format("Pay &1.2f with card %d\n", amount, card);
        return true;
    }
}
