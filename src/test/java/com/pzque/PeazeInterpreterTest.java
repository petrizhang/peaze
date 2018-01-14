package com.pzque;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import com.pzque.PeazeParser.*;

import java.util.function.Function;

/**
 * PeazeInterpreter Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>01/14/2018</pre>
 */
public class PeazeInterpreterTest extends TestCase {
    private PeazeInterpreter interpreter = new PeazeInterpreter();

    public PeazeInterpreterTest(String name) {
        super(name);
    }

    private PeazeParser genParser(String code) {
        CharStream inputStream = CharStreams.fromString(code);
        PeazeLexer lexer = new PeazeLexer(inputStream);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PeazeParser parser = new PeazeParser(tokens);

        return parser;
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Method: evalExprApply(ExprApplyContext ctx)
     */
    public void testEvalExprApply() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: evalBuiltinApply(BuiltinApplyContext ctx)
     */
    public void testEvalBuiltinApply() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: evalLambdaApply(LambdaApplyContext ctx)
     */
    public void testEvalLambdaApply() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: evalFuncDefine(FuncDefineContext ctx)
     */
    public void testEvalFuncDefine() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: evalVarDefine(VarDefineContext ctx)
     */
    public void testEvalVarDefine() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: evalIntegerLiteral(IntegerLiteralContext ctx)
     */
    public void testEvalIntegerLiteral() throws Exception {
        String[] codes = {"1", "100", "100000", "9999999"};
        Integer[] results = {1, 100, 100000, 9999999};
        Function<String, PeazeValue> parse = code -> {
            PeazeParser parser = genParser(code);
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

    /**
     * Method: evalBooleanLiteral(BooleanLiteralContext ctx)
     */
    public void testEvalBooleanLiteral() throws Exception {
        String[] codes = {"true", "false"};
        Boolean[] results = {true, false};
        Function<String, PeazeValue> parse = code -> {
            PeazeParser parser = genParser(code);
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

    /**
     * Method: evalDecimalLiteral(DecimalLiteralContext ctx)
     */
    public void testEvalDecimalLiteral() throws Exception {
        String[] codes = {"1.1", "1.23", "1.243", "123123123.123"};
        Double[] results = {1.1, 1.23, 1.243, 123123123.123};
        Function<String, PeazeValue> parse = code -> {
            PeazeParser parser = genParser(code);
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
