package com.guga.hackerrank.challenges;

/**
 * Created by gvaldes
 * <p>
 * https://www.hackerrank.com/challenges/journey-to-the-moon
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/* TODO implement using dfs instead union find*/
public class JourneyToTheMoon {

    private int[] item;
    private int[] size;

    public static void main(String[] args) throws Exception {
        JourneyToTheMoon s = new JourneyToTheMoon();
        long combinations = s.calculate(new InputStreamReader(System.in));
        System.out.println(combinations);

    }

    public long calculate(InputStreamReader in) throws IOException {
        BufferedReader bfr = new BufferedReader(in);
        String[] temp = bfr.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int I = Integer.parseInt(temp[1]);

        item = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            item[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < I; i++) {
            temp = bfr.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            // Store a and b in an appropriate data structure of your choice
            union(a, b);
        }

        long combinations = 0;
        long sum = 0;

        // Compute the final answer - the number of combinations

        Set<Integer> parents = new HashSet<>();
        int singleCounter = 0;
        //System.out.println("s.item[i]++s.size[i]");
        for (int i = 0; i < N; i++) {
            int parent = find(i);
            //System.out.println("Parent: "+parent+ " Size: "+s.size[parent]);
            if (!parents.contains(parent)) {
                parents.add(parent);
                if (size[parent] != 1) {
                    combinations = combinations + sum * size[parent];
                    sum += size[parent];
                } else {
                    singleCounter++;
                }
            }
        }
        combinations += singleCounter * (N - singleCounter);
        combinations += combinations(singleCounter);
        if (parents.size() == 1) combinations = 0;
        return combinations;
    }

    private void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if (parentA != parentB) {
            int sizeA = size[parentA];
            int sizeB = size[parentB];
            if (sizeA > sizeB) {
                item[parentB] = parentA;
                size[parentA] = sizeA + sizeB;
            } else {
                item[parentA] = parentB;
                size[parentB] = sizeA + sizeB;
            }
        }

    }

    private int find(int a) {
        while (a != item[a]) {
            a = item[a];
        }
        return a;
    }

    /**
     *  n! / ((n-k)! * k!) as n=2 ->  n*(n-1)/2
     */
    private long combinations(long x) {
        return x * (x - 1) / 2;
    }
}
