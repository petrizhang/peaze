package com.pzque.interpreter;

import com.pzque.parser.PeazeLexer;
import com.pzque.parser.PeazeParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
        try {
            if (args.length != 1) {
                help();
            }

            CharStream inputStream = CharStreams.fromFileName(args[0]);
            PeazeLexer lexer = new PeazeLexer(inputStream);

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            PeazeParser parser = new PeazeParser(tokens);
            ParserRuleContext ast = parser.program();

            PeazeInterpreter interpreter = new PeazeInterpreter();
            interpreter.eval(ast);
        } catch (Error e) {
            System.err.println("woops");
        }
    }

    public static void help() {
        System.out.println("Usage: peazei filename");
        System.exit(-1);
    }
}
