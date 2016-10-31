package com.guga.interviewbit.arrays;

import java.util.List;

/**
 * Created by guga
 */
public class MaxSumContiguousSubarray {

    public int maxSubArray(final List<Integer> a) {
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

