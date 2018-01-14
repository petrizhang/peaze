package com.pzque;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;

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

        System.out.println(ast.toStringTree());
    }
}
