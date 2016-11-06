package com.guga.euler;

/**
 * Created by guga
 * <p>
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * <p>
 * a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * <p>
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class P9_SpecialPythagoreanTriplet {

    public static void main(String[] args) {
        int result = calculateSides(1000);// 3 , 4 => 5  ( 9 + 16 = 25)
        System.out.println(result);

        int result2 = calculateSides(12);// 3 , 4 => 5  ( 9 + 16 = 25)
        System.out.println(result2);
    }


    /*
    brute force implementation
    TODO implement using some parametrization/limits for better performance
    TODO more test
    TODO clean brute force to include at least good limits.
     */
    public static int calculateSides(int sum) {
        int a = 1;
        while (a < sum) {
            a++;
            int b = a + 1;
            while (b < sum - a) {
                Double cSqrt = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
                if (cSqrt.intValue() == cSqrt) {
                    if (a + b + cSqrt == sum) {
                        System.out.println(a + " , " + b + " => " + cSqrt);
                        return (int) (a * b * cSqrt);
                    }
                }
                b++;
            }
        }
        return -1;
    }

}
