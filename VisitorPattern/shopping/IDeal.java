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
public class IDeal implements PaymentStrategy {
    private String  bank;
    private String  account;
    private int     pin;
    
    public IDeal(String bank, String account, int pin) {
        this.bank = bank;
        this.account = account;
        this.pin = pin;
    }

    @Override
    public boolean pay(double amount) {
        System.out.format("Pay &1.2f with IDeal %s of bank %s\n", amount, account, bank);
        return true;
    }
}
