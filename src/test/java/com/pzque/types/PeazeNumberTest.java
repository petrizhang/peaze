package com.pzque.types;

import junit.framework.TestCase;

public class PeazeNumberTest extends TestCase {
    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testCompareTo() throws Exception {
        PeazeNumber a = new PeazeNumberReal(1.2);
        PeazeNumber b = new PeazeNumberInteger(1);
        assertTrue(a.compareTo(b) > 0);
    }

    public void testIsNumber() throws Exception {
    }

    public void testAsJavaDouble() throws Exception {
    }

    public void testSetNegative() throws Exception {
    }

    public void testAdd() throws Exception {
    }

    public void testAcceptAdd() throws Exception {
    }

    public void testAcceptAdd1() throws Exception {
    }

    public void testAcceptAdd2() throws Exception {
    }

    public void testSub() throws Exception {
    }

    public void testAcceptSub() throws Exception {
    }

    public void testAcceptSub1() throws Exception {
    }

    public void testAcceptSub2() throws Exception {
    }

}