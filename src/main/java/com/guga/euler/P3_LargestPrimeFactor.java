package com.guga.euler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gvaldes
 */
public class P3_LargestPrimeFactor {


    List<Integer> primeNumbers = new ArrayList<Integer>();

    public static void main(String[] args) {
        long  initial = 600851475143L;
        P3_LargestPrimeFactor p = new P3_LargestPrimeFactor();
        p.primeNumbers.add(2);
        List<Integer> primeFactors =  p.getPrimeFactors(initial);
        for (Integer primeFactor : primeFactors) {
            System.out.println(primeFactor);
        }
        System.out.println(getMaxFactor(initial));
    }

    public static long getMaxFactor(long number){
        long factor = 2;
        long max = 1;
        while(number>=factor){
            if(number%factor==0){
                max = factor;
                number=number/max;
            }
            factor++;
        }
        return max;
    }

    public List<Integer> getPrimeFactors(long end){
        List<Integer> primeFactors = new ArrayList<Integer>();
        if(end%2==0){
            primeFactors.add(2);
            end = end/2;
        }
        int initial = 3;
        while(initial<=end){
            if(isPrimeNumber(initial)){
                primeNumbers.add(initial);
                if(end%initial==0){
                    primeFactors.add(initial);
                    end = end/initial;
                }else{
                    initial++;
                }
            }else{
                initial++;
            }
        }
        return primeFactors;
    }

    private boolean isPrimeNumber(long number){
        for (Integer primeFactor : primeNumbers) {
            if(number%primeFactor==0) return false;
        }
        for (int i = primeNumbers.get(primeNumbers.size()-1); i<Math.sqrt(number); i++){
            if(number%i==0) return false;
        }
        return true;
    }


    public static List<Integer> calculatePrimeNumbers(int endNumber){
        List<Integer> primeNumbers = new ArrayList();
        if(endNumber<2) return primeNumbers;
        primeNumbers.add(2);
        main: for (int i = 3; i < endNumber; i++) {
            inter1:for (Integer primeNumber : primeNumbers) {
                if(i%primeNumber==0) break;
            }
            inter2:for (int j = 2; j < i; j++) {
                if(i%j==0) continue main;
            }
            primeNumbers.add(i);
        }
        return  primeNumbers;
    }
}
