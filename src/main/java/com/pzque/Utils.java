package com.pzque;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;


public class Utils {

    static final RuntimeException WrongBranch = new RuntimeException("Code reach wrong branch");

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
        return input.getText(new Interval(start, stop));
    }
}

class Tuple<T1, T2> {
    public Tuple(T1 _1, T2 _2) {
        this._1 = _1;
        this._2 = _2;
    }

    public T1 _1;
    public T2 _2;
}
