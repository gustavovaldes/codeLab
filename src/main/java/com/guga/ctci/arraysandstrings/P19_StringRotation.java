package com.guga.ctci.arraysandstrings;

/**
 * Created by guga
 */
public class P19_StringRotation {

    public static void main(String[] args) {
        String word1 = "hi hohu";
        String word2 = "huhi ho";
        String word3 = "huhi";
        String word4 = "hihhohu";

        System.out.println("Test1 :" + isRotation(word1, word2));
        System.out.println("Test2 :" + isRotation(word2, word1));
        System.out.println("Test3 :" + !isRotation(word1, word3));
        System.out.println("Test4 :" + !isRotation(word2, word3));
        System.out.println("Test5 :" + !isRotation(word2, word4));

    }

    public static boolean isRotation(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        return ((word1 + word1).contains(word2));
    }
}
