lexer grammar t1Lexer;

// Palavras chaves
PALAVRA_CHAVE 			: 'algoritmo' | 'fim_algoritmo' | 'declare' | 'var' | 'tipo' | 'literal' 
						| 'inteiro' | 'real' | 'logico' | 'e' | 'ou' | 'verdadeiro' | 'falso' | 'constante' 
						| 'leia' | 'escreva'  | 'nao' | 'se' | 'entao' | 'senao' | 'fim_se' | 'caso' | 'fim_caso' 
						| 'para' | 'fim_para' | 'enquanto' | 'fim_enquanto' | 'faca' | 'seja' | 'ate' 
						| 'registro' | 'fim_registro' | 'procedimento' | 'fim_procedimento' | 'retorne' 
						| 'funcao' | 'fim_funcao' | '<-' | '->';

// Números inteiros e reais
NUM_INT 				: ('0'..'9')+;
NUM_REAL				: ('0'..'9')+ ('.' ('0'..'9')+)?;

// Identificador
IDENT					: ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

// Cadeia de caracteres
CADEIA 					: '"' ( ESC_SEQ | ~('"'|'\\'|'\n') )* '"';
						fragment ESC_SEQ : '\\\'';

// Ignorando comentários
//dentro do comentário, são proibidos \n, \r e }. 
//O fechamento de chaves é proíbido para que não sejam aceitos comentários com o final }},
//visto que o algorítimo utiliza a estratégia greedy e aceitaria o lexema considerando } como parte do comentário
COMENTARIO 				: '{' ~('\n'|'\r'|'}')* '}' {skip();};

// Ignorando espaços, tabulação, retorno e quebra de linha
WS  					:   ( ' ' | '\t' | '\r' | '\n') {skip();};

// Operadores relacionais e aritméticos
OP_RELACIONAIS 			: '<>' | '<=' | '>=' | '<' | '>' | '=';
OP_ARITMETICOS 			: '+' | '-' | '*' | '/' | '%' | '^';

// Caracteres especiais
ABREPAR 				:	'(';
FECHAPAR				:	')';
ABRECOL 				:	'[';
FECHACOL				:	']';
DOT						:	'.';
DOTS					:	'..';
COMMA					:	',';
DELIM					:	':';
ENDERECO				:	'&';

// Erros
COMENTARIO_N_FECHADO 	: '{'.*?~('}');
CADEIA_N_FECHADA		: '"'.*?~('"');
//Caso não se tenha encontrado nenhuma correspondência entre o lexema e as regras definidas,o lexema é considerado como um símbolo desconhecido
SIMBOLO_DESCONHECIDO	: .;