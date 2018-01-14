// Generated from /home/zeta/Projects/peaze/grammer/Peaze.g4 by ANTLR 4.7
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
	 * Visit a parse tree produced by {@link PeazeParser#apply}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApply(PeazeParser.ApplyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PeazeParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(PeazeParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PeazeParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(PeazeParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PeazeParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(PeazeParser.FunctionContext ctx);
}