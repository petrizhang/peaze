// Generated from /data/Users/pcz/Projects/peaze/grammer/Peaze.g4 by ANTLR 4.7
package com.pzque;
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
		LAMBDA=1, DEFINE=2, LPAREN=3, RPAREN=4, Digits=5, BooleanLiteral=6, DecimalLiteral=7, 
		ID=8, WS=9, COMMENT=10, COMMENT1=11, LINE_COMMENT=12, LINE_COMMENT1=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LAMBDA", "DEFINE", "LPAREN", "RPAREN", "Digits", "BooleanLiteral", "DecimalLiteral", 
		"ID", "WS", "COMMENT", "COMMENT1", "LINE_COMMENT", "LINE_COMMENT1"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'lambda'", "'define'", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LAMBDA", "DEFINE", "LPAREN", "RPAREN", "Digits", "BooleanLiteral", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\17}\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\6\6\61\n\6\r\6\16\6\62\3\7\3\7\3"+
		"\7\3\7\5\79\n\7\3\b\3\b\3\b\3\b\3\t\6\t@\n\t\r\t\16\tA\3\n\6\nE\n\n\r"+
		"\n\16\nF\3\n\3\n\3\13\3\13\3\13\3\13\7\13O\n\13\f\13\16\13R\13\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\7\f]\n\f\f\f\16\f`\13\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\r\7\rk\n\r\f\r\16\rn\13\r\3\r\3\r\3\16\3\16\3"+
		"\16\3\16\3\16\7\16w\n\16\f\16\16\16z\13\16\3\16\3\16\4P^\2\17\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\3\2\6\3\2\62;"+
		"\t\2##&(,<>\\`ac|\u0080\u0080\5\2\13\f\16\17\"\"\4\2\f\f\17\17\2\u0084"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\3\35\3\2\2\2\5$\3\2\2\2\7+\3\2\2\2\t-\3\2\2"+
		"\2\13\60\3\2\2\2\r8\3\2\2\2\17:\3\2\2\2\21?\3\2\2\2\23D\3\2\2\2\25J\3"+
		"\2\2\2\27X\3\2\2\2\31f\3\2\2\2\33q\3\2\2\2\35\36\7n\2\2\36\37\7c\2\2\37"+
		" \7o\2\2 !\7d\2\2!\"\7f\2\2\"#\7c\2\2#\4\3\2\2\2$%\7f\2\2%&\7g\2\2&\'"+
		"\7h\2\2\'(\7k\2\2()\7p\2\2)*\7g\2\2*\6\3\2\2\2+,\7*\2\2,\b\3\2\2\2-.\7"+
		"+\2\2.\n\3\2\2\2/\61\t\2\2\2\60/\3\2\2\2\61\62\3\2\2\2\62\60\3\2\2\2\62"+
		"\63\3\2\2\2\63\f\3\2\2\2\64\65\7%\2\2\659\7v\2\2\66\67\7%\2\2\679\7h\2"+
		"\28\64\3\2\2\28\66\3\2\2\29\16\3\2\2\2:;\5\13\6\2;<\7\60\2\2<=\5\13\6"+
		"\2=\20\3\2\2\2>@\t\3\2\2?>\3\2\2\2@A\3\2\2\2A?\3\2\2\2AB\3\2\2\2B\22\3"+
		"\2\2\2CE\t\4\2\2DC\3\2\2\2EF\3\2\2\2FD\3\2\2\2FG\3\2\2\2GH\3\2\2\2HI\b"+
		"\n\2\2I\24\3\2\2\2JK\7\61\2\2KL\7,\2\2LP\3\2\2\2MO\13\2\2\2NM\3\2\2\2"+
		"OR\3\2\2\2PQ\3\2\2\2PN\3\2\2\2QS\3\2\2\2RP\3\2\2\2ST\7,\2\2TU\7\61\2\2"+
		"UV\3\2\2\2VW\b\13\2\2W\26\3\2\2\2XY\7%\2\2YZ\7~\2\2Z^\3\2\2\2[]\13\2\2"+
		"\2\\[\3\2\2\2]`\3\2\2\2^_\3\2\2\2^\\\3\2\2\2_a\3\2\2\2`^\3\2\2\2ab\7~"+
		"\2\2bc\7%\2\2cd\3\2\2\2de\b\f\2\2e\30\3\2\2\2fg\7\61\2\2gh\7\61\2\2hl"+
		"\3\2\2\2ik\n\5\2\2ji\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2mo\3\2\2\2n"+
		"l\3\2\2\2op\b\r\2\2p\32\3\2\2\2qr\7=\2\2rs\7=\2\2st\7=\2\2tx\3\2\2\2u"+
		"w\n\5\2\2vu\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y{\3\2\2\2zx\3\2\2\2"+
		"{|\b\16\2\2|\34\3\2\2\2\13\2\628AFP^lx\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}