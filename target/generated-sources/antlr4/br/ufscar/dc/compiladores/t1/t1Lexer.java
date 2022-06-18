// Generated from br\u005Cufscar\dc\compiladores\t1\t1Lexer.g4 by ANTLR 4.7.2
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
		Algoritmo=1, Fim_algoritmo=2, Declare=3, Literal=4, Inteiro=5, Leia=6, 
		Escreva=7, Real=8, Logico=9, Nao=10, Fim_se=11, Fim_caso=12, Fim_para=13, 
		Fim_enquanto=14, Se=15, Entao=16, Senao=17, Caso=18, Seja=19, Para=20, 
		Ate=21, Faca=22, Enquanto=23, Registro=24, Fim_registro=25, Tipo=26, Var=27, 
		Procedimento=28, Fim_procedimento=29, Retorne=30, Funcao=31, Fim_funcao=32, 
		Constante=33, Falso=34, Verdadeiro=35, E=36, OU=37, NUM_INT=38, NUM_REAL=39, 
		IDENT=40, CADEIA=41, COMENTARIO=42, WS=43, DOTS=44, DOT=45, LEFT=46, RIGHT=47, 
		DIFERENTE=48, MENOR_IGUAL=49, MAIOR_IGUAL=50, MENOR=51, MAIOR=52, IGUAL=53, 
		PLUS=54, MINUS=55, ASTE=56, SLASH=57, COMMA=58, DELIM=59, ABREPAR=60, 
		FECHAPAR=61, ABRECOL=62, FECHACOL=63, CHAPEU=64, AND=65, RESTO=66;
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
			"Faca", "Enquanto", "Registro", "Fim_registro", "Tipo", "Var", "Procedimento", 
			"Fim_procedimento", "Retorne", "Funcao", "Fim_funcao", "Constante", "Falso", 
			"Verdadeiro", "E", "OU", "NUM_INT", "NUM_REAL", "IDENT", "CADEIA", "COMENTARIO", 
			"WS", "DOTS", "DOT", "LEFT", "RIGHT", "DIFERENTE", "MENOR_IGUAL", "MAIOR_IGUAL", 
			"MENOR", "MAIOR", "IGUAL", "PLUS", "MINUS", "ASTE", "SLASH", "COMMA", 
			"DELIM", "ABREPAR", "FECHAPAR", "ABRECOL", "FECHACOL", "CHAPEU", "AND", 
			"RESTO"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'algoritmo'", "'fim_algoritmo'", "'declare'", "'literal'", "'inteiro'", 
			"'leia'", "'escreva'", "'real'", "'logico'", "'nao'", "'fim_se'", "'fim_caso'", 
			"'fim_para'", "'fim_enquanto'", "'se'", "'entao'", "'senao'", "'caso'", 
			"'seja'", "'para'", "'ate'", "'faca'", "'enquanto'", "'registro'", "'fim_registro'", 
			"'tipo'", "'var'", "'procedimento'", "'fim_procedimento'", "'retorne'", 
			"'funcao'", "'fim_funcao'", "'constante'", "'falso'", "'verdadeiro'", 
			"'e'", "'ou'", null, null, null, null, null, null, "'..'", "'.'", "'<-'", 
			"'->'", "'<>'", "'<='", "'>='", "'<'", "'>'", "'='", "'+'", "'-'", "'*'", 
			"'/'", "','", "':'", "'('", "')'", "'['", "']'", "'^'", "'&'", "'%'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Algoritmo", "Fim_algoritmo", "Declare", "Literal", "Inteiro", 
			"Leia", "Escreva", "Real", "Logico", "Nao", "Fim_se", "Fim_caso", "Fim_para", 
			"Fim_enquanto", "Se", "Entao", "Senao", "Caso", "Seja", "Para", "Ate", 
			"Faca", "Enquanto", "Registro", "Fim_registro", "Tipo", "Var", "Procedimento", 
			"Fim_procedimento", "Retorne", "Funcao", "Fim_funcao", "Constante", "Falso", 
			"Verdadeiro", "E", "OU", "NUM_INT", "NUM_REAL", "IDENT", "CADEIA", "COMENTARIO", 
			"WS", "DOTS", "DOT", "LEFT", "RIGHT", "DIFERENTE", "MENOR_IGUAL", "MAIOR_IGUAL", 
			"MENOR", "MAIOR", "IGUAL", "PLUS", "MINUS", "ASTE", "SLASH", "COMMA", 
			"DELIM", "ABREPAR", "FECHAPAR", "ABRECOL", "FECHACOL", "CHAPEU", "AND", 
			"RESTO"
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
		case 41:
			COMENTARIO_action((RuleContext)_localctx, actionIndex);
			break;
		case 42:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2D\u0205\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3"+
		"\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3"+
		"\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3"+
		"\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3"+
		"\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3"+
		"\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3"+
		" \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3%\3"+
		"%\3&\3&\3&\3\'\6\'\u01a3\n\'\r\'\16\'\u01a4\3(\6(\u01a8\n(\r(\16(\u01a9"+
		"\3(\3(\6(\u01ae\n(\r(\16(\u01af\5(\u01b2\n(\3)\3)\7)\u01b6\n)\f)\16)\u01b9"+
		"\13)\3*\3*\7*\u01bd\n*\f*\16*\u01c0\13*\3*\3*\3+\3+\7+\u01c6\n+\f+\16"+
		"+\u01c9\13+\3+\3+\3+\3+\3,\3,\3,\3-\3-\3-\3.\3.\3/\3/\3/\3\60\3\60\3\60"+
		"\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\65\3\65\3\66"+
		"\3\66\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@"+
		"\3A\3A\3B\3B\3C\3C\4\u01be\u01c7\2D\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.["+
		"/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083"+
		"C\u0085D\3\2\5\4\2C\\c|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\2\u020b\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2"+
		"\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2"+
		"I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3"+
		"\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2"+
		"\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2"+
		"o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3"+
		"\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085"+
		"\3\2\2\2\3\u0087\3\2\2\2\5\u0091\3\2\2\2\7\u009f\3\2\2\2\t\u00a7\3\2\2"+
		"\2\13\u00af\3\2\2\2\r\u00b7\3\2\2\2\17\u00bc\3\2\2\2\21\u00c4\3\2\2\2"+
		"\23\u00c9\3\2\2\2\25\u00d0\3\2\2\2\27\u00d4\3\2\2\2\31\u00db\3\2\2\2\33"+
		"\u00e4\3\2\2\2\35\u00ed\3\2\2\2\37\u00fa\3\2\2\2!\u00fd\3\2\2\2#\u0103"+
		"\3\2\2\2%\u0109\3\2\2\2\'\u010e\3\2\2\2)\u0113\3\2\2\2+\u0118\3\2\2\2"+
		"-\u011c\3\2\2\2/\u0121\3\2\2\2\61\u012a\3\2\2\2\63\u0133\3\2\2\2\65\u0140"+
		"\3\2\2\2\67\u0145\3\2\2\29\u0149\3\2\2\2;\u0156\3\2\2\2=\u0167\3\2\2\2"+
		"?\u016f\3\2\2\2A\u0176\3\2\2\2C\u0181\3\2\2\2E\u018b\3\2\2\2G\u0191\3"+
		"\2\2\2I\u019c\3\2\2\2K\u019e\3\2\2\2M\u01a2\3\2\2\2O\u01a7\3\2\2\2Q\u01b3"+
		"\3\2\2\2S\u01ba\3\2\2\2U\u01c3\3\2\2\2W\u01ce\3\2\2\2Y\u01d1\3\2\2\2["+
		"\u01d4\3\2\2\2]\u01d6\3\2\2\2_\u01d9\3\2\2\2a\u01dc\3\2\2\2c\u01df\3\2"+
		"\2\2e\u01e2\3\2\2\2g\u01e5\3\2\2\2i\u01e7\3\2\2\2k\u01e9\3\2\2\2m\u01eb"+
		"\3\2\2\2o\u01ed\3\2\2\2q\u01ef\3\2\2\2s\u01f1\3\2\2\2u\u01f3\3\2\2\2w"+
		"\u01f5\3\2\2\2y\u01f7\3\2\2\2{\u01f9\3\2\2\2}\u01fb\3\2\2\2\177\u01fd"+
		"\3\2\2\2\u0081\u01ff\3\2\2\2\u0083\u0201\3\2\2\2\u0085\u0203\3\2\2\2\u0087"+
		"\u0088\7c\2\2\u0088\u0089\7n\2\2\u0089\u008a\7i\2\2\u008a\u008b\7q\2\2"+
		"\u008b\u008c\7t\2\2\u008c\u008d\7k\2\2\u008d\u008e\7v\2\2\u008e\u008f"+
		"\7o\2\2\u008f\u0090\7q\2\2\u0090\4\3\2\2\2\u0091\u0092\7h\2\2\u0092\u0093"+
		"\7k\2\2\u0093\u0094\7o\2\2\u0094\u0095\7a\2\2\u0095\u0096\7c\2\2\u0096"+
		"\u0097\7n\2\2\u0097\u0098\7i\2\2\u0098\u0099\7q\2\2\u0099\u009a\7t\2\2"+
		"\u009a\u009b\7k\2\2\u009b\u009c\7v\2\2\u009c\u009d\7o\2\2\u009d\u009e"+
		"\7q\2\2\u009e\6\3\2\2\2\u009f\u00a0\7f\2\2\u00a0\u00a1\7g\2\2\u00a1\u00a2"+
		"\7e\2\2\u00a2\u00a3\7n\2\2\u00a3\u00a4\7c\2\2\u00a4\u00a5\7t\2\2\u00a5"+
		"\u00a6\7g\2\2\u00a6\b\3\2\2\2\u00a7\u00a8\7n\2\2\u00a8\u00a9\7k\2\2\u00a9"+
		"\u00aa\7v\2\2\u00aa\u00ab\7g\2\2\u00ab\u00ac\7t\2\2\u00ac\u00ad\7c\2\2"+
		"\u00ad\u00ae\7n\2\2\u00ae\n\3\2\2\2\u00af\u00b0\7k\2\2\u00b0\u00b1\7p"+
		"\2\2\u00b1\u00b2\7v\2\2\u00b2\u00b3\7g\2\2\u00b3\u00b4\7k\2\2\u00b4\u00b5"+
		"\7t\2\2\u00b5\u00b6\7q\2\2\u00b6\f\3\2\2\2\u00b7\u00b8\7n\2\2\u00b8\u00b9"+
		"\7g\2\2\u00b9\u00ba\7k\2\2\u00ba\u00bb\7c\2\2\u00bb\16\3\2\2\2\u00bc\u00bd"+
		"\7g\2\2\u00bd\u00be\7u\2\2\u00be\u00bf\7e\2\2\u00bf\u00c0\7t\2\2\u00c0"+
		"\u00c1\7g\2\2\u00c1\u00c2\7x\2\2\u00c2\u00c3\7c\2\2\u00c3\20\3\2\2\2\u00c4"+
		"\u00c5\7t\2\2\u00c5\u00c6\7g\2\2\u00c6\u00c7\7c\2\2\u00c7\u00c8\7n\2\2"+
		"\u00c8\22\3\2\2\2\u00c9\u00ca\7n\2\2\u00ca\u00cb\7q\2\2\u00cb\u00cc\7"+
		"i\2\2\u00cc\u00cd\7k\2\2\u00cd\u00ce\7e\2\2\u00ce\u00cf\7q\2\2\u00cf\24"+
		"\3\2\2\2\u00d0\u00d1\7p\2\2\u00d1\u00d2\7c\2\2\u00d2\u00d3\7q\2\2\u00d3"+
		"\26\3\2\2\2\u00d4\u00d5\7h\2\2\u00d5\u00d6\7k\2\2\u00d6\u00d7\7o\2\2\u00d7"+
		"\u00d8\7a\2\2\u00d8\u00d9\7u\2\2\u00d9\u00da\7g\2\2\u00da\30\3\2\2\2\u00db"+
		"\u00dc\7h\2\2\u00dc\u00dd\7k\2\2\u00dd\u00de\7o\2\2\u00de\u00df\7a\2\2"+
		"\u00df\u00e0\7e\2\2\u00e0\u00e1\7c\2\2\u00e1\u00e2\7u\2\2\u00e2\u00e3"+
		"\7q\2\2\u00e3\32\3\2\2\2\u00e4\u00e5\7h\2\2\u00e5\u00e6\7k\2\2\u00e6\u00e7"+
		"\7o\2\2\u00e7\u00e8\7a\2\2\u00e8\u00e9\7r\2\2\u00e9\u00ea\7c\2\2\u00ea"+
		"\u00eb\7t\2\2\u00eb\u00ec\7c\2\2\u00ec\34\3\2\2\2\u00ed\u00ee\7h\2\2\u00ee"+
		"\u00ef\7k\2\2\u00ef\u00f0\7o\2\2\u00f0\u00f1\7a\2\2\u00f1\u00f2\7g\2\2"+
		"\u00f2\u00f3\7p\2\2\u00f3\u00f4\7s\2\2\u00f4\u00f5\7w\2\2\u00f5\u00f6"+
		"\7c\2\2\u00f6\u00f7\7p\2\2\u00f7\u00f8\7v\2\2\u00f8\u00f9\7q\2\2\u00f9"+
		"\36\3\2\2\2\u00fa\u00fb\7u\2\2\u00fb\u00fc\7g\2\2\u00fc \3\2\2\2\u00fd"+
		"\u00fe\7g\2\2\u00fe\u00ff\7p\2\2\u00ff\u0100\7v\2\2\u0100\u0101\7c\2\2"+
		"\u0101\u0102\7q\2\2\u0102\"\3\2\2\2\u0103\u0104\7u\2\2\u0104\u0105\7g"+
		"\2\2\u0105\u0106\7p\2\2\u0106\u0107\7c\2\2\u0107\u0108\7q\2\2\u0108$\3"+
		"\2\2\2\u0109\u010a\7e\2\2\u010a\u010b\7c\2\2\u010b\u010c\7u\2\2\u010c"+
		"\u010d\7q\2\2\u010d&\3\2\2\2\u010e\u010f\7u\2\2\u010f\u0110\7g\2\2\u0110"+
		"\u0111\7l\2\2\u0111\u0112\7c\2\2\u0112(\3\2\2\2\u0113\u0114\7r\2\2\u0114"+
		"\u0115\7c\2\2\u0115\u0116\7t\2\2\u0116\u0117\7c\2\2\u0117*\3\2\2\2\u0118"+
		"\u0119\7c\2\2\u0119\u011a\7v\2\2\u011a\u011b\7g\2\2\u011b,\3\2\2\2\u011c"+
		"\u011d\7h\2\2\u011d\u011e\7c\2\2\u011e\u011f\7e\2\2\u011f\u0120\7c\2\2"+
		"\u0120.\3\2\2\2\u0121\u0122\7g\2\2\u0122\u0123\7p\2\2\u0123\u0124\7s\2"+
		"\2\u0124\u0125\7w\2\2\u0125\u0126\7c\2\2\u0126\u0127\7p\2\2\u0127\u0128"+
		"\7v\2\2\u0128\u0129\7q\2\2\u0129\60\3\2\2\2\u012a\u012b\7t\2\2\u012b\u012c"+
		"\7g\2\2\u012c\u012d\7i\2\2\u012d\u012e\7k\2\2\u012e\u012f\7u\2\2\u012f"+
		"\u0130\7v\2\2\u0130\u0131\7t\2\2\u0131\u0132\7q\2\2\u0132\62\3\2\2\2\u0133"+
		"\u0134\7h\2\2\u0134\u0135\7k\2\2\u0135\u0136\7o\2\2\u0136\u0137\7a\2\2"+
		"\u0137\u0138\7t\2\2\u0138\u0139\7g\2\2\u0139\u013a\7i\2\2\u013a\u013b"+
		"\7k\2\2\u013b\u013c\7u\2\2\u013c\u013d\7v\2\2\u013d\u013e\7t\2\2\u013e"+
		"\u013f\7q\2\2\u013f\64\3\2\2\2\u0140\u0141\7v\2\2\u0141\u0142\7k\2\2\u0142"+
		"\u0143\7r\2\2\u0143\u0144\7q\2\2\u0144\66\3\2\2\2\u0145\u0146\7x\2\2\u0146"+
		"\u0147\7c\2\2\u0147\u0148\7t\2\2\u01488\3\2\2\2\u0149\u014a\7r\2\2\u014a"+
		"\u014b\7t\2\2\u014b\u014c\7q\2\2\u014c\u014d\7e\2\2\u014d\u014e\7g\2\2"+
		"\u014e\u014f\7f\2\2\u014f\u0150\7k\2\2\u0150\u0151\7o\2\2\u0151\u0152"+
		"\7g\2\2\u0152\u0153\7p\2\2\u0153\u0154\7v\2\2\u0154\u0155\7q\2\2\u0155"+
		":\3\2\2\2\u0156\u0157\7h\2\2\u0157\u0158\7k\2\2\u0158\u0159\7o\2\2\u0159"+
		"\u015a\7a\2\2\u015a\u015b\7r\2\2\u015b\u015c\7t\2\2\u015c\u015d\7q\2\2"+
		"\u015d\u015e\7e\2\2\u015e\u015f\7g\2\2\u015f\u0160\7f\2\2\u0160\u0161"+
		"\7k\2\2\u0161\u0162\7o\2\2\u0162\u0163\7g\2\2\u0163\u0164\7p\2\2\u0164"+
		"\u0165\7v\2\2\u0165\u0166\7q\2\2\u0166<\3\2\2\2\u0167\u0168\7t\2\2\u0168"+
		"\u0169\7g\2\2\u0169\u016a\7v\2\2\u016a\u016b\7q\2\2\u016b\u016c\7t\2\2"+
		"\u016c\u016d\7p\2\2\u016d\u016e\7g\2\2\u016e>\3\2\2\2\u016f\u0170\7h\2"+
		"\2\u0170\u0171\7w\2\2\u0171\u0172\7p\2\2\u0172\u0173\7e\2\2\u0173\u0174"+
		"\7c\2\2\u0174\u0175\7q\2\2\u0175@\3\2\2\2\u0176\u0177\7h\2\2\u0177\u0178"+
		"\7k\2\2\u0178\u0179\7o\2\2\u0179\u017a\7a\2\2\u017a\u017b\7h\2\2\u017b"+
		"\u017c\7w\2\2\u017c\u017d\7p\2\2\u017d\u017e\7e\2\2\u017e\u017f\7c\2\2"+
		"\u017f\u0180\7q\2\2\u0180B\3\2\2\2\u0181\u0182\7e\2\2\u0182\u0183\7q\2"+
		"\2\u0183\u0184\7p\2\2\u0184\u0185\7u\2\2\u0185\u0186\7v\2\2\u0186\u0187"+
		"\7c\2\2\u0187\u0188\7p\2\2\u0188\u0189\7v\2\2\u0189\u018a\7g\2\2\u018a"+
		"D\3\2\2\2\u018b\u018c\7h\2\2\u018c\u018d\7c\2\2\u018d\u018e\7n\2\2\u018e"+
		"\u018f\7u\2\2\u018f\u0190\7q\2\2\u0190F\3\2\2\2\u0191\u0192\7x\2\2\u0192"+
		"\u0193\7g\2\2\u0193\u0194\7t\2\2\u0194\u0195\7f\2\2\u0195\u0196\7c\2\2"+
		"\u0196\u0197\7f\2\2\u0197\u0198\7g\2\2\u0198\u0199\7k\2\2\u0199\u019a"+
		"\7t\2\2\u019a\u019b\7q\2\2\u019bH\3\2\2\2\u019c\u019d\7g\2\2\u019dJ\3"+
		"\2\2\2\u019e\u019f\7q\2\2\u019f\u01a0\7w\2\2\u01a0L\3\2\2\2\u01a1\u01a3"+
		"\4\62;\2\u01a2\u01a1\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a4"+
		"\u01a5\3\2\2\2\u01a5N\3\2\2\2\u01a6\u01a8\4\62;\2\u01a7\u01a6\3\2\2\2"+
		"\u01a8\u01a9\3\2\2\2\u01a9\u01a7\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01b1"+
		"\3\2\2\2\u01ab\u01ad\7\60\2\2\u01ac\u01ae\4\62;\2\u01ad\u01ac\3\2\2\2"+
		"\u01ae\u01af\3\2\2\2\u01af\u01ad\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b2"+
		"\3\2\2\2\u01b1\u01ab\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2P\3\2\2\2\u01b3"+
		"\u01b7\t\2\2\2\u01b4\u01b6\t\3\2\2\u01b5\u01b4\3\2\2\2\u01b6\u01b9\3\2"+
		"\2\2\u01b7\u01b5\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8R\3\2\2\2\u01b9\u01b7"+
		"\3\2\2\2\u01ba\u01be\7$\2\2\u01bb\u01bd\13\2\2\2\u01bc\u01bb\3\2\2\2\u01bd"+
		"\u01c0\3\2\2\2\u01be\u01bf\3\2\2\2\u01be\u01bc\3\2\2\2\u01bf\u01c1\3\2"+
		"\2\2\u01c0\u01be\3\2\2\2\u01c1\u01c2\7$\2\2\u01c2T\3\2\2\2\u01c3\u01c7"+
		"\7}\2\2\u01c4\u01c6\13\2\2\2\u01c5\u01c4\3\2\2\2\u01c6\u01c9\3\2\2\2\u01c7"+
		"\u01c8\3\2\2\2\u01c7\u01c5\3\2\2\2\u01c8\u01ca\3\2\2\2\u01c9\u01c7\3\2"+
		"\2\2\u01ca\u01cb\7\177\2\2\u01cb\u01cc\3\2\2\2\u01cc\u01cd\b+\2\2\u01cd"+
		"V\3\2\2\2\u01ce\u01cf\t\4\2\2\u01cf\u01d0\b,\3\2\u01d0X\3\2\2\2\u01d1"+
		"\u01d2\7\60\2\2\u01d2\u01d3\7\60\2\2\u01d3Z\3\2\2\2\u01d4\u01d5\7\60\2"+
		"\2\u01d5\\\3\2\2\2\u01d6\u01d7\7>\2\2\u01d7\u01d8\7/\2\2\u01d8^\3\2\2"+
		"\2\u01d9\u01da\7/\2\2\u01da\u01db\7@\2\2\u01db`\3\2\2\2\u01dc\u01dd\7"+
		">\2\2\u01dd\u01de\7@\2\2\u01deb\3\2\2\2\u01df\u01e0\7>\2\2\u01e0\u01e1"+
		"\7?\2\2\u01e1d\3\2\2\2\u01e2\u01e3\7@\2\2\u01e3\u01e4\7?\2\2\u01e4f\3"+
		"\2\2\2\u01e5\u01e6\7>\2\2\u01e6h\3\2\2\2\u01e7\u01e8\7@\2\2\u01e8j\3\2"+
		"\2\2\u01e9\u01ea\7?\2\2\u01eal\3\2\2\2\u01eb\u01ec\7-\2\2\u01ecn\3\2\2"+
		"\2\u01ed\u01ee\7/\2\2\u01eep\3\2\2\2\u01ef\u01f0\7,\2\2\u01f0r\3\2\2\2"+
		"\u01f1\u01f2\7\61\2\2\u01f2t\3\2\2\2\u01f3\u01f4\7.\2\2\u01f4v\3\2\2\2"+
		"\u01f5\u01f6\7<\2\2\u01f6x\3\2\2\2\u01f7\u01f8\7*\2\2\u01f8z\3\2\2\2\u01f9"+
		"\u01fa\7+\2\2\u01fa|\3\2\2\2\u01fb\u01fc\7]\2\2\u01fc~\3\2\2\2\u01fd\u01fe"+
		"\7_\2\2\u01fe\u0080\3\2\2\2\u01ff\u0200\7`\2\2\u0200\u0082\3\2\2\2\u0201"+
		"\u0202\7(\2\2\u0202\u0084\3\2\2\2\u0203\u0204\7\'\2\2\u0204\u0086\3\2"+
		"\2\2\n\2\u01a4\u01a9\u01af\u01b1\u01b7\u01be\u01c7\4\3+\2\3,\3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}