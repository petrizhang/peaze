//package com.pzque.continuation;
//
//import com.pzque.core.PeazeEnv;
//import com.pzque.core.PeazeObject;
//import com.pzque.parser.PeazeBaseVisitor;
//import com.pzque.parser.PeazeParser;
//import com.pzque.types.*;
//import com.pzque.util.Utils;
//import com.pzque.errors.RuntimeChecker;
//import com.pzque.errors.SyntaxChecker;
//import org.antlr.v4.runtime.ParserRuleContext;
//import org.antlr.v4.runtime.tree.ParseTree;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class CPSInterpreter extends PeazeBaseVisitor<Continuation<PeazeObject>> {
//    private PeazeEnv curEnv;
//
//    public CPSInterpreter() {
//        this.curEnv = new PeazeEnv(null);
//    }
//
//    public PeazeEnv getCurEnv() {
//        return this.curEnv;
//    }
//
//    public Continuation<PeazeObject> eval(ParseTree ast) {
//        return ast.accept(this);
//    }
//
//    @Override
//    public Continuation<PeazeObject> visitProgram(PeazeParser.ProgramContext ctx) {
//
//        List<PeazeParser.TopunitContext> unitList = ctx.topunit();
//        if (unitList.isEmpty()) {
//            return new Done<>(PeazeUnspecified.getInstance());
//        }
//        Continuation<PeazeObject> ret = this.eval(unitList.get(0));
//
//        for (int i = 1; i < unitList.size(); i++) {
//            int capturei = i;
//            ret = ret.then(v -> this.eval(unitList.get(capturei)));
//        }
//        return ret;
//    }
//
//
//    @Override
//    public Continuation<PeazeObject> visitDefineTopunit(PeazeParser.DefineTopunitContext ctx) {
//        return this.eval(ctx.define());
//    }
//
//    @Override
//    public Continuation<PeazeObject> visitApplyTopunit(PeazeParser.ApplyTopunitContext ctx) {
//        return this.eval(ctx.apply());
//    }
//
//    @Override
//    public Continuation<PeazeObject> visitProcDefine(PeazeParser.ProcDefineContext ctx) {
//        String procName = ctx.ID().getText();
//        List<String> paramList = Utils.toStringList(ctx.paramList().ID());
//        PeazeParser.SequenceContext body = ctx.sequence();
//        // check if the sequence ends with a expression
//        SyntaxChecker.CheckInvalidSequence(body);
//        PeazeObject procValue = this.newProcedureValue(paramList, body);
//        this.binds(ctx, procName, procValue);
//        return new Done<>(PeazeUnspecified.getInstance());
//    }
//
//    @Override
//    public Continuation<PeazeObject> visitLambdaDefine(PeazeParser.LambdaDefineContext ctx) {
//        String procName = ctx.ID().getText();
//        List<String> paramList = Utils.toStringList(ctx.lambda().paramList().ID());
//        PeazeParser.SequenceContext body = ctx.lambda().sequence();
//        // check if the sequence ends with a expression
//        SyntaxChecker.CheckInvalidSequence(body);
//        PeazeObject procValue = this.newProcedureValue(paramList, body);
//        this.binds(ctx, procName, procValue);
//        return new Done<>(PeazeUnspecified.getInstance());
//    }
//
//    @Override
//    public Continuation<PeazeObject> visitVarDefine(PeazeParser.VarDefineContext ctx) {
//        String name = ctx.ID().getText();
//        // eval the bound expression
//        return this.eval(ctx.expr()).then(
//                value -> {
//                    this.binds(ctx, name, value);
//                    return new Done<>(PeazeUnspecified.getInstance());
//                }
//        );
//    }
//
//    @Override
//    public Continuation<PeazeObject> visitApply(PeazeParser.ApplyContext ctx) {
//        // fetch the invoked expression
//        PeazeParser.ExprContext procedureCtx = ctx.procedure().expr();
//
//        // eval the expression to fetch applicable PeazeProcedure value
//        return this.eval(procedureCtx).then(
//                (PeazeObject procValue) -> {
//                    // check if the expression is applicable
//                    RuntimeChecker.CheckNotApplicable(procedureCtx, procValue);
//                    // eval expressions to get parameters' values
//                    List<PeazeParser.ExprContext> paramExprList = ctx.expr();
//
//                    if (paramExprList.size() == 0) {
//                        return invoke(ctx, procValue, new ArrayList<PeazeObject>());
//                    }
//
//                    ParserRuleContext fisrtCtx = paramExprList.get(0);
//                    Continuation<List<PeazeObject>> result = this.eval(fisrtCtx).then(
//                            value -> {
//                                List<PeazeObject> valueList = new ArrayList<>();
//                                valueList.add(value);
//                                return new Done<>(valueList);
//                            }
//                    );
//
//                    for (int i = 1; i < paramExprList.size(); i++) {
//                        int capturei = i;
//                        result = result.then(
//                                (List<PeazeObject> arguments) ->
//                                        this.eval(paramExprList.get(capturei)).then(
//                                                value -> {
//                                                    arguments.add(value);
//                                                    return new Done<>(arguments);
//                                                }
//                                        )
//                        );
//
//                    }
//                    return result.then(
//                            arguments -> invoke(ctx, procValue, arguments)
//                    );
//                });
//    }
//
//    @Override
//    public Continuation<PeazeObject> visitLiteralExpr(PeazeParser.LiteralExprContext ctx) {
//        return this.eval(ctx.literal());
//    }
//
//    @Override
//    public Continuation<PeazeObject> visitVarRefExpr(PeazeParser.VarRefExprContext ctx) {
//        return this.eval(ctx.varRef());
//    }
//
//    @Override
//    public Continuation<PeazeObject> visitLambdaExpr(PeazeParser.LambdaExprContext ctx) {
//        return this.eval(ctx.lambda());
//    }
//
//    @Override
//    public Continuation<PeazeObject> visitApplyExpr(PeazeParser.ApplyExprContext ctx) {
//        return this.eval(ctx.apply());
//    }
//
//    @Override
//    public Continuation<PeazeObject> visitIfExpr(PeazeParser.IfExprContext ctx) {
//        return this.eval(ctx.if_());
//    }
//
//    @Override
//    public Continuation<PeazeObject> visitFullIf(PeazeParser.FullIfContext ctx) {
//        PeazeParser.ExprContext cond = ctx.cond().expr();
//        PeazeParser.ExprContext body = ctx.expr();
//        PeazeParser.ExprContext else_body = ctx.else_body().expr();
//
//        return this.eval(cond).then(
//                condV -> {
//                    RuntimeChecker.CheckIfCond(ctx, condV);
//                    if (condV.asJavaBoolean()) {
//                        return this.eval(body);
//                    }
//                    return this.eval(else_body);
//                }
//        );
//    }
//
//    @Override
//    public Continuation<PeazeObject> visitPartialIf(PeazeParser.PartialIfContext ctx) {
//        PeazeParser.ExprContext cond = ctx.cond().expr();
//        PeazeParser.ExprContext body = ctx.expr();
//
//        return this.eval(cond).then(
//                condV -> {
//                    RuntimeChecker.CheckIfCond(ctx, condV);
//                    if (condV.asJavaBoolean()) {
//                        return this.eval(body);
//                    }
//                    return new Done<>(PeazeUnspecified.getInstance());
//                }
//        );
//    }
//
//    @Override
//    public Continuation<PeazeObject> visitLambda(PeazeParser.LambdaContext ctx) {
//        PeazeParser.SequenceContext body = ctx.sequence();
//        // check if the sequence ends with a expression
//        SyntaxChecker.CheckInvalidSequence(body);
//        List<String> paramList = Utils.toStringList(ctx.paramList().ID());
//        return new Done<>(newProcedureValue(paramList, body));
//
//    }
//
//    @Override
//    public Continuation<PeazeObject> visitVarRef(PeazeParser.VarRefContext ctx) {
//        String varName = ctx.getText();
//        RuntimeChecker.CheckUndefined(ctx, curEnv, varName);
//        PeazeObject value = curEnv.lookup(varName);
//        if (value == null) {
//            value = new PeazeBuiltin(varName);
//        }
//        return new Done<>(value);
//    }
//
//    @Override
//    public Continuation<PeazeObject> visitIntegerLiteral(PeazeParser.IntegerLiteralContext ctx) {
//        String text = ctx.getText();
//        Integer value = Integer.parseInt(text, 10);
//        return new Done<>(new PeazeNumberInteger(value));
//
//    }
//
//    @Override
//    public Continuation<PeazeObject> visitBooleanLiteral(PeazeParser.BooleanLiteralContext ctx) {
//        String text = ctx.getText();
//        return new Done<>(PeazeBoolean.fromString(text));
//    }
//
//    @Override
//    public Continuation<PeazeObject> visitDecimalLiteral(PeazeParser.DecimalLiteralContext ctx) {
//        String text = ctx.getText();
//        return new Done<>(PeazeNumberReal.fromString(text));
//    }
//
//    void binds(ParserRuleContext ctx, String name, PeazeObject value) {
//        // check if the variable is re-defined
//        RuntimeChecker.CheckVariableReDefine(ctx, this.curEnv, name);
//        this.curEnv.insert(name, value);
//    }
//
//    Continuation<PeazeObject> invoke(ParserRuleContext ctx, PeazeObject procValue, List<PeazeObject> arguments) {
//        if (procValue.isBuiltin()) {
//            return new Done<>(((PeazeBuiltin) procValue).apply(ctx, arguments));
//        }
//
//        Continuation<PeazeObject> ret = new Done<>(PeazeUnspecified.getInstance());
//
//        PeazeProcedure procedure = (PeazeProcedure) procValue;
//
//        // init a new Env object and set it to curEnv
//        PeazeEnv previousEnv = this.curEnv;
//        PeazeEnv newEnv = new PeazeEnv(procedure.getEnv().getParent());
//        procedure.setEnv(newEnv);
//        this.curEnv = newEnv;
//
//        // check if the param number matches expected
//        RuntimeChecker.CheckContractViolation(ctx, procedure, arguments);
//
//        // insert parameters' values to the associated procedure environment
//        List<String> params = procedure.getParams();
//        int paramCount = procedure.getParamCount();
//        for (int i = 0; i < paramCount; i++) {
//            this.curEnv.insert(params.get(i), arguments.get(i));
//        }
//
//        // execute procedure body
//        ret = this.evalSequence(procedure.getBody());
//        // after procedure execution, reset curEnv to previous level
//        this.curEnv = previousEnv;
//        return ret;
//    }
//
//    PeazeObject newProcedureValue(List<String> params, PeazeParser.SequenceContext body) {
//        PeazeEnv env = new PeazeEnv(this.curEnv);
//        return new PeazeProcedure(env, params, body);
//    }
//
//    Continuation<PeazeObject> evalSequence(PeazeParser.SequenceContext ctx) {
//        SyntaxChecker.CheckInvalidSequence(ctx);
//
//        PeazeObject value = PeazeUnspecified.getInstance();
//        List<PeazeParser.ExprContext> exprList = ctx.expr();
//        assert !exprList.isEmpty();
//
//        List<ParseTree> children = ctx.children;
//        Continuation<PeazeObject> result = this.eval(children.get(0));
//
//        for (int i = 1; i < children.size(); i++) {
//            int capturei = i;
//            result = result.then(
//                    v -> this.eval(children.get(capturei))
//            );
//        }
//        return result;
//
//    }
//}
