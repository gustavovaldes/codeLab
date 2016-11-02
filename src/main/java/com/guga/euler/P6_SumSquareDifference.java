package com.guga.euler;

/**
 * Created by guga
 * <p>
 * The sum of the squares of the first ten natural numbers is,
 * <p>
 * 1^2 + 2^2 + ... + 10^2 = 385
 * The square of the sum of the first ten natural numbers is,
 * <p>
 * (1 + 2 + ...+ 10)2 = 55^2 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum
 * is 3025 − 385 = 2640.
 * <p>
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
public class P6_SumSquareDifference {

    public static void main(String[] args) {
        System.out.println(calculateV1(10));//TODO write junit
        System.out.println(calculateV1(100));
    }

    public static long calculateV1(int n) {
        double sqrtSum = 0;
        for (int i = 1; i <= n; i++) {
            sqrtSum += Math.pow(i, 2);  //TODO find math formula if possible for this.
        }
        double sumSqrt = Math.pow(n * (n + 1) / 2, 2);
        return (long) (sumSqrt - sqrtSum);
    }
}

