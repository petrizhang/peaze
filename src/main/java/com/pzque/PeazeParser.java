// Generated from /data/Users/pcz/Projects/peaze/grammer/Peaze.g4 by ANTLR 4.7
package com.pzque;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PeazeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LAMBDA=1, DEFINE=2, LPAREN=3, RPAREN=4, GT=5, LT=6, BANG=7, TILDE=8, EQUAL=9, 
		LE=10, GE=11, NOTEQUAL=12, AND=13, OR=14, XOR=15, ADD=16, SUB=17, MUL=18, 
		DIV=19, MOD=20, BITAND=21, BITOR=22, CARET=23, Digits=24, BooleanLiteral=25, 
		DecimalLiteral=26, SYMBOL=27, SYMBOL_HEAD=28, WS=29, COMMENT=30, COMMENT1=31, 
		LINE_COMMENT=32, LINE_COMMENT1=33;
	public static final int
		RULE_program = 0, RULE_topunit = 1, RULE_lambda = 2, RULE_define = 3, 
		RULE_apply = 4, RULE_sequence = 5, RULE_expr = 6, RULE_empty = 7, RULE_builtin = 8, 
		RULE_literal = 9, RULE_symbol = 10;
	public static final String[] ruleNames = {
		"program", "topunit", "lambda", "define", "apply", "sequence", "expr", 
		"empty", "builtin", "literal", "symbol"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'lambda'", "'define'", "'('", "')'", "'>'", "'<'", "'!'", "'~'", 
		"'='", "'<='", "'>='", "'!='", "'and'", "'or'", "'xor'", "'+'", "'-'", 
		"'*'", "'/'", "'%'", "'&'", "'|'", "'^'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LAMBDA", "DEFINE", "LPAREN", "RPAREN", "GT", "LT", "BANG", "TILDE", 
		"EQUAL", "LE", "GE", "NOTEQUAL", "AND", "OR", "XOR", "ADD", "SUB", "MUL", 
		"DIV", "MOD", "BITAND", "BITOR", "CARET", "Digits", "BooleanLiteral", 
		"DecimalLiteral", "SYMBOL", "SYMBOL_HEAD", "WS", "COMMENT", "COMMENT1", 
		"LINE_COMMENT", "LINE_COMMENT1"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Peaze.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PeazeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<TopunitContext> topunit() {
			return getRuleContexts(TopunitContext.class);
		}
		public TopunitContext topunit(int i) {
			return getRuleContext(TopunitContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PeazeVisitor ) return ((PeazeVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(22);
				topunit();
				}
				}
				setState(25); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LPAREN );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TopunitContext extends ParserRuleContext {
		public TopunitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_topunit; }
	 
		public TopunitContext() { }
		public void copyFrom(TopunitContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ApplyTopunitContext extends TopunitContext {
		public ApplyContext apply() {
			return getRuleContext(ApplyContext.class,0);
		}
		public ApplyTopunitContext(TopunitContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PeazeVisitor ) return ((PeazeVisitor<? extends T>)visitor).visitApplyTopunit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DefineTopunitContext extends TopunitContext {
		public DefineContext define() {
			return getRuleContext(DefineContext.class,0);
		}
		public DefineTopunitContext(TopunitContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PeazeVisitor ) return ((PeazeVisitor<? extends T>)visitor).visitDefineTopunit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TopunitContext topunit() throws RecognitionException {
		TopunitContext _localctx = new TopunitContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_topunit);
		try {
			setState(29);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new DefineTopunitContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(27);
				define();
				}
				break;
			case 2:
				_localctx = new ApplyTopunitContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(28);
				apply();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LambdaContext extends ParserRuleContext {
		public TerminalNode LAMBDA() { return getToken(PeazeParser.LAMBDA, 0); }
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public List<SymbolContext> symbol() {
			return getRuleContexts(SymbolContext.class);
		}
		public SymbolContext symbol(int i) {
			return getRuleContext(SymbolContext.class,i);
		}
		public LambdaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PeazeVisitor ) return ((PeazeVisitor<? extends T>)visitor).visitLambda(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaContext lambda() throws RecognitionException {
		LambdaContext _localctx = new LambdaContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_lambda);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			match(LPAREN);
			setState(32);
			match(LAMBDA);
			setState(33);
			match(LPAREN);
			setState(35); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(34);
				symbol();
				}
				}
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SYMBOL );
			setState(39);
			match(RPAREN);
			setState(40);
			sequence();
			setState(41);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefineContext extends ParserRuleContext {
		public DefineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define; }
	 
		public DefineContext() { }
		public void copyFrom(DefineContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FuncDefineContext extends DefineContext {
		public TerminalNode DEFINE() { return getToken(PeazeParser.DEFINE, 0); }
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public List<SymbolContext> symbol() {
			return getRuleContexts(SymbolContext.class);
		}
		public SymbolContext symbol(int i) {
			return getRuleContext(SymbolContext.class,i);
		}
		public FuncDefineContext(DefineContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PeazeVisitor ) return ((PeazeVisitor<? extends T>)visitor).visitFuncDefine(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LambdaDefineContext extends DefineContext {
		public TerminalNode DEFINE() { return getToken(PeazeParser.DEFINE, 0); }
		public SymbolContext symbol() {
			return getRuleContext(SymbolContext.class,0);
		}
		public LambdaContext lambda() {
			return getRuleContext(LambdaContext.class,0);
		}
		public LambdaDefineContext(DefineContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PeazeVisitor ) return ((PeazeVisitor<? extends T>)visitor).visitLambdaDefine(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarDefineContext extends DefineContext {
		public TerminalNode DEFINE() { return getToken(PeazeParser.DEFINE, 0); }
		public SymbolContext symbol() {
			return getRuleContext(SymbolContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarDefineContext(DefineContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PeazeVisitor ) return ((PeazeVisitor<? extends T>)visitor).visitVarDefine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefineContext define() throws RecognitionException {
		DefineContext _localctx = new DefineContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_define);
		int _la;
		try {
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new FuncDefineContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				match(LPAREN);
				setState(44);
				match(DEFINE);
				setState(45);
				match(LPAREN);
				setState(47); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(46);
					symbol();
					}
					}
					setState(49); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==SYMBOL );
				setState(51);
				match(RPAREN);
				setState(52);
				sequence();
				setState(53);
				match(RPAREN);
				}
				break;
			case 2:
				_localctx = new LambdaDefineContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				match(LPAREN);
				setState(56);
				match(DEFINE);
				setState(57);
				symbol();
				setState(58);
				lambda();
				setState(59);
				match(RPAREN);
				}
				break;
			case 3:
				_localctx = new VarDefineContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(61);
				match(LPAREN);
				setState(62);
				match(DEFINE);
				setState(63);
				symbol();
				setState(64);
				expr();
				setState(65);
				match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ApplyContext extends ParserRuleContext {
		public ApplyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_apply; }
	 
		public ApplyContext() { }
		public void copyFrom(ApplyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprApplyContext extends ApplyContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprApplyContext(ApplyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PeazeVisitor ) return ((PeazeVisitor<? extends T>)visitor).visitExprApply(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LambdaApplyContext extends ApplyContext {
		public LambdaContext lambda() {
			return getRuleContext(LambdaContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LambdaApplyContext(ApplyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PeazeVisitor ) return ((PeazeVisitor<? extends T>)visitor).visitLambdaApply(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BuiltinApplyContext extends ApplyContext {
		public BuiltinContext builtin() {
			return getRuleContext(BuiltinContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BuiltinApplyContext(ApplyContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PeazeVisitor ) return ((PeazeVisitor<? extends T>)visitor).visitBuiltinApply(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ApplyContext apply() throws RecognitionException {
		ApplyContext _localctx = new ApplyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_apply);
		int _la;
		try {
			setState(97);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new BuiltinApplyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				match(LPAREN);
				setState(70);
				builtin();
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << Digits) | (1L << BooleanLiteral) | (1L << DecimalLiteral) | (1L << SYMBOL))) != 0)) {
					{
					{
					setState(71);
					expr();
					}
					}
					setState(76);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(77);
				match(RPAREN);
				}
				break;
			case 2:
				_localctx = new LambdaApplyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				match(LPAREN);
				setState(80);
				lambda();
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << Digits) | (1L << BooleanLiteral) | (1L << DecimalLiteral) | (1L << SYMBOL))) != 0)) {
					{
					{
					setState(81);
					expr();
					}
					}
					setState(86);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(87);
				match(RPAREN);
				}
				break;
			case 3:
				_localctx = new ExprApplyContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(89);
				match(LPAREN);
				setState(91); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(90);
					expr();
					}
					}
					setState(93); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << Digits) | (1L << BooleanLiteral) | (1L << DecimalLiteral) | (1L << SYMBOL))) != 0) );
				setState(95);
				match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SequenceContext extends ParserRuleContext {
		public List<DefineContext> define() {
			return getRuleContexts(DefineContext.class);
		}
		public DefineContext define(int i) {
			return getRuleContext(DefineContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequence; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PeazeVisitor ) return ((PeazeVisitor<? extends T>)visitor).visitSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SequenceContext sequence() throws RecognitionException {
		SequenceContext _localctx = new SequenceContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_sequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(101);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(99);
					define();
					}
					break;
				case 2:
					{
					setState(100);
					expr();
					}
					break;
				}
				}
				setState(103); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << Digits) | (1L << BooleanLiteral) | (1L << DecimalLiteral) | (1L << SYMBOL))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ApplyExprContext extends ExprContext {
		public ApplyContext apply() {
			return getRuleContext(ApplyContext.class,0);
		}
		public ApplyExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PeazeVisitor ) return ((PeazeVisitor<? extends T>)visitor).visitApplyExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LambdaExprContext extends ExprContext {
		public LambdaContext lambda() {
			return getRuleContext(LambdaContext.class,0);
		}
		public LambdaExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PeazeVisitor ) return ((PeazeVisitor<? extends T>)visitor).visitLambdaExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiteralExprContext extends ExprContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LiteralExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PeazeVisitor ) return ((PeazeVisitor<? extends T>)visitor).visitLiteralExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SymbolExprContext extends ExprContext {
		public SymbolContext symbol() {
			return getRuleContext(SymbolContext.class,0);
		}
		public SymbolExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PeazeVisitor ) return ((PeazeVisitor<? extends T>)visitor).visitSymbolExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_expr);
		try {
			setState(109);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new LiteralExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				literal();
				}
				break;
			case 2:
				_localctx = new SymbolExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				symbol();
				}
				break;
			case 3:
				_localctx = new LambdaExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(107);
				lambda();
				}
				break;
			case 4:
				_localctx = new ApplyExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(108);
				apply();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EmptyContext extends ParserRuleContext {
		public EmptyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_empty; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PeazeVisitor ) return ((PeazeVisitor<? extends T>)visitor).visitEmpty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EmptyContext empty() throws RecognitionException {
		EmptyContext _localctx = new EmptyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_empty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(LPAREN);
			setState(112);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BuiltinContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(PeazeParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(PeazeParser.SUB, 0); }
		public TerminalNode MUL() { return getToken(PeazeParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(PeazeParser.DIV, 0); }
		public BuiltinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtin; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PeazeVisitor ) return ((PeazeVisitor<? extends T>)visitor).visitBuiltin(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BuiltinContext builtin() throws RecognitionException {
		BuiltinContext _localctx = new BuiltinContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_builtin);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	 
		public LiteralContext() { }
		public void copyFrom(LiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BooleanLiteralContext extends LiteralContext {
		public TerminalNode BooleanLiteral() { return getToken(PeazeParser.BooleanLiteral, 0); }
		public BooleanLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PeazeVisitor ) return ((PeazeVisitor<? extends T>)visitor).visitBooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DecimalLiteralContext extends LiteralContext {
		public TerminalNode DecimalLiteral() { return getToken(PeazeParser.DecimalLiteral, 0); }
		public DecimalLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PeazeVisitor ) return ((PeazeVisitor<? extends T>)visitor).visitDecimalLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntegerLiteralContext extends LiteralContext {
		public TerminalNode Digits() { return getToken(PeazeParser.Digits, 0); }
		public IntegerLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PeazeVisitor ) return ((PeazeVisitor<? extends T>)visitor).visitIntegerLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_literal);
		try {
			setState(119);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Digits:
				_localctx = new IntegerLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				match(Digits);
				}
				break;
			case BooleanLiteral:
				_localctx = new BooleanLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
				match(BooleanLiteral);
				}
				break;
			case DecimalLiteral:
				_localctx = new DecimalLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(118);
				match(DecimalLiteral);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SymbolContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(PeazeParser.SYMBOL, 0); }
		public SymbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_symbol; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PeazeVisitor ) return ((PeazeVisitor<? extends T>)visitor).visitSymbol(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SymbolContext symbol() throws RecognitionException {
		SymbolContext _localctx = new SymbolContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_symbol);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(SYMBOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3#~\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f"+
		"\t\f\3\2\6\2\32\n\2\r\2\16\2\33\3\3\3\3\5\3 \n\3\3\4\3\4\3\4\3\4\6\4&"+
		"\n\4\r\4\16\4\'\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\6\5\62\n\5\r\5\16\5\63"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5F"+
		"\n\5\3\6\3\6\3\6\7\6K\n\6\f\6\16\6N\13\6\3\6\3\6\3\6\3\6\3\6\7\6U\n\6"+
		"\f\6\16\6X\13\6\3\6\3\6\3\6\3\6\6\6^\n\6\r\6\16\6_\3\6\3\6\5\6d\n\6\3"+
		"\7\3\7\6\7h\n\7\r\7\16\7i\3\b\3\b\3\b\3\b\5\bp\n\b\3\t\3\t\3\t\3\n\3\n"+
		"\3\13\3\13\3\13\5\13z\n\13\3\f\3\f\3\f\2\2\r\2\4\6\b\n\f\16\20\22\24\26"+
		"\2\3\3\2\22\25\2\u0084\2\31\3\2\2\2\4\37\3\2\2\2\6!\3\2\2\2\bE\3\2\2\2"+
		"\nc\3\2\2\2\fg\3\2\2\2\16o\3\2\2\2\20q\3\2\2\2\22t\3\2\2\2\24y\3\2\2\2"+
		"\26{\3\2\2\2\30\32\5\4\3\2\31\30\3\2\2\2\32\33\3\2\2\2\33\31\3\2\2\2\33"+
		"\34\3\2\2\2\34\3\3\2\2\2\35 \5\b\5\2\36 \5\n\6\2\37\35\3\2\2\2\37\36\3"+
		"\2\2\2 \5\3\2\2\2!\"\7\5\2\2\"#\7\3\2\2#%\7\5\2\2$&\5\26\f\2%$\3\2\2\2"+
		"&\'\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2()\3\2\2\2)*\7\6\2\2*+\5\f\7\2+,\7\6"+
		"\2\2,\7\3\2\2\2-.\7\5\2\2./\7\4\2\2/\61\7\5\2\2\60\62\5\26\f\2\61\60\3"+
		"\2\2\2\62\63\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\65\3\2\2\2\65\66\7"+
		"\6\2\2\66\67\5\f\7\2\678\7\6\2\28F\3\2\2\29:\7\5\2\2:;\7\4\2\2;<\5\26"+
		"\f\2<=\5\6\4\2=>\7\6\2\2>F\3\2\2\2?@\7\5\2\2@A\7\4\2\2AB\5\26\f\2BC\5"+
		"\16\b\2CD\7\6\2\2DF\3\2\2\2E-\3\2\2\2E9\3\2\2\2E?\3\2\2\2F\t\3\2\2\2G"+
		"H\7\5\2\2HL\5\22\n\2IK\5\16\b\2JI\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2"+
		"\2MO\3\2\2\2NL\3\2\2\2OP\7\6\2\2Pd\3\2\2\2QR\7\5\2\2RV\5\6\4\2SU\5\16"+
		"\b\2TS\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2WY\3\2\2\2XV\3\2\2\2YZ\7\6"+
		"\2\2Zd\3\2\2\2[]\7\5\2\2\\^\5\16\b\2]\\\3\2\2\2^_\3\2\2\2_]\3\2\2\2_`"+
		"\3\2\2\2`a\3\2\2\2ab\7\6\2\2bd\3\2\2\2cG\3\2\2\2cQ\3\2\2\2c[\3\2\2\2d"+
		"\13\3\2\2\2eh\5\b\5\2fh\5\16\b\2ge\3\2\2\2gf\3\2\2\2hi\3\2\2\2ig\3\2\2"+
		"\2ij\3\2\2\2j\r\3\2\2\2kp\5\24\13\2lp\5\26\f\2mp\5\6\4\2np\5\n\6\2ok\3"+
		"\2\2\2ol\3\2\2\2om\3\2\2\2on\3\2\2\2p\17\3\2\2\2qr\7\5\2\2rs\7\6\2\2s"+
		"\21\3\2\2\2tu\t\2\2\2u\23\3\2\2\2vz\7\32\2\2wz\7\33\2\2xz\7\34\2\2yv\3"+
		"\2\2\2yw\3\2\2\2yx\3\2\2\2z\25\3\2\2\2{|\7\35\2\2|\27\3\2\2\2\17\33\37"+
		"\'\63ELV_cgioy";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}