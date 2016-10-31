package com.guga.interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by guga
 * <p>
 * Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].
 * If there is no solution possible, return 0.  //original says -1, is wrong.
 * <p>
 * Example :
 * <p>
 * A : [3 5 4 2]
 * <p>
 * Output : 2
 * for the pair (3, 4)
 */
public class MaxDistance {


    public static void main(String[] args) {

    }


    /**
     * brute force approach
     */
    public int maximumGapV1(final List<Integer> a) {
        int size = a.size();
        int max = 0;
        for (int i = 0; i < size; i++) {
            for (int j = size - 1; j > i; j--) {
                if (a.get(i) <= a.get(j)) {
                    if ((j - i) > max) {
                        max = j - i;
                    }
                    break;
                }
            }
        }
        return max;
    }

    /*
     * more efficient approach, like mergeSort
     */
    public int maximumGapV2(final List<Integer> a) {
        if(a.size()<1) return 0;
        int maxDiff;
        int size = a.size();
        int RMax[] = new int[size];
        int LMin[] = new int[size];

        /* Construct LMin[] such that LMin[i] stores the minimum value
           from (arr[0], arr[1], ... arr[i]) */
        LMin[0] = a.get(0);
        for (int i = 1; i < size; i++)
            LMin[i] = Math.min(a.get(i), LMin[i - 1]);

        /* Construct RMax[] such that RMax[j] stores the maximum value
           from (arr[j], arr[j+1], ..arr[n-1]) */
        RMax[size - 1] = a.get(size - 1);
        for (int j = size - 2; j >= 0; j--)
            RMax[j] = Math.max(a.get(j), RMax[j + 1]);

        /* Traverse both arrays from left to right to find optimum j - i
           This process is similar to merge() of MergeSort */
        int i = 0;
        int j = 0;
        maxDiff = 0;
        while (j < size && i < size) {
            if (LMin[i] <= RMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j = j + 1;
            } else
                i = i + 1;
        }

        return maxDiff;
    }
}
