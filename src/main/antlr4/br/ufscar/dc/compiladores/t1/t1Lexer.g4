lexer grammar t1Lexer;

PALAVRA_CHAVE 			: 'algoritmo' | 'fim_algoritmo' | 'declare' | 'var' | 'tipo' | 'literal' 
						| 'inteiro' | 'real' | 'logico' | 'e' | 'ou' | 'verdadeiro' | 'falso' | 'constante' 
						| 'leia' | 'escreva'  | 'nao' | 'se' | 'entao' | 'senao' | 'fim_se' | 'caso' | 'fim_caso' 
						| 'para' | 'fim_para' | 'enquanto' | 'fim_enquanto' | 'faca' | 'seja' | 'ate' 
						| 'registro' | 'fim_registro' | 'procedimento' | 'fim_procedimento' | 'retorne' 
						| 'funcao' | 'fim_funcao' | '<-' | '->';

NUM_INT 				: ('0'..'9')+;
NUM_REAL				: ('0'..'9')+ ('.' ('0'..'9')+)?;
IDENT					: ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
CADEIA 					: '"' ( ESC_SEQ | ~('"'|'\\'|'\n') )* '"';
						fragment ESC_SEQ : '\\\'';

COMENTARIO 				: '{' ~('\n'|'\r'|'}')* '}' {skip();};

WS  					:   ( ' ' | '\t' | '\r' | '\n') {skip();};

OP_RELACIONAIS 			: '<>' | '<=' | '>=' | '<' | '>' | '=';
OP_ARITMETICOS 			: '+' | '-' | '*' | '/' | '%' | '^';

ABREPAR 				:	'(';
FECHAPAR				:	')';
ABRECOL 				:	'[';
FECHACOL				:	']';

DOT						:	'.';
DOTS					:	'..';

COMMA					:	',';
DELIM					:	':';

ENDERECO				:	'&';

COMENTARIO_N_FECHADO 	: '{'.*?~('}');
CADEIA_N_FECHADA		: '"'.*?~('"');

ERRO					: .;