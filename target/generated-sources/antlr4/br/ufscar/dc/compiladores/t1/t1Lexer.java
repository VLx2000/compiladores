// Generated from br/ufscar/dc/compiladores/t1/t1Lexer.g4 by ANTLR 4.7.2
package br.ufscar.dc.compiladores.t1;
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
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PALAVRA_CHAVE=1, NUMINT=2, NUMREAL=3, VARIAVEL=4, CADEIA=5, COMENTARIO=6, 
		WS=7, OP_REL=8, OP_ARIT=9, DELIM=10, ABREPAR=11, FECHAPAR=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PALAVRA_CHAVE", "NUMINT", "NUMREAL", "VARIAVEL", "CADEIA", "ESC_SEQ", 
			"COMENTARIO", "WS", "OP_REL", "OP_ARIT", "DELIM", "ABREPAR", "FECHAPAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "':'", "'('", 
			"')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PALAVRA_CHAVE", "NUMINT", "NUMREAL", "VARIAVEL", "CADEIA", "COMENTARIO", 
			"WS", "OP_REL", "OP_ARIT", "DELIM", "ABREPAR", "FECHAPAR"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\16\u00b8\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2h\n\2\3\3\5\3k\n"+
		"\3\3\3\6\3n\n\3\r\3\16\3o\3\4\5\4s\n\4\3\4\6\4v\n\4\r\4\16\4w\3\4\3\4"+
		"\6\4|\n\4\r\4\16\4}\5\4\u0080\n\4\3\5\3\5\7\5\u0084\n\5\f\5\16\5\u0087"+
		"\13\5\3\6\3\6\3\6\7\6\u008c\n\6\f\6\16\6\u008f\13\6\3\6\3\6\3\7\3\7\3"+
		"\7\3\b\3\b\7\b\u0098\n\b\f\b\16\b\u009b\13\b\3\b\5\b\u009e\n\b\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00af\n\n\3\13"+
		"\3\13\3\f\3\f\3\r\3\r\3\16\3\16\2\2\17\3\3\5\4\7\5\t\6\13\7\r\2\17\b\21"+
		"\t\23\n\25\13\27\f\31\r\33\16\3\2\t\4\2--//\4\2C\\c|\5\2\62;C\\c|\4\2"+
		"))^^\4\2\f\f\17\17\5\2\13\f\17\17\"\"\5\2,-//\61\61\2\u00d4\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\3g\3\2\2\2\5j\3\2\2\2\7r\3\2\2\2\t\u0081\3\2\2\2\13\u0088\3\2\2\2"+
		"\r\u0092\3\2\2\2\17\u0095\3\2\2\2\21\u00a2\3\2\2\2\23\u00ae\3\2\2\2\25"+
		"\u00b0\3\2\2\2\27\u00b2\3\2\2\2\31\u00b4\3\2\2\2\33\u00b6\3\2\2\2\35\36"+
		"\7F\2\2\36\37\7G\2\2\37 \7E\2\2 !\7N\2\2!\"\7C\2\2\"#\7T\2\2#$\7C\2\2"+
		"$%\7E\2\2%&\7Q\2\2&\'\7G\2\2\'h\7U\2\2()\7C\2\2)*\7N\2\2*+\7I\2\2+,\7"+
		"Q\2\2,-\7T\2\2-.\7K\2\2./\7V\2\2/\60\7O\2\2\60h\7Q\2\2\61\62\7K\2\2\62"+
		"\63\7P\2\2\63h\7V\2\2\64\65\7T\2\2\65\66\7G\2\2\66\67\7C\2\2\67h\7N\2"+
		"\289\7C\2\29:\7V\2\2:;\7T\2\2;<\7K\2\2<=\7D\2\2=>\7W\2\2>?\7K\2\2?h\7"+
		"T\2\2@h\7C\2\2AB\7N\2\2BC\7G\2\2Ch\7T\2\2DE\7K\2\2EF\7O\2\2FG\7R\2\2G"+
		"H\7T\2\2HI\7K\2\2IJ\7O\2\2JK\7K\2\2Kh\7T\2\2LM\7U\2\2Mh\7G\2\2NO\7G\2"+
		"\2OP\7P\2\2PQ\7V\2\2QR\7C\2\2Rh\7Q\2\2ST\7G\2\2TU\7P\2\2UV\7S\2\2VW\7"+
		"W\2\2WX\7C\2\2XY\7P\2\2YZ\7V\2\2Zh\7Q\2\2[\\\7K\2\2\\]\7P\2\2]^\7K\2\2"+
		"^_\7E\2\2_`\7K\2\2`h\7Q\2\2ab\7H\2\2bc\7K\2\2ch\7O\2\2dh\7G\2\2ef\7Q\2"+
		"\2fh\7W\2\2g\35\3\2\2\2g(\3\2\2\2g\61\3\2\2\2g\64\3\2\2\2g8\3\2\2\2g@"+
		"\3\2\2\2gA\3\2\2\2gD\3\2\2\2gL\3\2\2\2gN\3\2\2\2gS\3\2\2\2g[\3\2\2\2g"+
		"a\3\2\2\2gd\3\2\2\2ge\3\2\2\2h\4\3\2\2\2ik\t\2\2\2ji\3\2\2\2jk\3\2\2\2"+
		"km\3\2\2\2ln\4\62;\2ml\3\2\2\2no\3\2\2\2om\3\2\2\2op\3\2\2\2p\6\3\2\2"+
		"\2qs\t\2\2\2rq\3\2\2\2rs\3\2\2\2su\3\2\2\2tv\4\62;\2ut\3\2\2\2vw\3\2\2"+
		"\2wu\3\2\2\2wx\3\2\2\2x\177\3\2\2\2y{\7\60\2\2z|\4\62;\2{z\3\2\2\2|}\3"+
		"\2\2\2}{\3\2\2\2}~\3\2\2\2~\u0080\3\2\2\2\177y\3\2\2\2\177\u0080\3\2\2"+
		"\2\u0080\b\3\2\2\2\u0081\u0085\t\3\2\2\u0082\u0084\t\4\2\2\u0083\u0082"+
		"\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086"+
		"\n\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u008d\7)\2\2\u0089\u008c\5\r\7\2"+
		"\u008a\u008c\n\5\2\2\u008b\u0089\3\2\2\2\u008b\u008a\3\2\2\2\u008c\u008f"+
		"\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0090\3\2\2\2\u008f"+
		"\u008d\3\2\2\2\u0090\u0091\7)\2\2\u0091\f\3\2\2\2\u0092\u0093\7^\2\2\u0093"+
		"\u0094\7)\2\2\u0094\16\3\2\2\2\u0095\u0099\7\'\2\2\u0096\u0098\n\6\2\2"+
		"\u0097\u0096\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a"+
		"\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009e\7\17\2\2"+
		"\u009d\u009c\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0"+
		"\7\f\2\2\u00a0\u00a1\b\b\2\2\u00a1\20\3\2\2\2\u00a2\u00a3\t\7\2\2\u00a3"+
		"\u00a4\b\t\3\2\u00a4\22\3\2\2\2\u00a5\u00af\7@\2\2\u00a6\u00a7\7@\2\2"+
		"\u00a7\u00af\7?\2\2\u00a8\u00af\7>\2\2\u00a9\u00aa\7>\2\2\u00aa\u00af"+
		"\7?\2\2\u00ab\u00ac\7>\2\2\u00ac\u00af\7@\2\2\u00ad\u00af\7?\2\2\u00ae"+
		"\u00a5\3\2\2\2\u00ae\u00a6\3\2\2\2\u00ae\u00a8\3\2\2\2\u00ae\u00a9\3\2"+
		"\2\2\u00ae\u00ab\3\2\2\2\u00ae\u00ad\3\2\2\2\u00af\24\3\2\2\2\u00b0\u00b1"+
		"\t\b\2\2\u00b1\26\3\2\2\2\u00b2\u00b3\7<\2\2\u00b3\30\3\2\2\2\u00b4\u00b5"+
		"\7*\2\2\u00b5\32\3\2\2\2\u00b6\u00b7\7+\2\2\u00b7\34\3\2\2\2\20\2gjor"+
		"w}\177\u0085\u008b\u008d\u0099\u009d\u00ae\4\3\b\2\3\t\3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}