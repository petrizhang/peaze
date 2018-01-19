package com.pzque.continuation;

import com.pzque.TestUtil;
import com.pzque.core.PeazeObject;
import com.pzque.errors.PeazeException;
import com.pzque.interpreter.PeazeInterpreter;
import junit.framework.TestCase;
import org.antlr.v4.runtime.ParserRuleContext;

public class CPSInterpreterTest extends TestCase {
    private PeazeInterpreter interpreter = new PeazeInterpreter();

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testGetCurEnv() throws Exception {
    }

    public void testEval() throws Exception {
        try {
            ParserRuleContext ctx = TestUtil.genParserFromFileName("examples/recursion.pz").program();

            // Continuation<PeazeObject> cont = this.interpreter.eval(ctx);
            // cont.execute();
        } catch (PeazeException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public void testVisitProgram() throws Exception {
    }

    public void testVisitDefineTopunit() throws Exception {
    }

    public void testVisitApplyTopunit() throws Exception {
    }

    public void testVisitProcDefine() throws Exception {
    }

    public void testVisitLambdaDefine() throws Exception {
    }

    public void testVisitVarDefine() throws Exception {
    }

    public void testVisitApply() throws Exception {
    }

    public void testVisitLiteralExpr() throws Exception {
    }

    public void testVisitVarRefExpr() throws Exception {
    }

    public void testVisitLambdaExpr() throws Exception {
    }

    public void testVisitApplyExpr() throws Exception {
    }

    public void testVisitIfExpr() throws Exception {
    }

    public void testVisitFullIf() throws Exception {
    }

    public void testVisitPartialIf() throws Exception {
    }

    public void testVisitLambda() throws Exception {
    }

    public void testVisitVarRef() throws Exception {
    }

    public void testVisitIntegerLiteral() throws Exception {
    }

    public void testVisitBooleanLiteral() throws Exception {
    }

    public void testVisitDecimalLiteral() throws Exception {
    }

    public void testBinds() throws Exception {
    }

    public void testInvoke() throws Exception {
    }

    public void testNewProcedureValue() throws Exception {
    }

    public void testEvalSequence() throws Exception {
    }

}