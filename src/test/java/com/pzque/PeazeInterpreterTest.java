package com.pzque;

import com.pzque.core.PeazeEnv;
import com.pzque.core.PeazeObject;
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

    public void testBuiltin() throws Exception {
        try {
            ParserRuleContext ctx = TestUtil.genParserFromFileName("resource/test_builtin.pz").program();

            this.interpreter.eval(ctx);

        } catch (PeazeException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public void testDefine() throws Exception {
        try {
            ParserRuleContext ctx = TestUtil.genParserFromFileName("resource/test_define.pz").program();

            this.interpreter.eval(ctx);

        } catch (PeazeException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public void testClojure() throws Exception {
        try {
            ParserRuleContext ctx = TestUtil.genParserFromFileName("resource/test_closure.pz").program();

            this.interpreter.eval(ctx);
            PeazeEnv env = this.interpreter.getCurEnv();
            assertTrue(env.lookup("x").isInteger());
            assertTrue(env.lookup("y").isInteger());
            assertTrue(env.lookup("z").isInteger());
            assertTrue(env.lookup("f").isProcedure());
            assertTrue(env.lookup("g").isProcedure());
            assertTrue(env.lookup("h").isProcedure());
            assertTrue(env.lookup("a").isInteger());
            assertTrue(env.lookup("b").isInteger());

            assertEquals(new Integer(11), env.lookup("a").asJavaInt());
            assertEquals(new Integer(101), env.lookup("b").asJavaInt());

        } catch (PeazeException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void testIf() throws Exception {
        try {
            ParserRuleContext ctx = TestUtil.genParserFromFileName("resource/test_if.pz").program();

            this.interpreter.eval(ctx);

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

    public void testVisitFuncDefine() throws Exception {
    }

    public void testVisitLambdaDefine() throws Exception {
        String code = "(define add (lambda (x y) (+ x y)))";
        ParserRuleContext ctx = TestUtil.genParser(code).define();

        this.interpreter.visitLambdaDefine((PeazeParser.LambdaDefineContext) ctx);
        PeazeEnv env = this.interpreter.getCurEnv();
        assertTrue(env.contains("add"));
        assertTrue(env.lookup("add").isProcedure());
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
        assertTrue(env.lookup("x").isInteger());

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
        Function<String, PeazeObject> parse = code -> {
            PeazeParser parser = TestUtil.genParser(code);
            PeazeParser.LiteralContext ctx = parser.literal();
            return this.interpreter.visitIntegerLiteral((PeazeParser.IntegerLiteralContext) ctx);
        };

        for (int i = 0; i < codes.length; i++) {
            Integer expected = results[i];
            PeazeObject value = parse.apply(codes[i]);
            assertTrue(value.isInteger());
            assertEquals(expected, value.asJavaInt());
        }
    }

    public void testVisitBooleanLiteral() throws Exception {
        String[] codes = {"#t", "#f"};
        Boolean[] results = {true, false};
        Function<String, PeazeObject> parse = code -> {
            PeazeParser parser = TestUtil.genParser(code);
            PeazeParser.LiteralContext ctx = parser.literal();
            return this.interpreter.visitBooleanLiteral((PeazeParser.BooleanLiteralContext) ctx);
        };

        for (int i = 0; i < codes.length; i++) {
            Boolean expected = results[i];
            PeazeObject value = parse.apply(codes[i]);
            assertTrue(value.isBoolean());
            assertEquals(expected, value.asJavaBoolean());
        }
    }

    public void testVisitDecimalLiteral() throws Exception {
        String[] codes = {"1.1", "1.23", "1.243", "123123123.123"};
        Double[] results = {1.1, 1.23, 1.243, 123123123.123};
        Function<String, PeazeObject> parse = code -> {
            PeazeParser parser = TestUtil.genParser(code);
            PeazeParser.LiteralContext ctx = parser.literal();
            return this.interpreter.visitDecimalLiteral((PeazeParser.DecimalLiteralContext) ctx);
        };

        for (int i = 0; i < codes.length; i++) {
            Double expected = results[i];
            PeazeObject value = parse.apply(codes[i]);
            assertTrue(value.isDouble());
            assertEquals(expected, value.asJavaDouble());
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