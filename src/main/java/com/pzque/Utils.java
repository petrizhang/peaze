package com.pzque;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
import com.pzque.PeazeParser.*;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utils {

    public static String getPosString(ParserRuleContext ctx) {
        Token start = ctx.getStart();
        Token end = ctx.getStop();
        int startLine = start.getLine();
        int startCol = start.getCharPositionInLine();
        int endLine = end.getLine();
        int endCol = end.getCharPositionInLine();
        return String.format("%s.%s-%s.%s", startLine, startCol, endLine, endCol);
    }


    public static String getOriginalText(ParserRuleContext ctx) {
        CharStream input = ctx.start.getInputStream();
        int start = ctx.start.getStartIndex();
        int stop = ctx.stop.getStopIndex();
        return input.getText(new Interval(start,stop));
    }
}
