package com.pzque;

import junit.framework.TestCase;
import org.antlr.v4.runtime.ParserRuleContext;

public class PeazeCheckerTest extends TestCase {
    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testCheckSyntax() throws Exception {
        PeazeChecker checker = new PeazeChecker();
        String code = "(define a 10)\n(define b   11)";
        ParserRuleContext ctx = TestUtil.genParser(code).program();
        try {
            checker.checkSyntax("InvalidSequence", ctx);
        } catch (PeazeException ex) {
            System.out.println(ex.getMessage());
        }
    }


    public void testCheckRuntime() throws Exception {

    }

    public void testNewSyntaxRule() throws Exception {
    }

    public void testNewRuntimeRule() throws Exception {
    }

}