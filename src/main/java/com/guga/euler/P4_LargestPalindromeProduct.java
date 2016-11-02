package com.guga.euler;

/**
 * \
 * Created by gvaldes
 */
public class P4_LargestPalindromeProduct {

    public static void main(String[] args) {
        int size = 999;
        int stop = (size + 1) / 10;
        System.out.println(stop);
        int maxA = 0;
        int maxB = 0;
        int currentMax = 0;
        while(size%11!=0){// improvement 3 (if number xyzzyx)-> 11(9091x+10010y+1100z) -> 11 multiple
            size--;
        }
        for (int i = size; i > stop; i=i-11) {  // improvement 3
            for (int j = 999; j >= i; j--) { // j>=1 instead stop: improvement 1
                if (i * j < currentMax) break;// improvement 2
                if (isPalindrome("" + i * j)) {
                    System.out.println(i + "x" + j + "=" + i * j);
                    if (i * j > currentMax) {
                        maxA = i;
                        maxB = j;
                        currentMax = maxA * maxB;
                    }
                }
            }
        }
        System.out.println("RESULT:"+maxA + "x" + maxB + "=" + maxA * maxB);
        System.out.println("RESULT:"+currentMax);
    }


    private static boolean isPalindrome(String value) {
        int size = value.length() - 1;
        for (int i = 0; i < size; i++) {
            if (value.charAt(i) != value.charAt(size - i)) return false;
        }
        return true;
    }
}
