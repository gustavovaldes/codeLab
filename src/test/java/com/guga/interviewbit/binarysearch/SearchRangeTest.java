package com.guga.interviewbit.binarysearch;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by guga
 */
public class SearchRangeTest {


    @Test
    public void testSingleValue(){
        List<Integer> input = Arrays.asList(new Integer[]{1});
        List output =  new SearchRange().searchRange(input, 1);
        Assert.assertEquals(2, output.size());
        Assert.assertEquals(0, output.get(0));
        Assert.assertEquals(0, output.get(1));

    }


    @Test
    public void testSimpleNotFoundInput(){
        List<Integer> input = Arrays.asList(new Integer[]{4, 7, 7, 7, 8, 10, 10});
        List output =  new SearchRange().searchRange(input, 3);
        Assert.assertEquals(2, output.size());
        Assert.assertEquals(-1, output.get(0));
        Assert.assertEquals(-1, output.get(1));
    }

    @Test
    public void testSimpleFoundInput(){
        List<Integer> input = Arrays.asList(new Integer[]{1, 2, 6, 9, 9});
        List output =  new SearchRange().searchRange(input, 2);
        Assert.assertEquals(2, output.size());
        Assert.assertEquals(1, output.get(0));
        Assert.assertEquals(1, output.get(1));
    }




    @Test
    public void testNotFoundInput(){
        List<Integer> input = Arrays.asList(new Integer[]{1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 5, 5, 6, 6, 6, 6, 6, 6, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10});
        List output =  new SearchRange().searchRange(input, 4);
        Assert.assertEquals(2, output.size());
        Assert.assertEquals(-1, output.get(0));
        Assert.assertEquals(-1, output.get(1));

    }





    @Test
    public void testLongInput(){
        List<Integer> input = Arrays.asList(new Integer[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10});
        List output =  new SearchRange().searchRange(input, 10);
        Assert.assertEquals(2, output.size());
        Assert.assertEquals(118, output.get(0));
        Assert.assertEquals(133, output.get(1));


    }

    @Test
    public void testInitialFoundInput(){
        List<Integer> input = Arrays.asList(new Integer[]{ 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 7, 7, 8, 8, 8, 8, 9, 9, 10, 10, 10});
        List output =  new SearchRange().searchRange(input, 1);
        Assert.assertEquals(2, output.size());
        Assert.assertEquals(0, output.get(0));
        Assert.assertEquals(1, output.get(1));


    }
}
