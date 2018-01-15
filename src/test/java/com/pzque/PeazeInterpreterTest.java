package com.pzque;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;

import com.pzque.PeazeParser.*;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.function.Function;

public class PeazeInterpreterTest extends TestCase {
    public void testEval() throws Exception {
    }


    private PeazeInterpreter interpreter = new PeazeInterpreter();

    public PeazeInterpreterTest(String name) {
        super(name);
    }


    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testEvalExprApply() throws Exception {

    }

    public void testEvalBuiltinApply() throws Exception {

    }

    public void testEvalLambdaApply() throws Exception {
    }

    public void testEvalFuncDefine() throws Exception {

    }

    public void testEvalLambdaDefine() throws Exception {
        String code = "(define add (lambda (x y) (+ x y)))";
        ParserRuleContext ctx = TestUtil.genParser(code).define();

        this.interpreter.evalLambdaDefine((LambdaDefineContext) ctx);
        PeazeEnv env = this.interpreter.getCurEnv();
        assertTrue(env.contains("add"));
        assertTrue(env.lookup("add").getType() == PeazeType.FUNCTION);
        try {
            code = "(define add (lambda (x y) (+ x y) (define t 1)))";
            ctx = TestUtil.genParser(code).define();
            this.interpreter.evalLambdaDefine((LambdaDefineContext) ctx);
        } catch (PeazeException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void testEvalVarDefine() throws Exception {
    }


    public void testEvalIntegerLiteral() throws Exception {
        String[] codes = {"1", "100", "100000", "9999999"};
        Integer[] results = {1, 100, 100000, 9999999};
        Function<String, PeazeValue> parse = code -> {
            PeazeParser parser = TestUtil.genParser(code);
            LiteralContext ctx = parser.literal();
            return this.interpreter.evalIntegerLiteral((IntegerLiteralContext) ctx);
        };

        for (int i = 0; i < codes.length; i++) {
            Integer expected = results[i];
            PeazeValue value = parse.apply(codes[i]);
            assertTrue(value.getType() == PeazeType.INTEGER);
            assertEquals(expected, value.asInteger());
        }
    }

    public void testEvalBooleanLiteral() throws Exception {
        String[] codes = {"true", "false"};
        Boolean[] results = {true, false};
        Function<String, PeazeValue> parse = code -> {
            PeazeParser parser = TestUtil.genParser(code);
            LiteralContext ctx = parser.literal();
            return this.interpreter.evalBooleanLiteral((BooleanLiteralContext) ctx);
        };

        for (int i = 0; i < codes.length; i++) {
            Boolean expected = results[i];
            PeazeValue value = parse.apply(codes[i]);
            assertTrue(value.getType() == PeazeType.BOOLEAN);
            assertEquals(expected, value.asBoolean());
        }
    }

    public void testEvalDecimalLiteral() throws Exception {
        String[] codes = {"1.1", "1.23", "1.243", "123123123.123"};
        Double[] results = {1.1, 1.23, 1.243, 123123123.123};
        Function<String, PeazeValue> parse = code -> {
            PeazeParser parser = TestUtil.genParser(code);
            LiteralContext ctx = parser.literal();
            return this.interpreter.evalDecimalLiteral((DecimalLiteralContext) ctx);
        };

        for (int i = 0; i < codes.length; i++) {
            Double expected = results[i];
            PeazeValue value = parse.apply(codes[i]);
            assertTrue(value.getType() == PeazeType.DOUBLE);
            assertEquals(expected, value.asDouble());
        }
    }


    public static Test suite() {
        return new TestSuite(PeazeInterpreterTest.class);
    }
} 
