/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filefinder;

import static filefinder.FileFinderTest.FileFinderTest;
import java.util.Random;

/**
 * @author Nayeong Kim (S1006313)
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        
        //Assignment 1
        FileFinderTest();
        
        //Assignment 2    
        int[] randomNumbers = new int[1000000];
        

        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = randomFill();
        }
        long start = System.currentTimeMillis();
        MergeSort.sort(randomNumbers);
        System.out.println(System.currentTimeMillis() - start);
        
        long start2 = System.currentTimeMillis();
        MergeSort.sortWithThread(randomNumbers);
        System.out.println(System.currentTimeMillis() - start2);
        
        
    }

    private static int randomFill() {
        Random rand = new Random();
        return rand.nextInt();
    }
}
