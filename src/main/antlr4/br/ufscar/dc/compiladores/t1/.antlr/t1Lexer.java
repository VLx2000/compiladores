// Generated from /home/victorl/Projetos/compiladores-t1/src/main/antlr4/br/ufscar/dc/compiladores/t1/t1Lexer.g4 by ANTLR 4.9.2
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
		Algoritmo=1, Fim_algoritmo=2, Declare=3, Literal=4, Inteiro=5, Leia=6, 
		Escreva=7, Real=8, Logico=9, Nao=10, Fim_se=11, Fim_caso=12, Fim_para=13, 
		Fim_enquanto=14, Se=15, Entao=16, Senao=17, Caso=18, Seja=19, Para=20, 
		Ate=21, Faca=22, Enquanto=23, E=24, OU=25, NUM_INT=26, NUM_REAL=27, IDENT=28, 
		CADEIA=29, COMENTARIO=30, WS=31, DOTS=32, LEFT=33, RIGHT=34, DIFERENTE=35, 
		MENOR_IGUAL=36, MAIOR_IGUAL=37, MENOR=38, MAIOR=39, IGUAL=40, PLUS=41, 
		MINUS=42, ASTE=43, SLASH=44, COMMA=45, DELIM=46, ABREPAR=47, FECHAPAR=48;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"Algoritmo", "Fim_algoritmo", "Declare", "Literal", "Inteiro", "Leia", 
			"Escreva", "Real", "Logico", "Nao", "Fim_se", "Fim_caso", "Fim_para", 
			"Fim_enquanto", "Se", "Entao", "Senao", "Caso", "Seja", "Para", "Ate", 
			"Faca", "Enquanto", "E", "OU", "NUM_INT", "NUM_REAL", "IDENT", "CADEIA", 
			"COMENTARIO", "WS", "DOTS", "LEFT", "RIGHT", "DIFERENTE", "MENOR_IGUAL", 
			"MAIOR_IGUAL", "MENOR", "MAIOR", "IGUAL", "PLUS", "MINUS", "ASTE", "SLASH", 
			"COMMA", "DELIM", "ABREPAR", "FECHAPAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'algoritmo'", "'fim_algoritmo'", "'declare'", "'literal'", "'inteiro'", 
			"'leia'", "'escreva'", "'real'", "'logico'", "'nao'", "'fim_se'", "'fim_caso'", 
			"'fim_para'", "'fim_enquanto'", "'se'", "'entao'", "'senao'", "'caso'", 
			"'seja'", "'para'", "'ate'", "'faca'", "'enquanto'", "'e'", "'ou'", null, 
			null, null, null, null, null, "'..'", "'<-'", "'->'", "'<>'", "'<='", 
			"'>='", "'<'", "'>'", "'='", "'+'", "'-'", "'*'", "'/'", "','", "':'", 
			"'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Algoritmo", "Fim_algoritmo", "Declare", "Literal", "Inteiro", 
			"Leia", "Escreva", "Real", "Logico", "Nao", "Fim_se", "Fim_caso", "Fim_para", 
			"Fim_enquanto", "Se", "Entao", "Senao", "Caso", "Seja", "Para", "Ate", 
			"Faca", "Enquanto", "E", "OU", "NUM_INT", "NUM_REAL", "IDENT", "CADEIA", 
			"COMENTARIO", "WS", "DOTS", "LEFT", "RIGHT", "DIFERENTE", "MENOR_IGUAL", 
			"MAIOR_IGUAL", "MENOR", "MAIOR", "IGUAL", "PLUS", "MINUS", "ASTE", "SLASH", 
			"COMMA", "DELIM", "ABREPAR", "FECHAPAR"
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
		case 29:
			COMENTARIO_action((RuleContext)_localctx, actionIndex);
			break;
		case 30:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\62\u0169\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3"+
		"\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3"+
		"\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\31\3\31\3\32\3\32\3\32\3\33\5\33\u010d\n\33\3\33\6\33\u0110\n\33"+
		"\r\33\16\33\u0111\3\34\5\34\u0115\n\34\3\34\6\34\u0118\n\34\r\34\16\34"+
		"\u0119\3\34\3\34\6\34\u011e\n\34\r\34\16\34\u011f\5\34\u0122\n\34\3\35"+
		"\3\35\7\35\u0126\n\35\f\35\16\35\u0129\13\35\3\36\3\36\7\36\u012d\n\36"+
		"\f\36\16\36\u0130\13\36\3\36\3\36\3\37\3\37\7\37\u0136\n\37\f\37\16\37"+
		"\u0139\13\37\3\37\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3"+
		"#\3$\3$\3$\3%\3%\3%\3&\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-"+
		"\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\4\u012e\u0137\2\62\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24"+
		"\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K"+
		"\'M(O)Q*S+U,W-Y.[/]\60_\61a\62\3\2\6\4\2--//\4\2C\\c|\5\2\62;C\\c|\5\2"+
		"\13\f\17\17\"\"\2\u0171\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2"+
		"Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3"+
		"\2\2\2\2_\3\2\2\2\2a\3\2\2\2\3c\3\2\2\2\5m\3\2\2\2\7{\3\2\2\2\t\u0083"+
		"\3\2\2\2\13\u008b\3\2\2\2\r\u0093\3\2\2\2\17\u0098\3\2\2\2\21\u00a0\3"+
		"\2\2\2\23\u00a5\3\2\2\2\25\u00ac\3\2\2\2\27\u00b0\3\2\2\2\31\u00b7\3\2"+
		"\2\2\33\u00c0\3\2\2\2\35\u00c9\3\2\2\2\37\u00d6\3\2\2\2!\u00d9\3\2\2\2"+
		"#\u00df\3\2\2\2%\u00e5\3\2\2\2\'\u00ea\3\2\2\2)\u00ef\3\2\2\2+\u00f4\3"+
		"\2\2\2-\u00f8\3\2\2\2/\u00fd\3\2\2\2\61\u0106\3\2\2\2\63\u0108\3\2\2\2"+
		"\65\u010c\3\2\2\2\67\u0114\3\2\2\29\u0123\3\2\2\2;\u012a\3\2\2\2=\u0133"+
		"\3\2\2\2?\u013e\3\2\2\2A\u0141\3\2\2\2C\u0144\3\2\2\2E\u0147\3\2\2\2G"+
		"\u014a\3\2\2\2I\u014d\3\2\2\2K\u0150\3\2\2\2M\u0153\3\2\2\2O\u0155\3\2"+
		"\2\2Q\u0157\3\2\2\2S\u0159\3\2\2\2U\u015b\3\2\2\2W\u015d\3\2\2\2Y\u015f"+
		"\3\2\2\2[\u0161\3\2\2\2]\u0163\3\2\2\2_\u0165\3\2\2\2a\u0167\3\2\2\2c"+
		"d\7c\2\2de\7n\2\2ef\7i\2\2fg\7q\2\2gh\7t\2\2hi\7k\2\2ij\7v\2\2jk\7o\2"+
		"\2kl\7q\2\2l\4\3\2\2\2mn\7h\2\2no\7k\2\2op\7o\2\2pq\7a\2\2qr\7c\2\2rs"+
		"\7n\2\2st\7i\2\2tu\7q\2\2uv\7t\2\2vw\7k\2\2wx\7v\2\2xy\7o\2\2yz\7q\2\2"+
		"z\6\3\2\2\2{|\7f\2\2|}\7g\2\2}~\7e\2\2~\177\7n\2\2\177\u0080\7c\2\2\u0080"+
		"\u0081\7t\2\2\u0081\u0082\7g\2\2\u0082\b\3\2\2\2\u0083\u0084\7n\2\2\u0084"+
		"\u0085\7k\2\2\u0085\u0086\7v\2\2\u0086\u0087\7g\2\2\u0087\u0088\7t\2\2"+
		"\u0088\u0089\7c\2\2\u0089\u008a\7n\2\2\u008a\n\3\2\2\2\u008b\u008c\7k"+
		"\2\2\u008c\u008d\7p\2\2\u008d\u008e\7v\2\2\u008e\u008f\7g\2\2\u008f\u0090"+
		"\7k\2\2\u0090\u0091\7t\2\2\u0091\u0092\7q\2\2\u0092\f\3\2\2\2\u0093\u0094"+
		"\7n\2\2\u0094\u0095\7g\2\2\u0095\u0096\7k\2\2\u0096\u0097\7c\2\2\u0097"+
		"\16\3\2\2\2\u0098\u0099\7g\2\2\u0099\u009a\7u\2\2\u009a\u009b\7e\2\2\u009b"+
		"\u009c\7t\2\2\u009c\u009d\7g\2\2\u009d\u009e\7x\2\2\u009e\u009f\7c\2\2"+
		"\u009f\20\3\2\2\2\u00a0\u00a1\7t\2\2\u00a1\u00a2\7g\2\2\u00a2\u00a3\7"+
		"c\2\2\u00a3\u00a4\7n\2\2\u00a4\22\3\2\2\2\u00a5\u00a6\7n\2\2\u00a6\u00a7"+
		"\7q\2\2\u00a7\u00a8\7i\2\2\u00a8\u00a9\7k\2\2\u00a9\u00aa\7e\2\2\u00aa"+
		"\u00ab\7q\2\2\u00ab\24\3\2\2\2\u00ac\u00ad\7p\2\2\u00ad\u00ae\7c\2\2\u00ae"+
		"\u00af\7q\2\2\u00af\26\3\2\2\2\u00b0\u00b1\7h\2\2\u00b1\u00b2\7k\2\2\u00b2"+
		"\u00b3\7o\2\2\u00b3\u00b4\7a\2\2\u00b4\u00b5\7u\2\2\u00b5\u00b6\7g\2\2"+
		"\u00b6\30\3\2\2\2\u00b7\u00b8\7h\2\2\u00b8\u00b9\7k\2\2\u00b9\u00ba\7"+
		"o\2\2\u00ba\u00bb\7a\2\2\u00bb\u00bc\7e\2\2\u00bc\u00bd\7c\2\2\u00bd\u00be"+
		"\7u\2\2\u00be\u00bf\7q\2\2\u00bf\32\3\2\2\2\u00c0\u00c1\7h\2\2\u00c1\u00c2"+
		"\7k\2\2\u00c2\u00c3\7o\2\2\u00c3\u00c4\7a\2\2\u00c4\u00c5\7r\2\2\u00c5"+
		"\u00c6\7c\2\2\u00c6\u00c7\7t\2\2\u00c7\u00c8\7c\2\2\u00c8\34\3\2\2\2\u00c9"+
		"\u00ca\7h\2\2\u00ca\u00cb\7k\2\2\u00cb\u00cc\7o\2\2\u00cc\u00cd\7a\2\2"+
		"\u00cd\u00ce\7g\2\2\u00ce\u00cf\7p\2\2\u00cf\u00d0\7s\2\2\u00d0\u00d1"+
		"\7w\2\2\u00d1\u00d2\7c\2\2\u00d2\u00d3\7p\2\2\u00d3\u00d4\7v\2\2\u00d4"+
		"\u00d5\7q\2\2\u00d5\36\3\2\2\2\u00d6\u00d7\7u\2\2\u00d7\u00d8\7g\2\2\u00d8"+
		" \3\2\2\2\u00d9\u00da\7g\2\2\u00da\u00db\7p\2\2\u00db\u00dc\7v\2\2\u00dc"+
		"\u00dd\7c\2\2\u00dd\u00de\7q\2\2\u00de\"\3\2\2\2\u00df\u00e0\7u\2\2\u00e0"+
		"\u00e1\7g\2\2\u00e1\u00e2\7p\2\2\u00e2\u00e3\7c\2\2\u00e3\u00e4\7q\2\2"+
		"\u00e4$\3\2\2\2\u00e5\u00e6\7e\2\2\u00e6\u00e7\7c\2\2\u00e7\u00e8\7u\2"+
		"\2\u00e8\u00e9\7q\2\2\u00e9&\3\2\2\2\u00ea\u00eb\7u\2\2\u00eb\u00ec\7"+
		"g\2\2\u00ec\u00ed\7l\2\2\u00ed\u00ee\7c\2\2\u00ee(\3\2\2\2\u00ef\u00f0"+
		"\7r\2\2\u00f0\u00f1\7c\2\2\u00f1\u00f2\7t\2\2\u00f2\u00f3\7c\2\2\u00f3"+
		"*\3\2\2\2\u00f4\u00f5\7c\2\2\u00f5\u00f6\7v\2\2\u00f6\u00f7\7g\2\2\u00f7"+
		",\3\2\2\2\u00f8\u00f9\7h\2\2\u00f9\u00fa\7c\2\2\u00fa\u00fb\7e\2\2\u00fb"+
		"\u00fc\7c\2\2\u00fc.\3\2\2\2\u00fd\u00fe\7g\2\2\u00fe\u00ff\7p\2\2\u00ff"+
		"\u0100\7s\2\2\u0100\u0101\7w\2\2\u0101\u0102\7c\2\2\u0102\u0103\7p\2\2"+
		"\u0103\u0104\7v\2\2\u0104\u0105\7q\2\2\u0105\60\3\2\2\2\u0106\u0107\7"+
		"g\2\2\u0107\62\3\2\2\2\u0108\u0109\7q\2\2\u0109\u010a\7w\2\2\u010a\64"+
		"\3\2\2\2\u010b\u010d\t\2\2\2\u010c\u010b\3\2\2\2\u010c\u010d\3\2\2\2\u010d"+
		"\u010f\3\2\2\2\u010e\u0110\4\62;\2\u010f\u010e\3\2\2\2\u0110\u0111\3\2"+
		"\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\66\3\2\2\2\u0113\u0115"+
		"\t\2\2\2\u0114\u0113\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0117\3\2\2\2\u0116"+
		"\u0118\4\62;\2\u0117\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u0117\3\2"+
		"\2\2\u0119\u011a\3\2\2\2\u011a\u0121\3\2\2\2\u011b\u011d\7\60\2\2\u011c"+
		"\u011e\4\62;\2\u011d\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u011d\3\2"+
		"\2\2\u011f\u0120\3\2\2\2\u0120\u0122\3\2\2\2\u0121\u011b\3\2\2\2\u0121"+
		"\u0122\3\2\2\2\u01228\3\2\2\2\u0123\u0127\t\3\2\2\u0124\u0126\t\4\2\2"+
		"\u0125\u0124\3\2\2\2\u0126\u0129\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128"+
		"\3\2\2\2\u0128:\3\2\2\2\u0129\u0127\3\2\2\2\u012a\u012e\7$\2\2\u012b\u012d"+
		"\13\2\2\2\u012c\u012b\3\2\2\2\u012d\u0130\3\2\2\2\u012e\u012f\3\2\2\2"+
		"\u012e\u012c\3\2\2\2\u012f\u0131\3\2\2\2\u0130\u012e\3\2\2\2\u0131\u0132"+
		"\7$\2\2\u0132<\3\2\2\2\u0133\u0137\7}\2\2\u0134\u0136\13\2\2\2\u0135\u0134"+
		"\3\2\2\2\u0136\u0139\3\2\2\2\u0137\u0138\3\2\2\2\u0137\u0135\3\2\2\2\u0138"+
		"\u013a\3\2\2\2\u0139\u0137\3\2\2\2\u013a\u013b\7\177\2\2\u013b\u013c\3"+
		"\2\2\2\u013c\u013d\b\37\2\2\u013d>\3\2\2\2\u013e\u013f\t\5\2\2\u013f\u0140"+
		"\b \3\2\u0140@\3\2\2\2\u0141\u0142\7\60\2\2\u0142\u0143\7\60\2\2\u0143"+
		"B\3\2\2\2\u0144\u0145\7>\2\2\u0145\u0146\7/\2\2\u0146D\3\2\2\2\u0147\u0148"+
		"\7/\2\2\u0148\u0149\7@\2\2\u0149F\3\2\2\2\u014a\u014b\7>\2\2\u014b\u014c"+
		"\7@\2\2\u014cH\3\2\2\2\u014d\u014e\7>\2\2\u014e\u014f\7?\2\2\u014fJ\3"+
		"\2\2\2\u0150\u0151\7@\2\2\u0151\u0152\7?\2\2\u0152L\3\2\2\2\u0153\u0154"+
		"\7>\2\2\u0154N\3\2\2\2\u0155\u0156\7@\2\2\u0156P\3\2\2\2\u0157\u0158\7"+
		"?\2\2\u0158R\3\2\2\2\u0159\u015a\7-\2\2\u015aT\3\2\2\2\u015b\u015c\7/"+
		"\2\2\u015cV\3\2\2\2\u015d\u015e\7,\2\2\u015eX\3\2\2\2\u015f\u0160\7\61"+
		"\2\2\u0160Z\3\2\2\2\u0161\u0162\7.\2\2\u0162\\\3\2\2\2\u0163\u0164\7<"+
		"\2\2\u0164^\3\2\2\2\u0165\u0166\7*\2\2\u0166`\3\2\2\2\u0167\u0168\7+\2"+
		"\2\u0168b\3\2\2\2\f\2\u010c\u0111\u0114\u0119\u011f\u0121\u0127\u012e"+
		"\u0137\4\3\37\2\3 \3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}