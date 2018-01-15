package com.pzque;

import com.pzque.PeazeParser.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;


public class SyntaxChecker {
    public static void CheckInvalidSequence(ParserRuleContext ctx) {
        int lastIndex = ctx.getChildCount() - 1;
        ParseTree last = ctx.getChild(lastIndex);
        if (!(last instanceof ExprContext)) {
            PeazeError.syntaxError("InvalidSequence",
                    "a sequence must end with a expression",
                    ctx);
        }
    }

}

