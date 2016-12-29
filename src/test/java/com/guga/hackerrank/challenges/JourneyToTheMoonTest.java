package com.guga.hackerrank.challenges;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by gvaldes
 */
public class JourneyToTheMoonTest {

    private JourneyToTheMoon s;

    @Before
    public void init() {
        s = new JourneyToTheMoon();
    }

    @Test
    public void testSingles() throws IOException {
        Assert.assertEquals(4999949998L, s.calculate(
                new InputStreamReader(this.getClass().getResourceAsStream("/" + "journey1.txt"))));
    }

    @Test
    public void testLongAllCases() throws IOException {
        Assert.assertEquals(3984L, s.calculate(
                new InputStreamReader(this.getClass().getResourceAsStream("/" + "journey2.txt"))));
    }

    @Test
    public void testSimpleAllCases() throws IOException {
        Assert.assertEquals(23L, s.calculate(
                new InputStreamReader(this.getClass().getResourceAsStream("/" + "journey3.txt"))));
    }

    @Test
    public void testAllSameCountry() throws IOException {
        Assert.assertEquals(0L, s.calculate(
                new InputStreamReader(this.getClass().getResourceAsStream("/" + "journey4.txt"))));
    }
}
