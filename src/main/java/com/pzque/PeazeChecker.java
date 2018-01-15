package com.pzque;

import com.pzque.PeazeParser.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.HashMap;
import java.util.function.BiFunction;
import java.util.function.Function;

class PreBuiltRules {
    public static Boolean CheckInvalidSequence(ParserRuleContext ctx) {
        int lastIndex = ctx.getChildCount() - 1;
        ParseTree last = ctx.getChild(lastIndex);
        return (last instanceof ExprContext);
    }

    public static Boolean CheckNotApplicable(ParserRuleContext ctx, PeazeValue value) {
        return value.getType().isApplicable();
    }
}

public class PeazeChecker {
    private HashMap<String, Tuple<String, Function<ParserRuleContext, Boolean>>> syntaxRuleMap;
    private HashMap<String, Tuple<String, BiFunction<ParserRuleContext, PeazeValue, Boolean>>> runtimeRuleMap;

    public PeazeChecker() {
        this.syntaxRuleMap = new HashMap<>();
        this.runtimeRuleMap = new HashMap<>();

        this.newSyntaxRule("InvalidSequence",
                "a sequence must end with a expression",
                PreBuiltRules::CheckInvalidSequence
        );

        this.newRuntimeRule("NotApplicable",
                "the expression invoked must applicable",
                PreBuiltRules::CheckNotApplicable);
    }


    public void checkSyntax(String ruleName, ParserRuleContext ctx) {
        assert this.syntaxRuleMap.containsKey(ruleName);
        Tuple<String, Function<ParserRuleContext, Boolean>> rule = this.syntaxRuleMap.get(ruleName);
        String failedMsg = rule._1;
        Function<ParserRuleContext, Boolean> checker = rule._2;
        if (!checker.apply(ctx)) {
            PeazeError.syntaxError(ruleName, failedMsg, ctx);
        }
    }

    public void checkRuntime(String ruleName, ParserRuleContext ctx, PeazeValue value) {
        assert this.runtimeRuleMap.containsKey(ruleName);
        Tuple<String, BiFunction<ParserRuleContext, PeazeValue, Boolean>> rule = this.runtimeRuleMap.get(ruleName);
        String failedMsg = rule._1;
        BiFunction<ParserRuleContext, PeazeValue, Boolean> checker = rule._2;
        if (!checker.apply(ctx, value)) {
            PeazeError.syntaxError(ruleName, failedMsg, ctx);
        }
    }

    public void newSyntaxRule(String ruleName, String failedMsg, Function<ParserRuleContext, Boolean> checker) {
        assert !this.syntaxRuleMap.containsKey(ruleName);

        Tuple<String, Function<ParserRuleContext, Boolean>> ruleValue
                = new Tuple<>(failedMsg, checker);
        this.syntaxRuleMap.put(ruleName, ruleValue);
    }

    public void newRuntimeRule(String ruleName, String failedMsg, BiFunction<ParserRuleContext, PeazeValue, Boolean> checker) {
        assert !this.runtimeRuleMap.containsKey(ruleName);

        Tuple<String, BiFunction<ParserRuleContext, PeazeValue, Boolean>> ruleValue
                = new Tuple<>(failedMsg, checker);
        this.runtimeRuleMap.put(ruleName, ruleValue);
    }
}

