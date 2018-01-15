package com.pzque;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class TestUtil {
    public static PeazeParser genParser(String code) {
        CharStream inputStream = CharStreams.fromString(code);
        PeazeLexer lexer = new PeazeLexer(inputStream);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        return new PeazeParser(tokens);
    }
}
