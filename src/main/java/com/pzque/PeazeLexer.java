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
		LAMBDA=1, DEFINE=2, LPAREN=3, RPAREN=4, GT=5, LT=6, BANG=7, TILDE=8, EQUAL=9, 
		LE=10, GE=11, NOTEQUAL=12, AND=13, OR=14, XOR=15, ADD=16, SUB=17, MUL=18, 
		DIV=19, MOD=20, BITAND=21, BITOR=22, CARET=23, Digits=24, BooleanLiteral=25, 
		DecimalLiteral=26, SYMBOL=27, SYMBOL_HEAD=28, WS=29, COMMENT=30, COMMENT1=31, 
		LINE_COMMENT=32, LINE_COMMENT1=33;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LAMBDA", "DEFINE", "LPAREN", "RPAREN", "GT", "LT", "BANG", "TILDE", "EQUAL", 
		"LE", "GE", "NOTEQUAL", "AND", "OR", "XOR", "ADD", "SUB", "MUL", "DIV", 
		"MOD", "BITAND", "BITOR", "CARET", "Digits", "BooleanLiteral", "DecimalLiteral", 
		"SYMBOL", "SYMBOL_HEAD", "WS", "COMMENT", "COMMENT1", "LINE_COMMENT", 
		"LINE_COMMENT1"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2#\u00df\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\31\6\31\u0087\n\31\r\31\16\31\u0088\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0094\n\32\3\33\3\33\3\33\3\33"+
		"\3\34\3\34\7\34\u009c\n\34\f\34\16\34\u009f\13\34\3\35\6\35\u00a2\n\35"+
		"\r\35\16\35\u00a3\3\36\6\36\u00a7\n\36\r\36\16\36\u00a8\3\36\3\36\3\37"+
		"\3\37\3\37\3\37\7\37\u00b1\n\37\f\37\16\37\u00b4\13\37\3\37\3\37\3\37"+
		"\3\37\3\37\3 \3 \3 \3 \7 \u00bf\n \f \16 \u00c2\13 \3 \3 \3 \3 \3 \3!"+
		"\3!\3!\3!\7!\u00cd\n!\f!\16!\u00d0\13!\3!\3!\3\"\3\"\3\"\3\"\3\"\7\"\u00d9"+
		"\n\"\f\"\16\"\u00dc\13\"\3\"\3\"\4\u00b2\u00c0\2#\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#\3\2\7\3\2\62"+
		";\7\2&&\62;C\\aac|\6\2&&C\\aac|\5\2\13\f\16\17\"\"\4\2\f\f\17\17\2\u00e7"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\3E\3\2\2\2\5L\3\2\2"+
		"\2\7S\3\2\2\2\tU\3\2\2\2\13W\3\2\2\2\rY\3\2\2\2\17[\3\2\2\2\21]\3\2\2"+
		"\2\23_\3\2\2\2\25a\3\2\2\2\27d\3\2\2\2\31g\3\2\2\2\33j\3\2\2\2\35n\3\2"+
		"\2\2\37q\3\2\2\2!u\3\2\2\2#w\3\2\2\2%y\3\2\2\2\'{\3\2\2\2)}\3\2\2\2+\177"+
		"\3\2\2\2-\u0081\3\2\2\2/\u0083\3\2\2\2\61\u0086\3\2\2\2\63\u0093\3\2\2"+
		"\2\65\u0095\3\2\2\2\67\u0099\3\2\2\29\u00a1\3\2\2\2;\u00a6\3\2\2\2=\u00ac"+
		"\3\2\2\2?\u00ba\3\2\2\2A\u00c8\3\2\2\2C\u00d3\3\2\2\2EF\7n\2\2FG\7c\2"+
		"\2GH\7o\2\2HI\7d\2\2IJ\7f\2\2JK\7c\2\2K\4\3\2\2\2LM\7f\2\2MN\7g\2\2NO"+
		"\7h\2\2OP\7k\2\2PQ\7p\2\2QR\7g\2\2R\6\3\2\2\2ST\7*\2\2T\b\3\2\2\2UV\7"+
		"+\2\2V\n\3\2\2\2WX\7@\2\2X\f\3\2\2\2YZ\7>\2\2Z\16\3\2\2\2[\\\7#\2\2\\"+
		"\20\3\2\2\2]^\7\u0080\2\2^\22\3\2\2\2_`\7?\2\2`\24\3\2\2\2ab\7>\2\2bc"+
		"\7?\2\2c\26\3\2\2\2de\7@\2\2ef\7?\2\2f\30\3\2\2\2gh\7#\2\2hi\7?\2\2i\32"+
		"\3\2\2\2jk\7c\2\2kl\7p\2\2lm\7f\2\2m\34\3\2\2\2no\7q\2\2op\7t\2\2p\36"+
		"\3\2\2\2qr\7z\2\2rs\7q\2\2st\7t\2\2t \3\2\2\2uv\7-\2\2v\"\3\2\2\2wx\7"+
		"/\2\2x$\3\2\2\2yz\7,\2\2z&\3\2\2\2{|\7\61\2\2|(\3\2\2\2}~\7\'\2\2~*\3"+
		"\2\2\2\177\u0080\7(\2\2\u0080,\3\2\2\2\u0081\u0082\7~\2\2\u0082.\3\2\2"+
		"\2\u0083\u0084\7`\2\2\u0084\60\3\2\2\2\u0085\u0087\t\2\2\2\u0086\u0085"+
		"\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\62\3\2\2\2\u008a\u008b\7v\2\2\u008b\u008c\7t\2\2\u008c\u008d\7w\2\2\u008d"+
		"\u0094\7g\2\2\u008e\u008f\7h\2\2\u008f\u0090\7c\2\2\u0090\u0091\7n\2\2"+
		"\u0091\u0092\7u\2\2\u0092\u0094\7g\2\2\u0093\u008a\3\2\2\2\u0093\u008e"+
		"\3\2\2\2\u0094\64\3\2\2\2\u0095\u0096\5\61\31\2\u0096\u0097\7\60\2\2\u0097"+
		"\u0098\5\61\31\2\u0098\66\3\2\2\2\u0099\u009d\59\35\2\u009a\u009c\t\3"+
		"\2\2\u009b\u009a\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d"+
		"\u009e\3\2\2\2\u009e8\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a2\t\4\2\2"+
		"\u00a1\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4"+
		"\3\2\2\2\u00a4:\3\2\2\2\u00a5\u00a7\t\5\2\2\u00a6\u00a5\3\2\2\2\u00a7"+
		"\u00a8\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\3\2"+
		"\2\2\u00aa\u00ab\b\36\2\2\u00ab<\3\2\2\2\u00ac\u00ad\7\61\2\2\u00ad\u00ae"+
		"\7,\2\2\u00ae\u00b2\3\2\2\2\u00af\u00b1\13\2\2\2\u00b0\u00af\3\2\2\2\u00b1"+
		"\u00b4\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00b5\3\2"+
		"\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b6\7,\2\2\u00b6\u00b7\7\61\2\2\u00b7"+
		"\u00b8\3\2\2\2\u00b8\u00b9\b\37\2\2\u00b9>\3\2\2\2\u00ba\u00bb\7%\2\2"+
		"\u00bb\u00bc\7~\2\2\u00bc\u00c0\3\2\2\2\u00bd\u00bf\13\2\2\2\u00be\u00bd"+
		"\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1"+
		"\u00c3\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00c4\7~\2\2\u00c4\u00c5\7%\2"+
		"\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\b \2\2\u00c7@\3\2\2\2\u00c8\u00c9\7"+
		"\61\2\2\u00c9\u00ca\7\61\2\2\u00ca\u00ce\3\2\2\2\u00cb\u00cd\n\6\2\2\u00cc"+
		"\u00cb\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2"+
		"\2\2\u00cf\u00d1\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d2\b!\2\2\u00d2"+
		"B\3\2\2\2\u00d3\u00d4\7=\2\2\u00d4\u00d5\7=\2\2\u00d5\u00d6\7=\2\2\u00d6"+
		"\u00da\3\2\2\2\u00d7\u00d9\n\6\2\2\u00d8\u00d7\3\2\2\2\u00d9\u00dc\3\2"+
		"\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dd\3\2\2\2\u00dc"+
		"\u00da\3\2\2\2\u00dd\u00de\b\"\2\2\u00deD\3\2\2\2\f\2\u0088\u0093\u009d"+
		"\u00a3\u00a8\u00b2\u00c0\u00ce\u00da\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}