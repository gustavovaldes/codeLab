package com.guga.interviewbit.binarysearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guga
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm’s runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * Example:
 * <p>
 * Given [5, 7, 7, 8, 8, 10]
 * <p>
 * and target value 8,
 * <p>
 * return [3, 4].
 */
public class SearchRange {

    //TODO compare time with reference solution, expand method not efficient.
    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {//signature provided, can't modify
        ArrayList<Integer> result = new ArrayList<>();

        int start = 0;
        int end = a.size();
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            int val = a.get(mid);
            if (val > b) {
                end = mid - 1;
            } else if (val < b) {
                start = mid + 1;
            } else {
                return expand(a, b, mid);
            }
        }
        result.add(-1);
        result.add(-1);
        return result;
    }

    private ArrayList<Integer> expand(List<Integer> a, int b, int index) {
        int indexCopy = index;
        //go left
        while (index >= 0 && a.get(index) == b) {
            index--;
        }

        //go right
        while (indexCopy < a.size() && a.get(indexCopy) == b) {
            indexCopy++;
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(++index);
        result.add(--indexCopy);
        return result;
    }

    public ArrayList<Integer> searchRangeReference(final List<Integer> A, int B) {

        int low, up;
        ArrayList<Integer> res = new ArrayList<>();

        low = lowerBound(A, 0, A.size() - 1, B);

        if (low == -1) {
            res.add(-1);
            res.add(-1);
            return res;
        }

        up = upperBound(A, 0, A.size() - 1, B);

        res.add(low);
        res.add(up);

        return res;


    }

    public int lowerBound(final List<Integer> A, int start, int end, int num) {

        int steps = end - start + 1;
        int mid;
        int low = -1;
        int val;

        while (steps > 0) {

            mid = (start + end) / 2;
            val = A.get(mid);

            if (num < val) {
                end = mid - 1;
            } else if (num > val) {
                start = mid + 1;
            } else {
                low = mid;
                end = mid - 1;
            }

            steps /= 2;
        }

        return low;

    }

    public int upperBound(final List<Integer> A, int start, int end, int num) {

        int steps = end - start + 1;
        int mid;
        int up = end + 1;
        int val;

        while (steps > 0) {

            mid = (start + end) / 2;
            val = A.get(mid);

            if (num < val) {
                end = mid - 1;
            } else if (num > val) {
                start = mid + 1;
            } else {
                up = mid;
                start = mid + 1;
            }

            steps /= 2;
        }

        return up;

    }
}
