package com.pzque;

import com.pzque.parser.PeazeLexer;
import com.pzque.parser.PeazeParser;
import org.antlr.v4.runtime.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
        
        CharStream inputStream = CharStreams.fromFileName("resource/test_define.pz");
        PeazeLexer lexer = new PeazeLexer(inputStream);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PeazeParser parser = new PeazeParser(tokens);
        ParserRuleContext ast = parser.program();

        PeazeInterpreter interpreter = new PeazeInterpreter();

        System.out.println(ast.toStringTree());
    }
}
