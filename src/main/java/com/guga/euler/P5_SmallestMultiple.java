package com.guga.euler;

import java.util.List;

/**
 * Created by gvaldes
 */
public class P5_SmallestMultiple {

    public static void main(String[] args) {
        int step = 20;
        long number = step;
        int base = step;
        while (base>1){
            if(number%base==0){
                base--;
            }else{
                number+=step;
                base = step;
            }
        }
        System.out.println(number);

        P5_SmallestMultiple.smallestMultiple(step);
    }


    public static void smallestMultiple(int number){
        List<Integer> primeNumbers = P3_LargestPrimeFactor.calculatePrimeNumbers(number);
        long result = 1;
        for (Integer primeNumber : primeNumbers) {
            System.out.println(primeNumber);
            result*=primeNumber;
        }
        System.out.println(result);
    }
}
