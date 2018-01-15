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

    /**
     * Method: NotApplicable(ParserRuleContext ctx)
     */
    public void testNotApplicable() throws Exception {
        String code = "(define a 10)\n(define b   11)";
        ParserRuleContext ctx = TestUtil.genParser(code).program();
        try {
            PeazeError.NotApplicable(ctx);
        } catch (PeazeException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void testInvalidSequence() throws Exception {
        String code = "(define a 10)\n(define b   11)";
        PeazeParser parser = TestUtil.genParser(code);
        PeazeParser.SequenceContext ctx = parser.sequence();
        try {
            PeazeError.InvalidSequence(ctx);
        } catch (PeazeException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static Test suite() {
        return new TestSuite(PeazeErrorTest.class);
    }
} 
