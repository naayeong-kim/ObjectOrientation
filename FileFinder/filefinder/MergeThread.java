/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filefinder;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Nayeong Kim (s1006313)
 */
public class MergeThread implements Runnable{
    private int[] numbers;
    
    public MergeThread(int[] numbers){
        this.numbers = numbers;
    }

    @Override
    public void run() {
        try {
            MergeSort.sortWithThread(numbers);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }
}
