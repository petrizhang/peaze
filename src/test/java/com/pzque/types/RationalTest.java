package com.pzque.types;

import com.pzque.Utils;
import junit.framework.TestCase;

public class RationalTest extends TestCase {
    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testGetNumerator() throws Exception {
    }

    public void testSetNumerator() throws Exception {
    }

    public void testGetDenominator() throws Exception {
    }

    public void testSetDenominator() throws Exception {
    }

    public void testAdd() throws Exception {
        PeazeNumberRational a = new PeazeNumberRational(1, 2);
        PeazeNumberRational b = new PeazeNumberRational(2, 3);

        assertEquals("1+1/6", a.add(b).toString());
    }

    public void testSub() throws Exception {

    }

    public void testMul() throws Exception {
    }

    public void testDiv() throws Exception {
    }

    public void testSimplify() throws Exception {
    }

    public void testToInt() throws Exception {
    }

    public void testToDouble() throws Exception {
    }

    public void testToString() throws Exception {
    }

    public void testGcd() throws Exception {
        assertEquals(1, Utils.gcd(13, 14));
        assertEquals(9, Utils.gcd(27, 36));
    }

    public void testLcm() throws Exception {
    }

}