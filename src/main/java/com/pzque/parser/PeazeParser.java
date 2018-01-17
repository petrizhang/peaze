// Generated from /data/Users/pcz/Projects/peaze/grammer/Peaze.g4 by ANTLR 4.7
package com.pzque.parser;
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
		T__0=1, LAMBDA=2, DEFINE=3, LPAREN=4, RPAREN=5, Digits=6, BooleanLiteral=7, 
		DecimalLiteral=8, ID=9, WS=10, COMMENT=11, COMMENT1=12, LINE_COMMENT=13, 
		LINE_COMMENT1=14;
	public static final int
		RULE_program = 0, RULE_topunit = 1, RULE_define = 2, RULE_apply = 3, RULE_expr = 4, 
		RULE_if_ = 5, RULE_lambda = 6, RULE_varRef = 7, RULE_literal = 8, RULE_sequence = 9, 
		RULE_procedure = 10, RULE_cond = 11, RULE_else_body = 12, RULE_paramList = 13;
	public static final String[] ruleNames = {
		"program", "topunit", "define", "apply", "expr", "if_", "lambda", "varRef", 
		"literal", "sequence", "procedure", "cond", "else_body", "paramList"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'if'", "'lambda'", "'define'", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "LAMBDA", "DEFINE", "LPAREN", "RPAREN", "Digits", "BooleanLiteral", 
		"DecimalLiteral", "ID", "WS", "COMMENT", "COMMENT1", "LINE_COMMENT", "LINE_COMMENT1"
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
			setState(29); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(28);
				topunit();
				}
				}
				setState(31); 
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
			setState(35);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new DefineTopunitContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(33);
				define();
				}
				break;
			case 2:
				_localctx = new ApplyTopunitContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(34);
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
	public static class ProcDefineContext extends DefineContext {
		public TerminalNode DEFINE() { return getToken(PeazeParser.DEFINE, 0); }
		public TerminalNode ID() { return getToken(PeazeParser.ID, 0); }
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public ProcDefineContext(DefineContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PeazeVisitor ) return ((PeazeVisitor<? extends T>)visitor).visitProcDefine(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LambdaDefineContext extends DefineContext {
		public TerminalNode DEFINE() { return getToken(PeazeParser.DEFINE, 0); }
		public TerminalNode ID() { return getToken(PeazeParser.ID, 0); }
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
		public TerminalNode ID() { return getToken(PeazeParser.ID, 0); }
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
		enterRule(_localctx, 4, RULE_define);
		try {
			setState(58);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new ProcDefineContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				match(LPAREN);
				setState(38);
				match(DEFINE);
				setState(39);
				match(LPAREN);
				setState(40);
				match(ID);
				setState(41);
				paramList();
				setState(42);
				match(RPAREN);
				setState(43);
				sequence();
				setState(44);
				match(RPAREN);
				}
				break;
			case 2:
				_localctx = new LambdaDefineContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				match(LPAREN);
				setState(47);
				match(DEFINE);
				setState(48);
				match(ID);
				setState(49);
				lambda();
				setState(50);
				match(RPAREN);
				}
				break;
			case 3:
				_localctx = new VarDefineContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(52);
				match(LPAREN);
				setState(53);
				match(DEFINE);
				setState(54);
				match(ID);
				setState(55);
				expr();
				setState(56);
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
		public ProcedureContext procedure() {
			return getRuleContext(ProcedureContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ApplyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_apply; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PeazeVisitor ) return ((PeazeVisitor<? extends T>)visitor).visitApply(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ApplyContext apply() throws RecognitionException {
		ApplyContext _localctx = new ApplyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_apply);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(LPAREN);
			setState(61);
			procedure();
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << Digits) | (1L << BooleanLiteral) | (1L << DecimalLiteral) | (1L << ID))) != 0)) {
				{
				{
				setState(62);
				expr();
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(68);
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
	public static class IfExprContext extends ExprContext {
		public If_Context if_() {
			return getRuleContext(If_Context.class,0);
		}
		public IfExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PeazeVisitor ) return ((PeazeVisitor<? extends T>)visitor).visitIfExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarRefExprContext extends ExprContext {
		public VarRefContext varRef() {
			return getRuleContext(VarRefContext.class,0);
		}
		public VarRefExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PeazeVisitor ) return ((PeazeVisitor<? extends T>)visitor).visitVarRefExpr(this);
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

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expr);
		try {
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new IfExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				if_();
				}
				break;
			case 2:
				_localctx = new LiteralExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				literal();
				}
				break;
			case 3:
				_localctx = new ApplyExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(72);
				apply();
				}
				break;
			case 4:
				_localctx = new LambdaExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(73);
				lambda();
				}
				break;
			case 5:
				_localctx = new VarRefExprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(74);
				varRef();
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

	public static class If_Context extends ParserRuleContext {
		public If_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_; }
	 
		public If_Context() { }
		public void copyFrom(If_Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FullIfContext extends If_Context {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Else_bodyContext else_body() {
			return getRuleContext(Else_bodyContext.class,0);
		}
		public FullIfContext(If_Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PeazeVisitor ) return ((PeazeVisitor<? extends T>)visitor).visitFullIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PartialIfContext extends If_Context {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PartialIfContext(If_Context ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PeazeVisitor ) return ((PeazeVisitor<? extends T>)visitor).visitPartialIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_Context if_() throws RecognitionException {
		If_Context _localctx = new If_Context(_ctx, getState());
		enterRule(_localctx, 10, RULE_if_);
		try {
			setState(90);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new FullIfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				match(LPAREN);
				setState(78);
				match(T__0);
				setState(79);
				cond();
				setState(80);
				expr();
				setState(81);
				else_body();
				setState(82);
				match(RPAREN);
				}
				break;
			case 2:
				_localctx = new PartialIfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				match(LPAREN);
				setState(85);
				match(T__0);
				setState(86);
				cond();
				setState(87);
				expr();
				setState(88);
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

	public static class LambdaContext extends ParserRuleContext {
		public TerminalNode LAMBDA() { return getToken(PeazeParser.LAMBDA, 0); }
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
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
		enterRule(_localctx, 12, RULE_lambda);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(LPAREN);
			setState(93);
			match(LAMBDA);
			setState(94);
			match(LPAREN);
			setState(95);
			paramList();
			setState(96);
			match(RPAREN);
			setState(97);
			sequence();
			setState(98);
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

	public static class VarRefContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PeazeParser.ID, 0); }
		public VarRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varRef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PeazeVisitor ) return ((PeazeVisitor<? extends T>)visitor).visitVarRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarRefContext varRef() throws RecognitionException {
		VarRefContext _localctx = new VarRefContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_varRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(ID);
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
		enterRule(_localctx, 16, RULE_literal);
		try {
			setState(105);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Digits:
				_localctx = new IntegerLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				match(Digits);
				}
				break;
			case BooleanLiteral:
				_localctx = new BooleanLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				match(BooleanLiteral);
				}
				break;
			case DecimalLiteral:
				_localctx = new DecimalLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(104);
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
		enterRule(_localctx, 18, RULE_sequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(109);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(107);
					define();
					}
					break;
				case 2:
					{
					setState(108);
					expr();
					}
					break;
				}
				}
				setState(111); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << Digits) | (1L << BooleanLiteral) | (1L << DecimalLiteral) | (1L << ID))) != 0) );
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

	public static class ProcedureContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ProcedureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedure; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PeazeVisitor ) return ((PeazeVisitor<? extends T>)visitor).visitProcedure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcedureContext procedure() throws RecognitionException {
		ProcedureContext _localctx = new ProcedureContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_procedure);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			expr();
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

	public static class CondContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PeazeVisitor ) return ((PeazeVisitor<? extends T>)visitor).visitCond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		CondContext _localctx = new CondContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cond);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			expr();
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

	public static class Else_bodyContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Else_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_body; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PeazeVisitor ) return ((PeazeVisitor<? extends T>)visitor).visitElse_body(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_bodyContext else_body() throws RecognitionException {
		Else_bodyContext _localctx = new Else_bodyContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_else_body);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			expr();
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

	public static class ParamListContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(PeazeParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PeazeParser.ID, i);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PeazeVisitor ) return ((PeazeVisitor<? extends T>)visitor).visitParamList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(119);
				match(ID);
				}
				}
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\20\u0080\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\6\2 \n\2\r\2\16\2!\3\3\3"+
		"\3\5\3&\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4=\n\4\3\5\3\5\3\5\7\5B\n\5\f\5\16\5E\13"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\5\6N\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\5\7]\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\n\3\n\3\n\5\nl\n\n\3\13\3\13\6\13p\n\13\r\13\16\13q\3\f\3\f\3\r\3"+
		"\r\3\16\3\16\3\17\7\17{\n\17\f\17\16\17~\13\17\3\17\2\2\20\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\34\2\2\2\u0080\2\37\3\2\2\2\4%\3\2\2\2\6<\3\2\2"+
		"\2\b>\3\2\2\2\nM\3\2\2\2\f\\\3\2\2\2\16^\3\2\2\2\20f\3\2\2\2\22k\3\2\2"+
		"\2\24o\3\2\2\2\26s\3\2\2\2\30u\3\2\2\2\32w\3\2\2\2\34|\3\2\2\2\36 \5\4"+
		"\3\2\37\36\3\2\2\2 !\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"\3\3\2\2\2#&\5\6"+
		"\4\2$&\5\b\5\2%#\3\2\2\2%$\3\2\2\2&\5\3\2\2\2\'(\7\6\2\2()\7\5\2\2)*\7"+
		"\6\2\2*+\7\13\2\2+,\5\34\17\2,-\7\7\2\2-.\5\24\13\2./\7\7\2\2/=\3\2\2"+
		"\2\60\61\7\6\2\2\61\62\7\5\2\2\62\63\7\13\2\2\63\64\5\16\b\2\64\65\7\7"+
		"\2\2\65=\3\2\2\2\66\67\7\6\2\2\678\7\5\2\289\7\13\2\29:\5\n\6\2:;\7\7"+
		"\2\2;=\3\2\2\2<\'\3\2\2\2<\60\3\2\2\2<\66\3\2\2\2=\7\3\2\2\2>?\7\6\2\2"+
		"?C\5\26\f\2@B\5\n\6\2A@\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2DF\3\2\2"+
		"\2EC\3\2\2\2FG\7\7\2\2G\t\3\2\2\2HN\5\f\7\2IN\5\22\n\2JN\5\b\5\2KN\5\16"+
		"\b\2LN\5\20\t\2MH\3\2\2\2MI\3\2\2\2MJ\3\2\2\2MK\3\2\2\2ML\3\2\2\2N\13"+
		"\3\2\2\2OP\7\6\2\2PQ\7\3\2\2QR\5\30\r\2RS\5\n\6\2ST\5\32\16\2TU\7\7\2"+
		"\2U]\3\2\2\2VW\7\6\2\2WX\7\3\2\2XY\5\30\r\2YZ\5\n\6\2Z[\7\7\2\2[]\3\2"+
		"\2\2\\O\3\2\2\2\\V\3\2\2\2]\r\3\2\2\2^_\7\6\2\2_`\7\4\2\2`a\7\6\2\2ab"+
		"\5\34\17\2bc\7\7\2\2cd\5\24\13\2de\7\7\2\2e\17\3\2\2\2fg\7\13\2\2g\21"+
		"\3\2\2\2hl\7\b\2\2il\7\t\2\2jl\7\n\2\2kh\3\2\2\2ki\3\2\2\2kj\3\2\2\2l"+
		"\23\3\2\2\2mp\5\6\4\2np\5\n\6\2om\3\2\2\2on\3\2\2\2pq\3\2\2\2qo\3\2\2"+
		"\2qr\3\2\2\2r\25\3\2\2\2st\5\n\6\2t\27\3\2\2\2uv\5\n\6\2v\31\3\2\2\2w"+
		"x\5\n\6\2x\33\3\2\2\2y{\7\13\2\2zy\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2"+
		"\2}\35\3\2\2\2~|\3\2\2\2\f!%<CM\\koq|";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}