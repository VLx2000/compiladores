// Generated from d:\Windows\Documentos\Compiladores\compiladores-t1\src\main\antlr4\br\u005Cufscar\dc\compiladores\t1\t1Lexer.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class t1Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PALAVRA_CHAVE=1, NUM_INT=2, NUM_REAL=3, IDENT=4, CADEIA=5, COMENTARIO=6, 
		WS=7, OP_RELACIONAIS=8, OP_ARITMETICOS=9, ABREPAR=10, FECHAPAR=11, ABRECOL=12, 
		FECHACOL=13, DOT=14, DOTS=15, COMMA=16, DELIM=17, ENDERECO=18, COMENTARIO_N_FECHADO=19, 
		CADEIA_N_FECHADA=20, SIMBOLO_DESCONHECIDO=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PALAVRA_CHAVE", "NUM_INT", "NUM_REAL", "IDENT", "CADEIA", "ESC_SEQ", 
			"COMENTARIO", "WS", "OP_RELACIONAIS", "OP_ARITMETICOS", "ABREPAR", "FECHAPAR", 
			"ABRECOL", "FECHACOL", "DOT", "DOTS", "COMMA", "DELIM", "ENDERECO", "COMENTARIO_N_FECHADO", 
			"CADEIA_N_FECHADA", "SIMBOLO_DESCONHECIDO"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "'('", "')'", 
			"'['", "']'", "'.'", "'..'", "','", "':'", "'&'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PALAVRA_CHAVE", "NUM_INT", "NUM_REAL", "IDENT", "CADEIA", "COMENTARIO", 
			"WS", "OP_RELACIONAIS", "OP_ARITMETICOS", "ABREPAR", "FECHAPAR", "ABRECOL", 
			"FECHACOL", "DOT", "DOTS", "COMMA", "DELIM", "ENDERECO", "COMENTARIO_N_FECHADO", 
			"CADEIA_N_FECHADA", "SIMBOLO_DESCONHECIDO"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public t1Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "t1Lexer.g4"; }

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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 6:
			COMENTARIO_action((RuleContext)_localctx, actionIndex);
			break;
		case 7:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void COMENTARIO_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			skip();
			break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			skip();
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\u018f\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\5\2\u0129\n\2\3\3\6\3\u012c\n\3\r\3\16\3\u012d\3\4\6\4\u0131\n\4\r"+
		"\4\16\4\u0132\3\4\3\4\6\4\u0137\n\4\r\4\16\4\u0138\5\4\u013b\n\4\3\5\3"+
		"\5\7\5\u013f\n\5\f\5\16\5\u0142\13\5\3\6\3\6\3\6\7\6\u0147\n\6\f\6\16"+
		"\6\u014a\13\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\7\b\u0153\n\b\f\b\16\b\u0156"+
		"\13\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0165\n"+
		"\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3"+
		"\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\7\25\u017e\n\25\f\25\16\25"+
		"\u0181\13\25\3\25\3\25\3\26\3\26\7\26\u0187\n\26\f\26\16\26\u018a\13\26"+
		"\3\26\3\26\3\27\3\27\4\u017f\u0188\2\30\3\3\5\4\7\5\t\6\13\7\r\2\17\b"+
		"\21\t\23\n\25\13\27\f\31\r\33\16\35\17\37\20!\21#\22%\23\'\24)\25+\26"+
		"-\27\3\2\n\4\2C\\c|\6\2\62;C\\aac|\5\2\f\f$$^^\5\2\f\f\17\17\177\177\5"+
		"\2\13\f\17\17\"\"\7\2\'\',-//\61\61``\3\2\177\177\3\2$$\2\u01c0\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\3\u0128\3\2\2\2\5\u012b\3\2"+
		"\2\2\7\u0130\3\2\2\2\t\u013c\3\2\2\2\13\u0143\3\2\2\2\r\u014d\3\2\2\2"+
		"\17\u0150\3\2\2\2\21\u015a\3\2\2\2\23\u0164\3\2\2\2\25\u0166\3\2\2\2\27"+
		"\u0168\3\2\2\2\31\u016a\3\2\2\2\33\u016c\3\2\2\2\35\u016e\3\2\2\2\37\u0170"+
		"\3\2\2\2!\u0172\3\2\2\2#\u0175\3\2\2\2%\u0177\3\2\2\2\'\u0179\3\2\2\2"+
		")\u017b\3\2\2\2+\u0184\3\2\2\2-\u018d\3\2\2\2/\60\7c\2\2\60\61\7n\2\2"+
		"\61\62\7i\2\2\62\63\7q\2\2\63\64\7t\2\2\64\65\7k\2\2\65\66\7v\2\2\66\67"+
		"\7o\2\2\67\u0129\7q\2\289\7h\2\29:\7k\2\2:;\7o\2\2;<\7a\2\2<=\7c\2\2="+
		">\7n\2\2>?\7i\2\2?@\7q\2\2@A\7t\2\2AB\7k\2\2BC\7v\2\2CD\7o\2\2D\u0129"+
		"\7q\2\2EF\7f\2\2FG\7g\2\2GH\7e\2\2HI\7n\2\2IJ\7c\2\2JK\7t\2\2K\u0129\7"+
		"g\2\2LM\7x\2\2MN\7c\2\2N\u0129\7t\2\2OP\7v\2\2PQ\7k\2\2QR\7r\2\2R\u0129"+
		"\7q\2\2ST\7n\2\2TU\7k\2\2UV\7v\2\2VW\7g\2\2WX\7t\2\2XY\7c\2\2Y\u0129\7"+
		"n\2\2Z[\7k\2\2[\\\7p\2\2\\]\7v\2\2]^\7g\2\2^_\7k\2\2_`\7t\2\2`\u0129\7"+
		"q\2\2ab\7t\2\2bc\7g\2\2cd\7c\2\2d\u0129\7n\2\2ef\7n\2\2fg\7q\2\2gh\7i"+
		"\2\2hi\7k\2\2ij\7e\2\2j\u0129\7q\2\2k\u0129\7g\2\2lm\7q\2\2m\u0129\7w"+
		"\2\2no\7x\2\2op\7g\2\2pq\7t\2\2qr\7f\2\2rs\7c\2\2st\7f\2\2tu\7g\2\2uv"+
		"\7k\2\2vw\7t\2\2w\u0129\7q\2\2xy\7h\2\2yz\7c\2\2z{\7n\2\2{|\7u\2\2|\u0129"+
		"\7q\2\2}~\7e\2\2~\177\7q\2\2\177\u0080\7p\2\2\u0080\u0081\7u\2\2\u0081"+
		"\u0082\7v\2\2\u0082\u0083\7c\2\2\u0083\u0084\7p\2\2\u0084\u0085\7v\2\2"+
		"\u0085\u0129\7g\2\2\u0086\u0087\7n\2\2\u0087\u0088\7g\2\2\u0088\u0089"+
		"\7k\2\2\u0089\u0129\7c\2\2\u008a\u008b\7g\2\2\u008b\u008c\7u\2\2\u008c"+
		"\u008d\7e\2\2\u008d\u008e\7t\2\2\u008e\u008f\7g\2\2\u008f\u0090\7x\2\2"+
		"\u0090\u0129\7c\2\2\u0091\u0092\7p\2\2\u0092\u0093\7c\2\2\u0093\u0129"+
		"\7q\2\2\u0094\u0095\7u\2\2\u0095\u0129\7g\2\2\u0096\u0097\7g\2\2\u0097"+
		"\u0098\7p\2\2\u0098\u0099\7v\2\2\u0099\u009a\7c\2\2\u009a\u0129\7q\2\2"+
		"\u009b\u009c\7u\2\2\u009c\u009d\7g\2\2\u009d\u009e\7p\2\2\u009e\u009f"+
		"\7c\2\2\u009f\u0129\7q\2\2\u00a0\u00a1\7h\2\2\u00a1\u00a2\7k\2\2\u00a2"+
		"\u00a3\7o\2\2\u00a3\u00a4\7a\2\2\u00a4\u00a5\7u\2\2\u00a5\u0129\7g\2\2"+
		"\u00a6\u00a7\7e\2\2\u00a7\u00a8\7c\2\2\u00a8\u00a9\7u\2\2\u00a9\u0129"+
		"\7q\2\2\u00aa\u00ab\7h\2\2\u00ab\u00ac\7k\2\2\u00ac\u00ad\7o\2\2\u00ad"+
		"\u00ae\7a\2\2\u00ae\u00af\7e\2\2\u00af\u00b0\7c\2\2\u00b0\u00b1\7u\2\2"+
		"\u00b1\u0129\7q\2\2\u00b2\u00b3\7r\2\2\u00b3\u00b4\7c\2\2\u00b4\u00b5"+
		"\7t\2\2\u00b5\u0129\7c\2\2\u00b6\u00b7\7h\2\2\u00b7\u00b8\7k\2\2\u00b8"+
		"\u00b9\7o\2\2\u00b9\u00ba\7a\2\2\u00ba\u00bb\7r\2\2\u00bb\u00bc\7c\2\2"+
		"\u00bc\u00bd\7t\2\2\u00bd\u0129\7c\2\2\u00be\u00bf\7g\2\2\u00bf\u00c0"+
		"\7p\2\2\u00c0\u00c1\7s\2\2\u00c1\u00c2\7w\2\2\u00c2\u00c3\7c\2\2\u00c3"+
		"\u00c4\7p\2\2\u00c4\u00c5\7v\2\2\u00c5\u0129\7q\2\2\u00c6\u00c7\7h\2\2"+
		"\u00c7\u00c8\7k\2\2\u00c8\u00c9\7o\2\2\u00c9\u00ca\7a\2\2\u00ca\u00cb"+
		"\7g\2\2\u00cb\u00cc\7p\2\2\u00cc\u00cd\7s\2\2\u00cd\u00ce\7w\2\2\u00ce"+
		"\u00cf\7c\2\2\u00cf\u00d0\7p\2\2\u00d0\u00d1\7v\2\2\u00d1\u0129\7q\2\2"+
		"\u00d2\u00d3\7h\2\2\u00d3\u00d4\7c\2\2\u00d4\u00d5\7e\2\2\u00d5\u0129"+
		"\7c\2\2\u00d6\u00d7\7u\2\2\u00d7\u00d8\7g\2\2\u00d8\u00d9\7l\2\2\u00d9"+
		"\u0129\7c\2\2\u00da\u00db\7c\2\2\u00db\u00dc\7v\2\2\u00dc\u0129\7g\2\2"+
		"\u00dd\u00de\7t\2\2\u00de\u00df\7g\2\2\u00df\u00e0\7i\2\2\u00e0\u00e1"+
		"\7k\2\2\u00e1\u00e2\7u\2\2\u00e2\u00e3\7v\2\2\u00e3\u00e4\7t\2\2\u00e4"+
		"\u0129\7q\2\2\u00e5\u00e6\7h\2\2\u00e6\u00e7\7k\2\2\u00e7\u00e8\7o\2\2"+
		"\u00e8\u00e9\7a\2\2\u00e9\u00ea\7t\2\2\u00ea\u00eb\7g\2\2\u00eb\u00ec"+
		"\7i\2\2\u00ec\u00ed\7k\2\2\u00ed\u00ee\7u\2\2\u00ee\u00ef\7v\2\2\u00ef"+
		"\u00f0\7t\2\2\u00f0\u0129\7q\2\2\u00f1\u00f2\7r\2\2\u00f2\u00f3\7t\2\2"+
		"\u00f3\u00f4\7q\2\2\u00f4\u00f5\7e\2\2\u00f5\u00f6\7g\2\2\u00f6\u00f7"+
		"\7f\2\2\u00f7\u00f8\7k\2\2\u00f8\u00f9\7o\2\2\u00f9\u00fa\7g\2\2\u00fa"+
		"\u00fb\7p\2\2\u00fb\u00fc\7v\2\2\u00fc\u0129\7q\2\2\u00fd\u00fe\7h\2\2"+
		"\u00fe\u00ff\7k\2\2\u00ff\u0100\7o\2\2\u0100\u0101\7a\2\2\u0101\u0102"+
		"\7r\2\2\u0102\u0103\7t\2\2\u0103\u0104\7q\2\2\u0104\u0105\7e\2\2\u0105"+
		"\u0106\7g\2\2\u0106\u0107\7f\2\2\u0107\u0108\7k\2\2\u0108\u0109\7o\2\2"+
		"\u0109\u010a\7g\2\2\u010a\u010b\7p\2\2\u010b\u010c\7v\2\2\u010c\u0129"+
		"\7q\2\2\u010d\u010e\7t\2\2\u010e\u010f\7g\2\2\u010f\u0110\7v\2\2\u0110"+
		"\u0111\7q\2\2\u0111\u0112\7t\2\2\u0112\u0113\7p\2\2\u0113\u0129\7g\2\2"+
		"\u0114\u0115\7h\2\2\u0115\u0116\7w\2\2\u0116\u0117\7p\2\2\u0117\u0118"+
		"\7e\2\2\u0118\u0119\7c\2\2\u0119\u0129\7q\2\2\u011a\u011b\7h\2\2\u011b"+
		"\u011c\7k\2\2\u011c\u011d\7o\2\2\u011d\u011e\7a\2\2\u011e\u011f\7h\2\2"+
		"\u011f\u0120\7w\2\2\u0120\u0121\7p\2\2\u0121\u0122\7e\2\2\u0122\u0123"+
		"\7c\2\2\u0123\u0129\7q\2\2\u0124\u0125\7>\2\2\u0125\u0129\7/\2\2\u0126"+
		"\u0127\7/\2\2\u0127\u0129\7@\2\2\u0128/\3\2\2\2\u01288\3\2\2\2\u0128E"+
		"\3\2\2\2\u0128L\3\2\2\2\u0128O\3\2\2\2\u0128S\3\2\2\2\u0128Z\3\2\2\2\u0128"+
		"a\3\2\2\2\u0128e\3\2\2\2\u0128k\3\2\2\2\u0128l\3\2\2\2\u0128n\3\2\2\2"+
		"\u0128x\3\2\2\2\u0128}\3\2\2\2\u0128\u0086\3\2\2\2\u0128\u008a\3\2\2\2"+
		"\u0128\u0091\3\2\2\2\u0128\u0094\3\2\2\2\u0128\u0096\3\2\2\2\u0128\u009b"+
		"\3\2\2\2\u0128\u00a0\3\2\2\2\u0128\u00a6\3\2\2\2\u0128\u00aa\3\2\2\2\u0128"+
		"\u00b2\3\2\2\2\u0128\u00b6\3\2\2\2\u0128\u00be\3\2\2\2\u0128\u00c6\3\2"+
		"\2\2\u0128\u00d2\3\2\2\2\u0128\u00d6\3\2\2\2\u0128\u00da\3\2\2\2\u0128"+
		"\u00dd\3\2\2\2\u0128\u00e5\3\2\2\2\u0128\u00f1\3\2\2\2\u0128\u00fd\3\2"+
		"\2\2\u0128\u010d\3\2\2\2\u0128\u0114\3\2\2\2\u0128\u011a\3\2\2\2\u0128"+
		"\u0124\3\2\2\2\u0128\u0126\3\2\2\2\u0129\4\3\2\2\2\u012a\u012c\4\62;\2"+
		"\u012b\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012e"+
		"\3\2\2\2\u012e\6\3\2\2\2\u012f\u0131\4\62;\2\u0130\u012f\3\2\2\2\u0131"+
		"\u0132\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u013a\3\2"+
		"\2\2\u0134\u0136\7\60\2\2\u0135\u0137\4\62;\2\u0136\u0135\3\2\2\2\u0137"+
		"\u0138\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u013b\3\2"+
		"\2\2\u013a\u0134\3\2\2\2\u013a\u013b\3\2\2\2\u013b\b\3\2\2\2\u013c\u0140"+
		"\t\2\2\2\u013d\u013f\t\3\2\2\u013e\u013d\3\2\2\2\u013f\u0142\3\2\2\2\u0140"+
		"\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141\n\3\2\2\2\u0142\u0140\3\2\2\2"+
		"\u0143\u0148\7$\2\2\u0144\u0147\5\r\7\2\u0145\u0147\n\4\2\2\u0146\u0144"+
		"\3\2\2\2\u0146\u0145\3\2\2\2\u0147\u014a\3\2\2\2\u0148\u0146\3\2\2\2\u0148"+
		"\u0149\3\2\2\2\u0149\u014b\3\2\2\2\u014a\u0148\3\2\2\2\u014b\u014c\7$"+
		"\2\2\u014c\f\3\2\2\2\u014d\u014e\7^\2\2\u014e\u014f\7)\2\2\u014f\16\3"+
		"\2\2\2\u0150\u0154\7}\2\2\u0151\u0153\n\5\2\2\u0152\u0151\3\2\2\2\u0153"+
		"\u0156\3\2\2\2\u0154\u0152\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0157\3\2"+
		"\2\2\u0156\u0154\3\2\2\2\u0157\u0158\7\177\2\2\u0158\u0159\b\b\2\2\u0159"+
		"\20\3\2\2\2\u015a\u015b\t\6\2\2\u015b\u015c\b\t\3\2\u015c\22\3\2\2\2\u015d"+
		"\u015e\7>\2\2\u015e\u0165\7@\2\2\u015f\u0160\7>\2\2\u0160\u0165\7?\2\2"+
		"\u0161\u0162\7@\2\2\u0162\u0165\7?\2\2\u0163\u0165\4>@\2\u0164\u015d\3"+
		"\2\2\2\u0164\u015f\3\2\2\2\u0164\u0161\3\2\2\2\u0164\u0163\3\2\2\2\u0165"+
		"\24\3\2\2\2\u0166\u0167\t\7\2\2\u0167\26\3\2\2\2\u0168\u0169\7*\2\2\u0169"+
		"\30\3\2\2\2\u016a\u016b\7+\2\2\u016b\32\3\2\2\2\u016c\u016d\7]\2\2\u016d"+
		"\34\3\2\2\2\u016e\u016f\7_\2\2\u016f\36\3\2\2\2\u0170\u0171\7\60\2\2\u0171"+
		" \3\2\2\2\u0172\u0173\7\60\2\2\u0173\u0174\7\60\2\2\u0174\"\3\2\2\2\u0175"+
		"\u0176\7.\2\2\u0176$\3\2\2\2\u0177\u0178\7<\2\2\u0178&\3\2\2\2\u0179\u017a"+
		"\7(\2\2\u017a(\3\2\2\2\u017b\u017f\7}\2\2\u017c\u017e\13\2\2\2\u017d\u017c"+
		"\3\2\2\2\u017e\u0181\3\2\2\2\u017f\u0180\3\2\2\2\u017f\u017d\3\2\2\2\u0180"+
		"\u0182\3\2\2\2\u0181\u017f\3\2\2\2\u0182\u0183\n\b\2\2\u0183*\3\2\2\2"+
		"\u0184\u0188\7$\2\2\u0185\u0187\13\2\2\2\u0186\u0185\3\2\2\2\u0187\u018a"+
		"\3\2\2\2\u0188\u0189\3\2\2\2\u0188\u0186\3\2\2\2\u0189\u018b\3\2\2\2\u018a"+
		"\u0188\3\2\2\2\u018b\u018c\n\t\2\2\u018c,\3\2\2\2\u018d\u018e\13\2\2\2"+
		"\u018e.\3\2\2\2\17\2\u0128\u012d\u0132\u0138\u013a\u0140\u0146\u0148\u0154"+
		"\u0164\u017f\u0188\4\3\b\2\3\t\3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}