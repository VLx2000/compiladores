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
		FECHAPAR=61, ABRECOL=62, FECHACOL=63, CHAPEU=64, AND=65, RESTO=66, COMENTARIO_N_FECHADO=67, 
		CADEIA_N_FECHADA=68, ERRO=69;
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
			"Verdadeiro", "E", "OU", "NUM_INT", "NUM_REAL", "IDENT", "CADEIA", "ESC_SEQ", 
			"COMENTARIO", "WS", "DOTS", "DOT", "LEFT", "RIGHT", "DIFERENTE", "MENOR_IGUAL", 
			"MAIOR_IGUAL", "MENOR", "MAIOR", "IGUAL", "PLUS", "MINUS", "ASTE", "SLASH", 
			"COMMA", "DELIM", "ABREPAR", "FECHAPAR", "ABRECOL", "FECHACOL", "CHAPEU", 
			"AND", "RESTO", "COMENTARIO_N_FECHADO", "CADEIA_N_FECHADA", "ERRO"
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
			"RESTO", "COMENTARIO_N_FECHADO", "CADEIA_N_FECHADA", "ERRO"
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
		case 42:
			COMENTARIO_action((RuleContext)_localctx, actionIndex);
			break;
		case 43:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2G\u0224\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26"+
		"\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3"+
		"$\3$\3$\3$\3$\3$\3%\3%\3&\3&\3&\3\'\6\'\u01ab\n\'\r\'\16\'\u01ac\3(\6"+
		"(\u01b0\n(\r(\16(\u01b1\3(\3(\6(\u01b6\n(\r(\16(\u01b7\5(\u01ba\n(\3)"+
		"\3)\7)\u01be\n)\f)\16)\u01c1\13)\3*\3*\3*\7*\u01c6\n*\f*\16*\u01c9\13"+
		"*\3*\3*\3+\3+\3+\3,\3,\7,\u01d2\n,\f,\16,\u01d5\13,\3,\3,\3,\3-\3-\3-"+
		"\3.\3.\3.\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63"+
		"\3\63\3\64\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3"+
		";\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\7E\u0213"+
		"\nE\fE\16E\u0216\13E\3E\3E\3F\3F\7F\u021c\nF\fF\16F\u021f\13F\3F\3F\3"+
		"G\3G\4\u0214\u021d\2H\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U\2W,Y-[.]/_\60a\61c\62"+
		"e\63g\64i\65k\66m\67o8q9s:u;w<y={>}?\177@\u0081A\u0083B\u0085C\u0087D"+
		"\u0089E\u008bF\u008dG\3\2\t\4\2C\\c|\6\2\62;C\\aac|\5\2\f\f$$^^\5\2\f"+
		"\f\17\17\177\177\5\2\13\f\17\17\"\"\3\2\177\177\3\2$$\2\u022c\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3"+
		"\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2"+
		"=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3"+
		"\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2W\3\2\2"+
		"\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2"+
		"e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3"+
		"\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2"+
		"\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087"+
		"\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\3\u008f\3\2\2"+
		"\2\5\u0099\3\2\2\2\7\u00a7\3\2\2\2\t\u00af\3\2\2\2\13\u00b7\3\2\2\2\r"+
		"\u00bf\3\2\2\2\17\u00c4\3\2\2\2\21\u00cc\3\2\2\2\23\u00d1\3\2\2\2\25\u00d8"+
		"\3\2\2\2\27\u00dc\3\2\2\2\31\u00e3\3\2\2\2\33\u00ec\3\2\2\2\35\u00f5\3"+
		"\2\2\2\37\u0102\3\2\2\2!\u0105\3\2\2\2#\u010b\3\2\2\2%\u0111\3\2\2\2\'"+
		"\u0116\3\2\2\2)\u011b\3\2\2\2+\u0120\3\2\2\2-\u0124\3\2\2\2/\u0129\3\2"+
		"\2\2\61\u0132\3\2\2\2\63\u013b\3\2\2\2\65\u0148\3\2\2\2\67\u014d\3\2\2"+
		"\29\u0151\3\2\2\2;\u015e\3\2\2\2=\u016f\3\2\2\2?\u0177\3\2\2\2A\u017e"+
		"\3\2\2\2C\u0189\3\2\2\2E\u0193\3\2\2\2G\u0199\3\2\2\2I\u01a4\3\2\2\2K"+
		"\u01a6\3\2\2\2M\u01aa\3\2\2\2O\u01af\3\2\2\2Q\u01bb\3\2\2\2S\u01c2\3\2"+
		"\2\2U\u01cc\3\2\2\2W\u01cf\3\2\2\2Y\u01d9\3\2\2\2[\u01dc\3\2\2\2]\u01df"+
		"\3\2\2\2_\u01e1\3\2\2\2a\u01e4\3\2\2\2c\u01e7\3\2\2\2e\u01ea\3\2\2\2g"+
		"\u01ed\3\2\2\2i\u01f0\3\2\2\2k\u01f2\3\2\2\2m\u01f4\3\2\2\2o\u01f6\3\2"+
		"\2\2q\u01f8\3\2\2\2s\u01fa\3\2\2\2u\u01fc\3\2\2\2w\u01fe\3\2\2\2y\u0200"+
		"\3\2\2\2{\u0202\3\2\2\2}\u0204\3\2\2\2\177\u0206\3\2\2\2\u0081\u0208\3"+
		"\2\2\2\u0083\u020a\3\2\2\2\u0085\u020c\3\2\2\2\u0087\u020e\3\2\2\2\u0089"+
		"\u0210\3\2\2\2\u008b\u0219\3\2\2\2\u008d\u0222\3\2\2\2\u008f\u0090\7c"+
		"\2\2\u0090\u0091\7n\2\2\u0091\u0092\7i\2\2\u0092\u0093\7q\2\2\u0093\u0094"+
		"\7t\2\2\u0094\u0095\7k\2\2\u0095\u0096\7v\2\2\u0096\u0097\7o\2\2\u0097"+
		"\u0098\7q\2\2\u0098\4\3\2\2\2\u0099\u009a\7h\2\2\u009a\u009b\7k\2\2\u009b"+
		"\u009c\7o\2\2\u009c\u009d\7a\2\2\u009d\u009e\7c\2\2\u009e\u009f\7n\2\2"+
		"\u009f\u00a0\7i\2\2\u00a0\u00a1\7q\2\2\u00a1\u00a2\7t\2\2\u00a2\u00a3"+
		"\7k\2\2\u00a3\u00a4\7v\2\2\u00a4\u00a5\7o\2\2\u00a5\u00a6\7q\2\2\u00a6"+
		"\6\3\2\2\2\u00a7\u00a8\7f\2\2\u00a8\u00a9\7g\2\2\u00a9\u00aa\7e\2\2\u00aa"+
		"\u00ab\7n\2\2\u00ab\u00ac\7c\2\2\u00ac\u00ad\7t\2\2\u00ad\u00ae\7g\2\2"+
		"\u00ae\b\3\2\2\2\u00af\u00b0\7n\2\2\u00b0\u00b1\7k\2\2\u00b1\u00b2\7v"+
		"\2\2\u00b2\u00b3\7g\2\2\u00b3\u00b4\7t\2\2\u00b4\u00b5\7c\2\2\u00b5\u00b6"+
		"\7n\2\2\u00b6\n\3\2\2\2\u00b7\u00b8\7k\2\2\u00b8\u00b9\7p\2\2\u00b9\u00ba"+
		"\7v\2\2\u00ba\u00bb\7g\2\2\u00bb\u00bc\7k\2\2\u00bc\u00bd\7t\2\2\u00bd"+
		"\u00be\7q\2\2\u00be\f\3\2\2\2\u00bf\u00c0\7n\2\2\u00c0\u00c1\7g\2\2\u00c1"+
		"\u00c2\7k\2\2\u00c2\u00c3\7c\2\2\u00c3\16\3\2\2\2\u00c4\u00c5\7g\2\2\u00c5"+
		"\u00c6\7u\2\2\u00c6\u00c7\7e\2\2\u00c7\u00c8\7t\2\2\u00c8\u00c9\7g\2\2"+
		"\u00c9\u00ca\7x\2\2\u00ca\u00cb\7c\2\2\u00cb\20\3\2\2\2\u00cc\u00cd\7"+
		"t\2\2\u00cd\u00ce\7g\2\2\u00ce\u00cf\7c\2\2\u00cf\u00d0\7n\2\2\u00d0\22"+
		"\3\2\2\2\u00d1\u00d2\7n\2\2\u00d2\u00d3\7q\2\2\u00d3\u00d4\7i\2\2\u00d4"+
		"\u00d5\7k\2\2\u00d5\u00d6\7e\2\2\u00d6\u00d7\7q\2\2\u00d7\24\3\2\2\2\u00d8"+
		"\u00d9\7p\2\2\u00d9\u00da\7c\2\2\u00da\u00db\7q\2\2\u00db\26\3\2\2\2\u00dc"+
		"\u00dd\7h\2\2\u00dd\u00de\7k\2\2\u00de\u00df\7o\2\2\u00df\u00e0\7a\2\2"+
		"\u00e0\u00e1\7u\2\2\u00e1\u00e2\7g\2\2\u00e2\30\3\2\2\2\u00e3\u00e4\7"+
		"h\2\2\u00e4\u00e5\7k\2\2\u00e5\u00e6\7o\2\2\u00e6\u00e7\7a\2\2\u00e7\u00e8"+
		"\7e\2\2\u00e8\u00e9\7c\2\2\u00e9\u00ea\7u\2\2\u00ea\u00eb\7q\2\2\u00eb"+
		"\32\3\2\2\2\u00ec\u00ed\7h\2\2\u00ed\u00ee\7k\2\2\u00ee\u00ef\7o\2\2\u00ef"+
		"\u00f0\7a\2\2\u00f0\u00f1\7r\2\2\u00f1\u00f2\7c\2\2\u00f2\u00f3\7t\2\2"+
		"\u00f3\u00f4\7c\2\2\u00f4\34\3\2\2\2\u00f5\u00f6\7h\2\2\u00f6\u00f7\7"+
		"k\2\2\u00f7\u00f8\7o\2\2\u00f8\u00f9\7a\2\2\u00f9\u00fa\7g\2\2\u00fa\u00fb"+
		"\7p\2\2\u00fb\u00fc\7s\2\2\u00fc\u00fd\7w\2\2\u00fd\u00fe\7c\2\2\u00fe"+
		"\u00ff\7p\2\2\u00ff\u0100\7v\2\2\u0100\u0101\7q\2\2\u0101\36\3\2\2\2\u0102"+
		"\u0103\7u\2\2\u0103\u0104\7g\2\2\u0104 \3\2\2\2\u0105\u0106\7g\2\2\u0106"+
		"\u0107\7p\2\2\u0107\u0108\7v\2\2\u0108\u0109\7c\2\2\u0109\u010a\7q\2\2"+
		"\u010a\"\3\2\2\2\u010b\u010c\7u\2\2\u010c\u010d\7g\2\2\u010d\u010e\7p"+
		"\2\2\u010e\u010f\7c\2\2\u010f\u0110\7q\2\2\u0110$\3\2\2\2\u0111\u0112"+
		"\7e\2\2\u0112\u0113\7c\2\2\u0113\u0114\7u\2\2\u0114\u0115\7q\2\2\u0115"+
		"&\3\2\2\2\u0116\u0117\7u\2\2\u0117\u0118\7g\2\2\u0118\u0119\7l\2\2\u0119"+
		"\u011a\7c\2\2\u011a(\3\2\2\2\u011b\u011c\7r\2\2\u011c\u011d\7c\2\2\u011d"+
		"\u011e\7t\2\2\u011e\u011f\7c\2\2\u011f*\3\2\2\2\u0120\u0121\7c\2\2\u0121"+
		"\u0122\7v\2\2\u0122\u0123\7g\2\2\u0123,\3\2\2\2\u0124\u0125\7h\2\2\u0125"+
		"\u0126\7c\2\2\u0126\u0127\7e\2\2\u0127\u0128\7c\2\2\u0128.\3\2\2\2\u0129"+
		"\u012a\7g\2\2\u012a\u012b\7p\2\2\u012b\u012c\7s\2\2\u012c\u012d\7w\2\2"+
		"\u012d\u012e\7c\2\2\u012e\u012f\7p\2\2\u012f\u0130\7v\2\2\u0130\u0131"+
		"\7q\2\2\u0131\60\3\2\2\2\u0132\u0133\7t\2\2\u0133\u0134\7g\2\2\u0134\u0135"+
		"\7i\2\2\u0135\u0136\7k\2\2\u0136\u0137\7u\2\2\u0137\u0138\7v\2\2\u0138"+
		"\u0139\7t\2\2\u0139\u013a\7q\2\2\u013a\62\3\2\2\2\u013b\u013c\7h\2\2\u013c"+
		"\u013d\7k\2\2\u013d\u013e\7o\2\2\u013e\u013f\7a\2\2\u013f\u0140\7t\2\2"+
		"\u0140\u0141\7g\2\2\u0141\u0142\7i\2\2\u0142\u0143\7k\2\2\u0143\u0144"+
		"\7u\2\2\u0144\u0145\7v\2\2\u0145\u0146\7t\2\2\u0146\u0147\7q\2\2\u0147"+
		"\64\3\2\2\2\u0148\u0149\7v\2\2\u0149\u014a\7k\2\2\u014a\u014b\7r\2\2\u014b"+
		"\u014c\7q\2\2\u014c\66\3\2\2\2\u014d\u014e\7x\2\2\u014e\u014f\7c\2\2\u014f"+
		"\u0150\7t\2\2\u01508\3\2\2\2\u0151\u0152\7r\2\2\u0152\u0153\7t\2\2\u0153"+
		"\u0154\7q\2\2\u0154\u0155\7e\2\2\u0155\u0156\7g\2\2\u0156\u0157\7f\2\2"+
		"\u0157\u0158\7k\2\2\u0158\u0159\7o\2\2\u0159\u015a\7g\2\2\u015a\u015b"+
		"\7p\2\2\u015b\u015c\7v\2\2\u015c\u015d\7q\2\2\u015d:\3\2\2\2\u015e\u015f"+
		"\7h\2\2\u015f\u0160\7k\2\2\u0160\u0161\7o\2\2\u0161\u0162\7a\2\2\u0162"+
		"\u0163\7r\2\2\u0163\u0164\7t\2\2\u0164\u0165\7q\2\2\u0165\u0166\7e\2\2"+
		"\u0166\u0167\7g\2\2\u0167\u0168\7f\2\2\u0168\u0169\7k\2\2\u0169\u016a"+
		"\7o\2\2\u016a\u016b\7g\2\2\u016b\u016c\7p\2\2\u016c\u016d\7v\2\2\u016d"+
		"\u016e\7q\2\2\u016e<\3\2\2\2\u016f\u0170\7t\2\2\u0170\u0171\7g\2\2\u0171"+
		"\u0172\7v\2\2\u0172\u0173\7q\2\2\u0173\u0174\7t\2\2\u0174\u0175\7p\2\2"+
		"\u0175\u0176\7g\2\2\u0176>\3\2\2\2\u0177\u0178\7h\2\2\u0178\u0179\7w\2"+
		"\2\u0179\u017a\7p\2\2\u017a\u017b\7e\2\2\u017b\u017c\7c\2\2\u017c\u017d"+
		"\7q\2\2\u017d@\3\2\2\2\u017e\u017f\7h\2\2\u017f\u0180\7k\2\2\u0180\u0181"+
		"\7o\2\2\u0181\u0182\7a\2\2\u0182\u0183\7h\2\2\u0183\u0184\7w\2\2\u0184"+
		"\u0185\7p\2\2\u0185\u0186\7e\2\2\u0186\u0187\7c\2\2\u0187\u0188\7q\2\2"+
		"\u0188B\3\2\2\2\u0189\u018a\7e\2\2\u018a\u018b\7q\2\2\u018b\u018c\7p\2"+
		"\2\u018c\u018d\7u\2\2\u018d\u018e\7v\2\2\u018e\u018f\7c\2\2\u018f\u0190"+
		"\7p\2\2\u0190\u0191\7v\2\2\u0191\u0192\7g\2\2\u0192D\3\2\2\2\u0193\u0194"+
		"\7h\2\2\u0194\u0195\7c\2\2\u0195\u0196\7n\2\2\u0196\u0197\7u\2\2\u0197"+
		"\u0198\7q\2\2\u0198F\3\2\2\2\u0199\u019a\7x\2\2\u019a\u019b\7g\2\2\u019b"+
		"\u019c\7t\2\2\u019c\u019d\7f\2\2\u019d\u019e\7c\2\2\u019e\u019f\7f\2\2"+
		"\u019f\u01a0\7g\2\2\u01a0\u01a1\7k\2\2\u01a1\u01a2\7t\2\2\u01a2\u01a3"+
		"\7q\2\2\u01a3H\3\2\2\2\u01a4\u01a5\7g\2\2\u01a5J\3\2\2\2\u01a6\u01a7\7"+
		"q\2\2\u01a7\u01a8\7w\2\2\u01a8L\3\2\2\2\u01a9\u01ab\4\62;\2\u01aa\u01a9"+
		"\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad"+
		"N\3\2\2\2\u01ae\u01b0\4\62;\2\u01af\u01ae\3\2\2\2\u01b0\u01b1\3\2\2\2"+
		"\u01b1\u01af\3\2\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01b9\3\2\2\2\u01b3\u01b5"+
		"\7\60\2\2\u01b4\u01b6\4\62;\2\u01b5\u01b4\3\2\2\2\u01b6\u01b7\3\2\2\2"+
		"\u01b7\u01b5\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01ba\3\2\2\2\u01b9\u01b3"+
		"\3\2\2\2\u01b9\u01ba\3\2\2\2\u01baP\3\2\2\2\u01bb\u01bf\t\2\2\2\u01bc"+
		"\u01be\t\3\2\2\u01bd\u01bc\3\2\2\2\u01be\u01c1\3\2\2\2\u01bf\u01bd\3\2"+
		"\2\2\u01bf\u01c0\3\2\2\2\u01c0R\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c2\u01c7"+
		"\7$\2\2\u01c3\u01c6\5U+\2\u01c4\u01c6\n\4\2\2\u01c5\u01c3\3\2\2\2\u01c5"+
		"\u01c4\3\2\2\2\u01c6\u01c9\3\2\2\2\u01c7\u01c5\3\2\2\2\u01c7\u01c8\3\2"+
		"\2\2\u01c8\u01ca\3\2\2\2\u01c9\u01c7\3\2\2\2\u01ca\u01cb\7$\2\2\u01cb"+
		"T\3\2\2\2\u01cc\u01cd\7^\2\2\u01cd\u01ce\7)\2\2\u01ceV\3\2\2\2\u01cf\u01d3"+
		"\7}\2\2\u01d0\u01d2\n\5\2\2\u01d1\u01d0\3\2\2\2\u01d2\u01d5\3\2\2\2\u01d3"+
		"\u01d1\3\2\2\2\u01d3\u01d4\3\2\2\2\u01d4\u01d6\3\2\2\2\u01d5\u01d3\3\2"+
		"\2\2\u01d6\u01d7\7\177\2\2\u01d7\u01d8\b,\2\2\u01d8X\3\2\2\2\u01d9\u01da"+
		"\t\6\2\2\u01da\u01db\b-\3\2\u01dbZ\3\2\2\2\u01dc\u01dd\7\60\2\2\u01dd"+
		"\u01de\7\60\2\2\u01de\\\3\2\2\2\u01df\u01e0\7\60\2\2\u01e0^\3\2\2\2\u01e1"+
		"\u01e2\7>\2\2\u01e2\u01e3\7/\2\2\u01e3`\3\2\2\2\u01e4\u01e5\7/\2\2\u01e5"+
		"\u01e6\7@\2\2\u01e6b\3\2\2\2\u01e7\u01e8\7>\2\2\u01e8\u01e9\7@\2\2\u01e9"+
		"d\3\2\2\2\u01ea\u01eb\7>\2\2\u01eb\u01ec\7?\2\2\u01ecf\3\2\2\2\u01ed\u01ee"+
		"\7@\2\2\u01ee\u01ef\7?\2\2\u01efh\3\2\2\2\u01f0\u01f1\7>\2\2\u01f1j\3"+
		"\2\2\2\u01f2\u01f3\7@\2\2\u01f3l\3\2\2\2\u01f4\u01f5\7?\2\2\u01f5n\3\2"+
		"\2\2\u01f6\u01f7\7-\2\2\u01f7p\3\2\2\2\u01f8\u01f9\7/\2\2\u01f9r\3\2\2"+
		"\2\u01fa\u01fb\7,\2\2\u01fbt\3\2\2\2\u01fc\u01fd\7\61\2\2\u01fdv\3\2\2"+
		"\2\u01fe\u01ff\7.\2\2\u01ffx\3\2\2\2\u0200\u0201\7<\2\2\u0201z\3\2\2\2"+
		"\u0202\u0203\7*\2\2\u0203|\3\2\2\2\u0204\u0205\7+\2\2\u0205~\3\2\2\2\u0206"+
		"\u0207\7]\2\2\u0207\u0080\3\2\2\2\u0208\u0209\7_\2\2\u0209\u0082\3\2\2"+
		"\2\u020a\u020b\7`\2\2\u020b\u0084\3\2\2\2\u020c\u020d\7(\2\2\u020d\u0086"+
		"\3\2\2\2\u020e\u020f\7\'\2\2\u020f\u0088\3\2\2\2\u0210\u0214\7}\2\2\u0211"+
		"\u0213\13\2\2\2\u0212\u0211\3\2\2\2\u0213\u0216\3\2\2\2\u0214\u0215\3"+
		"\2\2\2\u0214\u0212\3\2\2\2\u0215\u0217\3\2\2\2\u0216\u0214\3\2\2\2\u0217"+
		"\u0218\n\7\2\2\u0218\u008a\3\2\2\2\u0219\u021d\7$\2\2\u021a\u021c\13\2"+
		"\2\2\u021b\u021a\3\2\2\2\u021c\u021f\3\2\2\2\u021d\u021e\3\2\2\2\u021d"+
		"\u021b\3\2\2\2\u021e\u0220\3\2\2\2\u021f\u021d\3\2\2\2\u0220\u0221\n\b"+
		"\2\2\u0221\u008c\3\2\2\2\u0222\u0223\13\2\2\2\u0223\u008e\3\2\2\2\r\2"+
		"\u01ac\u01b1\u01b7\u01b9\u01bf\u01c5\u01c7\u01d3\u0214\u021d\4\3,\2\3"+
		"-\3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}