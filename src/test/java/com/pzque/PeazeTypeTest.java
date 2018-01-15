package com.pzque;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;

/**
 * PeazeType Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>01/15/2018</pre>
 */
public class PeazeTypeTest extends TestCase {
    public PeazeTypeTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Method: isApplicable()
     */
    public void testIsApplicable() throws Exception {
        assertFalse(PeazeType.BOOLEAN.isApplicable());
        assertFalse(PeazeType.CHARACTER.isApplicable());
        assertFalse(PeazeType.INTEGER.isApplicable());
        assertFalse(PeazeType.DOUBLE.isApplicable());
        assertFalse(PeazeType.NULL.isApplicable());
        assertFalse(PeazeType.UNDEFINED.isApplicable());

        assertTrue(PeazeType.FUNCTION.isApplicable());
        assertTrue(PeazeType.BUILTIN_OP.isApplicable());
    }


    public static Test suite() {
        return new TestSuite(PeazeTypeTest.class);
    }
} 
