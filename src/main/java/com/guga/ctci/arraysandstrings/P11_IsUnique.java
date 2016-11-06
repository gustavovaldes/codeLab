package com.guga.ctci.arraysandstrings;

import java.util.Arrays;

/**
 * Created by guga
 * <p>
 * Determine if string has all unique characters. What if is not possible to use additional data structures.
 */
public class P11_IsUnique {


    public static void main(String[] args) {
        String unique = "abcdfg";
        String nonUnique = "abcdfbg";
        System.out.println("Test1:" + isUnique(unique));
        System.out.println("Test1:" + !isUnique(nonUnique));
    }

    //TODO test
    public static boolean isUnique(String word) {
        //can include lenght validation if charset is known. If lengh>charsetSize -> not unique
        char[] letters = word.toCharArray();
        Arrays.sort(letters); // n log n   TODO verify space use
        //  For no space et all can use a  simpler is n^2 with all vs all characters.
        int end = letters.length-2;
        for (int i = 0; i < end; i++) {
            if(letters[i]==letters[i+1]) return false;
        }
        return true;
    }
}
