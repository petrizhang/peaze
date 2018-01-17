// Generated from /data/Users/pcz/Projects/peaze/grammer/Peaze.g4 by ANTLR 4.7
package com.pzque.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PeazeLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, LAMBDA=2, DEFINE=3, LPAREN=4, RPAREN=5, Digits=6, BooleanLiteral=7, 
		DecimalLiteral=8, ID=9, WS=10, COMMENT=11, COMMENT1=12, LINE_COMMENT=13, 
		LINE_COMMENT1=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "LAMBDA", "DEFINE", "LPAREN", "RPAREN", "Digits", "BooleanLiteral", 
		"DecimalLiteral", "ID", "WS", "COMMENT", "COMMENT1", "LINE_COMMENT", "LINE_COMMENT1"
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


	public PeazeLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Peaze.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20\u0082\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\6\7\66"+
		"\n\7\r\7\16\7\67\3\b\3\b\3\b\3\b\5\b>\n\b\3\t\3\t\3\t\3\t\3\n\6\nE\n\n"+
		"\r\n\16\nF\3\13\6\13J\n\13\r\13\16\13K\3\13\3\13\3\f\3\f\3\f\3\f\7\fT"+
		"\n\f\f\f\16\fW\13\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\7\rb\n\r\f\r\16"+
		"\re\13\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\7\16p\n\16\f\16\16\16"+
		"s\13\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\7\17|\n\17\f\17\16\17\177\13"+
		"\17\3\17\3\17\4Uc\2\20\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\3\2\6\3\2\62;\t\2##&(,<>\\`ac|\u0080\u0080\5\2\13"+
		"\f\16\17\"\"\4\2\f\f\17\17\2\u0089\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\3\37\3\2\2\2\5\"\3\2\2\2\7)\3\2\2\2\t\60\3\2\2\2\13\62\3\2\2\2\r\65"+
		"\3\2\2\2\17=\3\2\2\2\21?\3\2\2\2\23D\3\2\2\2\25I\3\2\2\2\27O\3\2\2\2\31"+
		"]\3\2\2\2\33k\3\2\2\2\35v\3\2\2\2\37 \7k\2\2 !\7h\2\2!\4\3\2\2\2\"#\7"+
		"n\2\2#$\7c\2\2$%\7o\2\2%&\7d\2\2&\'\7f\2\2\'(\7c\2\2(\6\3\2\2\2)*\7f\2"+
		"\2*+\7g\2\2+,\7h\2\2,-\7k\2\2-.\7p\2\2./\7g\2\2/\b\3\2\2\2\60\61\7*\2"+
		"\2\61\n\3\2\2\2\62\63\7+\2\2\63\f\3\2\2\2\64\66\t\2\2\2\65\64\3\2\2\2"+
		"\66\67\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28\16\3\2\2\29:\7%\2\2:>\7v\2\2"+
		";<\7%\2\2<>\7h\2\2=9\3\2\2\2=;\3\2\2\2>\20\3\2\2\2?@\5\r\7\2@A\7\60\2"+
		"\2AB\5\r\7\2B\22\3\2\2\2CE\t\3\2\2DC\3\2\2\2EF\3\2\2\2FD\3\2\2\2FG\3\2"+
		"\2\2G\24\3\2\2\2HJ\t\4\2\2IH\3\2\2\2JK\3\2\2\2KI\3\2\2\2KL\3\2\2\2LM\3"+
		"\2\2\2MN\b\13\2\2N\26\3\2\2\2OP\7\61\2\2PQ\7,\2\2QU\3\2\2\2RT\13\2\2\2"+
		"SR\3\2\2\2TW\3\2\2\2UV\3\2\2\2US\3\2\2\2VX\3\2\2\2WU\3\2\2\2XY\7,\2\2"+
		"YZ\7\61\2\2Z[\3\2\2\2[\\\b\f\2\2\\\30\3\2\2\2]^\7%\2\2^_\7~\2\2_c\3\2"+
		"\2\2`b\13\2\2\2a`\3\2\2\2be\3\2\2\2cd\3\2\2\2ca\3\2\2\2df\3\2\2\2ec\3"+
		"\2\2\2fg\7~\2\2gh\7%\2\2hi\3\2\2\2ij\b\r\2\2j\32\3\2\2\2kl\7\61\2\2lm"+
		"\7\61\2\2mq\3\2\2\2np\n\5\2\2on\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2"+
		"rt\3\2\2\2sq\3\2\2\2tu\b\16\2\2u\34\3\2\2\2vw\7=\2\2wx\7=\2\2xy\7=\2\2"+
		"y}\3\2\2\2z|\n\5\2\2{z\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\u0080"+
		"\3\2\2\2\177}\3\2\2\2\u0080\u0081\b\17\2\2\u0081\36\3\2\2\2\13\2\67=F"+
		"KUcq}\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}