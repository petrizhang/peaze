package com.pzque;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

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
}
