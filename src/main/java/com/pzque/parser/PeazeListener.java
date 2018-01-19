// Generated from /data/Users/pcz/Projects/peaze/grammer/Peaze.g4 by ANTLR 4.7
package com.pzque.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PeazeParser}.
 */
public interface PeazeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PeazeParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PeazeParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PeazeParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PeazeParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DefineTopunit}
	 * labeled alternative in {@link PeazeParser#topunit}.
	 * @param ctx the parse tree
	 */
	void enterDefineTopunit(PeazeParser.DefineTopunitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DefineTopunit}
	 * labeled alternative in {@link PeazeParser#topunit}.
	 * @param ctx the parse tree
	 */
	void exitDefineTopunit(PeazeParser.DefineTopunitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ApplyTopunit}
	 * labeled alternative in {@link PeazeParser#topunit}.
	 * @param ctx the parse tree
	 */
	void enterApplyTopunit(PeazeParser.ApplyTopunitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ApplyTopunit}
	 * labeled alternative in {@link PeazeParser#topunit}.
	 * @param ctx the parse tree
	 */
	void exitApplyTopunit(PeazeParser.ApplyTopunitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ProcDefine}
	 * labeled alternative in {@link PeazeParser#define}.
	 * @param ctx the parse tree
	 */
	void enterProcDefine(PeazeParser.ProcDefineContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ProcDefine}
	 * labeled alternative in {@link PeazeParser#define}.
	 * @param ctx the parse tree
	 */
	void exitProcDefine(PeazeParser.ProcDefineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LambdaDefine}
	 * labeled alternative in {@link PeazeParser#define}.
	 * @param ctx the parse tree
	 */
	void enterLambdaDefine(PeazeParser.LambdaDefineContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LambdaDefine}
	 * labeled alternative in {@link PeazeParser#define}.
	 * @param ctx the parse tree
	 */
	void exitLambdaDefine(PeazeParser.LambdaDefineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarDefine}
	 * labeled alternative in {@link PeazeParser#define}.
	 * @param ctx the parse tree
	 */
	void enterVarDefine(PeazeParser.VarDefineContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarDefine}
	 * labeled alternative in {@link PeazeParser#define}.
	 * @param ctx the parse tree
	 */
	void exitVarDefine(PeazeParser.VarDefineContext ctx);
	/**
	 * Enter a parse tree produced by {@link PeazeParser#apply}.
	 * @param ctx the parse tree
	 */
	void enterApply(PeazeParser.ApplyContext ctx);
	/**
	 * Exit a parse tree produced by {@link PeazeParser#apply}.
	 * @param ctx the parse tree
	 */
	void exitApply(PeazeParser.ApplyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfExpr}
	 * labeled alternative in {@link PeazeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIfExpr(PeazeParser.IfExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfExpr}
	 * labeled alternative in {@link PeazeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIfExpr(PeazeParser.IfExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralExpr}
	 * labeled alternative in {@link PeazeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpr(PeazeParser.LiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralExpr}
	 * labeled alternative in {@link PeazeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpr(PeazeParser.LiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ApplyExpr}
	 * labeled alternative in {@link PeazeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterApplyExpr(PeazeParser.ApplyExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ApplyExpr}
	 * labeled alternative in {@link PeazeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitApplyExpr(PeazeParser.ApplyExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LambdaExpr}
	 * labeled alternative in {@link PeazeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLambdaExpr(PeazeParser.LambdaExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LambdaExpr}
	 * labeled alternative in {@link PeazeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLambdaExpr(PeazeParser.LambdaExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarRefExpr}
	 * labeled alternative in {@link PeazeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVarRefExpr(PeazeParser.VarRefExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarRefExpr}
	 * labeled alternative in {@link PeazeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVarRefExpr(PeazeParser.VarRefExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FullIf}
	 * labeled alternative in {@link PeazeParser#if_}.
	 * @param ctx the parse tree
	 */
	void enterFullIf(PeazeParser.FullIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FullIf}
	 * labeled alternative in {@link PeazeParser#if_}.
	 * @param ctx the parse tree
	 */
	void exitFullIf(PeazeParser.FullIfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PartialIf}
	 * labeled alternative in {@link PeazeParser#if_}.
	 * @param ctx the parse tree
	 */
	void enterPartialIf(PeazeParser.PartialIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PartialIf}
	 * labeled alternative in {@link PeazeParser#if_}.
	 * @param ctx the parse tree
	 */
	void exitPartialIf(PeazeParser.PartialIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link PeazeParser#lambda}.
	 * @param ctx the parse tree
	 */
	void enterLambda(PeazeParser.LambdaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PeazeParser#lambda}.
	 * @param ctx the parse tree
	 */
	void exitLambda(PeazeParser.LambdaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PeazeParser#varRef}.
	 * @param ctx the parse tree
	 */
	void enterVarRef(PeazeParser.VarRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link PeazeParser#varRef}.
	 * @param ctx the parse tree
	 */
	void exitVarRef(PeazeParser.VarRefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntegerLiteral}
	 * labeled alternative in {@link PeazeParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterIntegerLiteral(PeazeParser.IntegerLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntegerLiteral}
	 * labeled alternative in {@link PeazeParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitIntegerLiteral(PeazeParser.IntegerLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BooleanLiteral}
	 * labeled alternative in {@link PeazeParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(PeazeParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BooleanLiteral}
	 * labeled alternative in {@link PeazeParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(PeazeParser.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DecimalLiteral}
	 * labeled alternative in {@link PeazeParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterDecimalLiteral(PeazeParser.DecimalLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DecimalLiteral}
	 * labeled alternative in {@link PeazeParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitDecimalLiteral(PeazeParser.DecimalLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link PeazeParser#sequence}.
	 * @param ctx the parse tree
	 */
	void enterSequence(PeazeParser.SequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link PeazeParser#sequence}.
	 * @param ctx the parse tree
	 */
	void exitSequence(PeazeParser.SequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link PeazeParser#procedure}.
	 * @param ctx the parse tree
	 */
	void enterProcedure(PeazeParser.ProcedureContext ctx);
	/**
	 * Exit a parse tree produced by {@link PeazeParser#procedure}.
	 * @param ctx the parse tree
	 */
	void exitProcedure(PeazeParser.ProcedureContext ctx);
	/**
	 * Enter a parse tree produced by {@link PeazeParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(PeazeParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link PeazeParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(PeazeParser.CondContext ctx);
	/**
	 * Enter a parse tree produced by {@link PeazeParser#else_body}.
	 * @param ctx the parse tree
	 */
	void enterElse_body(PeazeParser.Else_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link PeazeParser#else_body}.
	 * @param ctx the parse tree
	 */
	void exitElse_body(PeazeParser.Else_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link PeazeParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(PeazeParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PeazeParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(PeazeParser.ParamListContext ctx);
}