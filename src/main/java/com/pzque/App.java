package com.pzque;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
        CharStream inputStream = CharStreams.fromFileName("/home/zeta/Projects/peaze/resource/test.pz");
        PeazeLexer lexer = new PeazeLexer(inputStream);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PeazeParser parser = new PeazeParser(tokens);
        ParserRuleContext ast = parser.apply();

        System.out.println(ast.getChild(0));

        System.out.println(ast.toStringTree());
    }
}
