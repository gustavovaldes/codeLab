package com.guga.euler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gvaldes
 *
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *
 * What is the 10 001st prime number?
 *
 */
public class P7_10001stPrime {


    public static void main(String[] args) {
        List<Integer> primeNumbers = new ArrayList(); //TODO add unit
        int count = 0;
        primeNumbers.add(2);
        count++;
        main: for (int i = 3; i < Integer.MAX_VALUE; i++) { //TODO implement isPrime based on euler page, compare performance.
            inter1:for (Integer primeNumber : primeNumbers) {
                if(i%primeNumber==0) break;
            }
            inter2:for (int j = 2; j < i; j++) {
                if(i%j==0) continue main;
            }
            primeNumbers.add(i);
            count++;
            if(count==10001){
                System.out.println(i);
                return;
            }
        }

    }
}
