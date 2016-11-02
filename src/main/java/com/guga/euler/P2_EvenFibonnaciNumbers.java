package com.guga.euler;

/**
 * Created by gvaldes
 */
public class P2_EvenFibonnaciNumbers {

    public static void main(String[] args) {
        long f0 = 1;
        long f1 = 1;
        long f = 0;
        int limit = 4000000;
        long sum = 0;
        while(f<limit){
            if(f%2==0 )sum+=f;
            f = f0+f1;
            f0 = f1;
            f1 = f;
        }
        System.out.println(sum);
    }
}
