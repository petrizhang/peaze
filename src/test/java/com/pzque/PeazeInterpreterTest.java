package com.pzque;

import com.pzque.core.PeazeEnv;
import com.pzque.core.PeazeType;
import com.pzque.core.PeazeValue;
import com.pzque.parser.PeazeParser;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.function.Function;

public class PeazeInterpreterTest extends TestCase {
    public void setUp() throws Exception {
        super.setUp();
    }

    private PeazeInterpreter interpreter = new PeazeInterpreter();

    public void tearDown() throws Exception {
    }

    public void testGetCurEnv() throws Exception {
    }

    public void testEval() throws Exception {
        String code = "(define x 1)\n"
                + "(define y 2)\n"
                + "(define z (+ x y))\n"
                + "(define (f x) (lambda () (+ x 1)))\n"
                + "(define g (f 10))\n"
                + "(define h (f 100))\n"
                + "(define a (g))\n"
                + "(define b (h))\n"
                ;

        ParserRuleContext ctx = TestUtil.genParser(code).program();

        this.interpreter.eval(ctx);
        PeazeEnv env = this.interpreter.getCurEnv();
        assertTrue(env.contains("x"));
        assertTrue(env.contains("y"));
        assertTrue(env.contains("z"));
        assertTrue(env.lookup("x").isInteger());
        assertTrue(env.lookup("y").isInteger());
        assertTrue(env.lookup("z").isInteger());

        try {

        } catch (PeazeException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void testVisitProgram() throws Exception {
    }

    public void testVisitDefineTopunit() throws Exception {
    }

    public void testVisitApplyTopunit() throws Exception {
    }

    public void testVisitFuncDefine() throws Exception {
    }

    public void testVisitLambdaDefine() throws Exception {
        String code = "(define add (lambda (x y) (+ x y)))";
        ParserRuleContext ctx = TestUtil.genParser(code).define();

        this.interpreter.visitLambdaDefine((PeazeParser.LambdaDefineContext) ctx);
        PeazeEnv env = this.interpreter.getCurEnv();
        assertTrue(env.contains("add"));
        assertTrue(env.lookup("add").getType() == PeazeType.PROCEDURE);
        try {
            code = "(define add (lambda (x y) (+ x y) (define t 1)))";
            ctx = TestUtil.genParser(code).define();
            this.interpreter.visitLambdaDefine((PeazeParser.LambdaDefineContext) ctx);
        } catch (PeazeException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void testVisitVarDefine() throws Exception {
        String code = "(define x 1)";
        ParserRuleContext ctx = TestUtil.genParser(code).define();

        this.interpreter.visitVarDefine((PeazeParser.VarDefineContext) ctx);
        PeazeEnv env = this.interpreter.getCurEnv();
        assertTrue(env.contains("x"));
        assertTrue(env.lookup("x").getType() == PeazeType.INTEGER);

        try {
            code = "(define x 2)";
            ctx = TestUtil.genParser(code).define();
            this.interpreter.visitVarDefine((PeazeParser.VarDefineContext) ctx);
        } catch (PeazeException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void testVisitVarRefExpr() throws Exception {
    }

    public void testVisitLambdaExpr() throws Exception {
    }

    public void testVisitApplyExpr() throws Exception {
    }

    public void testVisitLambda() throws Exception {
    }

    public void testVisitVarRef() throws Exception {
    }

    public void testVisitIntegerLiteral() throws Exception {
        String[] codes = {"1", "100", "100000", "9999999"};
        Integer[] results = {1, 100, 100000, 9999999};
        Function<String, PeazeValue> parse = code -> {
            PeazeParser parser = TestUtil.genParser(code);
            PeazeParser.LiteralContext ctx = parser.literal();
            return this.interpreter.visitIntegerLiteral((PeazeParser.IntegerLiteralContext) ctx);
        };

        for (int i = 0; i < codes.length; i++) {
            Integer expected = results[i];
            PeazeValue value = parse.apply(codes[i]);
            assertTrue(value.getType() == PeazeType.INTEGER);
            assertEquals(expected, value.asInteger());
        }
    }

    public void testVisitBooleanLiteral() throws Exception {
        String[] codes = {"#t", "#f"};
        Boolean[] results = {true, false};
        Function<String, PeazeValue> parse = code -> {
            PeazeParser parser = TestUtil.genParser(code);
            PeazeParser.LiteralContext ctx = parser.literal();
            return this.interpreter.visitBooleanLiteral((PeazeParser.BooleanLiteralContext) ctx);
        };

        for (int i = 0; i < codes.length; i++) {
            Boolean expected = results[i];
            PeazeValue value = parse.apply(codes[i]);
            assertTrue(value.getType() == PeazeType.BOOLEAN);
            assertEquals(expected, value.asBoolean());
        }
    }

    public void testVisitDecimalLiteral() throws Exception {
        String[] codes = {"1.1", "1.23", "1.243", "123123123.123"};
        Double[] results = {1.1, 1.23, 1.243, 123123123.123};
        Function<String, PeazeValue> parse = code -> {
            PeazeParser parser = TestUtil.genParser(code);
            PeazeParser.LiteralContext ctx = parser.literal();
            return this.interpreter.visitDecimalLiteral((PeazeParser.DecimalLiteralContext) ctx);
        };

        for (int i = 0; i < codes.length; i++) {
            Double expected = results[i];
            PeazeValue value = parse.apply(codes[i]);
            assertTrue(value.getType() == PeazeType.DOUBLE);
            assertEquals(expected, value.asDouble());
        }
    }

    public void testBinds() throws Exception {
    }

    public void testInvoke() throws Exception {
    }

    public void testEvalSequence() throws Exception {
    }

    public static Test suite() {
        return new TestSuite(PeazeInterpreterTest.class);
    }
}