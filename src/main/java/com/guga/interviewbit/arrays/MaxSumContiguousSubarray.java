package com.guga.interviewbit.arrays;

import java.util.List;

/**
 * Created by guga
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *
 * For example:
 *
 * Given the array [-2,1,-3,4,-1,2,1,-5,4],
 *
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 *
 * For this problem, return the maximum sum.
 */
public class MaxSumContiguousSubarray {

    public int maxSubArray(final List<Integer> a) { //TODO include variation to return the range too.
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < a.size(); i++) {
            if (sum < 0 && maxSum>Integer.MIN_VALUE) {
                sum = 0;
            }
            sum+=a.get(i);
            if(sum>maxSum){
                maxSum = sum;
            }
        }
        return maxSum;
    }
}

