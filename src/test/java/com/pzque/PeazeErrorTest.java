package com.pzque;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * PeazeError Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>01/15/2018</pre>
 */
public class PeazeErrorTest extends TestCase {
    public PeazeErrorTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public static Test suite() {
        return new TestSuite(PeazeErrorTest.class);
    }
} 
