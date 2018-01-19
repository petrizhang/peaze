package com.pzque.util;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;


public class Utils {

    public static final RuntimeException WrongBranch = new RuntimeException("Code reach wrong branch");

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

    public static List<String> toStringList(List<? extends ParseTree> treeList) {
        List<String> stringList = new ArrayList<>();

        for (ParseTree node : treeList) {
            stringList.add(node.getText());
        }
        return stringList;
    }

    // greatest common divisor;
    public static int gcd(int a, int b) {
        int remainder;

        do {
            remainder = a % b;
            a = b;
            b = remainder;
        } while (remainder != 0);

        return a;
    }
}

