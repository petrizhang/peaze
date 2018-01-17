package com.pzque.core;

import org.antlr.v4.runtime.ParserRuleContext;

import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;

public class PeazeBuiltin {
    public static final HashMap<String, BiFunction<ParserRuleContext, List<PeazeValue>, PeazeValue>>
            buitinMap = new HashMap<String, BiFunction<ParserRuleContext, List<PeazeValue>, PeazeValue>>() {
        {
            put("+", Builtin::add);
        }
    };

    public PeazeBuiltin(String opString) {
        assert buitinMap.containsKey(opString);
        this.op = buitinMap.get(opString);
    }

    public PeazeValue apply(ParserRuleContext ctx, List<PeazeValue> arguments) {
        return this.op.apply(ctx, arguments);
    }

    private BiFunction<ParserRuleContext, List<PeazeValue>, PeazeValue> op;
}
