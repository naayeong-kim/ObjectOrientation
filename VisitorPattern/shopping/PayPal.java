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
public class PayPal implements PaymentStrategy {
    private String  email;
    private String  pw;
    
    public PayPal(String email, String pw) {
        this.email = email;
        this.pw = pw;
    }

    @Override
    public boolean pay(double amount) {
        System.out.format("Pay &1.2f with paypal for %s\n ", amount, email);
        return true;
    }
}
