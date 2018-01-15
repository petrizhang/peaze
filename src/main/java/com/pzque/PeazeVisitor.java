// Generated from /data/Users/pcz/Projects/peaze/grammer/Peaze.g4 by ANTLR 4.7
package com.pzque;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PeazeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PeazeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PeazeParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PeazeParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DefineTopunit}
	 * labeled alternative in {@link PeazeParser#topunit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefineTopunit(PeazeParser.DefineTopunitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ApplyTopunit}
	 * labeled alternative in {@link PeazeParser#topunit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyTopunit(PeazeParser.ApplyTopunitContext ctx);
	/**
	 * Visit a parse tree produced by {@link PeazeParser#lambda}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambda(PeazeParser.LambdaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FuncDefine}
	 * labeled alternative in {@link PeazeParser#define}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDefine(PeazeParser.FuncDefineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LambdaDefine}
	 * labeled alternative in {@link PeazeParser#define}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaDefine(PeazeParser.LambdaDefineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VarDefine}
	 * labeled alternative in {@link PeazeParser#define}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefine(PeazeParser.VarDefineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BuiltinApply}
	 * labeled alternative in {@link PeazeParser#apply}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltinApply(PeazeParser.BuiltinApplyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LambdaApply}
	 * labeled alternative in {@link PeazeParser#apply}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaApply(PeazeParser.LambdaApplyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprApply}
	 * labeled alternative in {@link PeazeParser#apply}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprApply(PeazeParser.ExprApplyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PeazeParser#sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequence(PeazeParser.SequenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralExpr}
	 * labeled alternative in {@link PeazeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpr(PeazeParser.LiteralExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SymbolExpr}
	 * labeled alternative in {@link PeazeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolExpr(PeazeParser.SymbolExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LambdaExpr}
	 * labeled alternative in {@link PeazeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaExpr(PeazeParser.LambdaExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ApplyExpr}
	 * labeled alternative in {@link PeazeParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplyExpr(PeazeParser.ApplyExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PeazeParser#empty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmpty(PeazeParser.EmptyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PeazeParser#builtin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltin(PeazeParser.BuiltinContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntegerLiteral}
	 * labeled alternative in {@link PeazeParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLiteral(PeazeParser.IntegerLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BooleanLiteral}
	 * labeled alternative in {@link PeazeParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(PeazeParser.BooleanLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DecimalLiteral}
	 * labeled alternative in {@link PeazeParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimalLiteral(PeazeParser.DecimalLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link PeazeParser#symbol}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbol(PeazeParser.SymbolContext ctx);
}