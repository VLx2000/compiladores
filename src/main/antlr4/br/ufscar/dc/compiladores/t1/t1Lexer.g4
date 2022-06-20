lexer grammar t1Lexer;

Algoritmo
	: 'algoritmo'
	;
Fim_algoritmo
	: 'fim_algoritmo'
	;
Declare
	: 'declare'
	;
Literal
	: 'literal'
	;
Inteiro
	: 'inteiro'
	;
Leia
	: 'leia'
	;
Escreva
	: 'escreva'
	;
Real
	: 'real'
	;
Logico
	: 'logico'
	;
Nao
	: 'nao'
	;
Fim_se
	: 'fim_se'
	;
Fim_caso
	: 'fim_caso'
	;
Fim_para
	: 'fim_para'
	;
Fim_enquanto
	: 'fim_enquanto'
	;
Se
	: 'se'
	;
Entao
	: 'entao'
	;
Senao
	: 'senao'
	;
Caso
	: 'caso'
	;
Seja
	: 'seja'
	;
Para
	: 'para'
	;
Ate
	: 'ate'
	;
Faca
	: 'faca'
	;
Enquanto
	: 'enquanto'
	;
Registro: 'registro'
	;
Fim_registro: 'fim_registro'
	;
Tipo: 'tipo'
	;
Var: 'var'
	;
Procedimento: 'procedimento'
	;
Fim_procedimento:'fim_procedimento'
	;

Retorne: 'retorne'
	;
Funcao: 'funcao'
	;
Fim_funcao: 'fim_funcao'
	;

Constante: 'constante';

Falso: 'falso';

Verdadeiro: 'verdadeiro';

E	
	: 'e'
	;
OU
	: 'ou'
	;
NUM_INT
	: ('0'..'9')+
	;
NUM_REAL
	: ('0'..'9')+ ('.' ('0'..'9')+)?
	;
IDENT
	: ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
	;

CADEIA 	
	: '"' ( ESC_SEQ | ~('"'|'\\'|'\n') )* '"'
	;


fragment ESC_SEQ	
	: '\\\''
	;

COMENTARIO
    : '{' ~('\n'|'\r'|'}')* '}' {skip();}
    ;


WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {skip();}
    ;
DOTS	:	'..'
	;
DOT		:	'.'
	;
LEFT	:	'<-'
	;
RIGHT	:	'->'
	;
DIFERENTE	:	'<>'
	;
MENOR_IGUAL	:	'<='
	;
MAIOR_IGUAL	:	'>='
	;
MENOR	:	'<'
	;
MAIOR	:	'>'
	;
IGUAL	:	'='
	;
PLUS	:	'+'
	;
MINUS	:	'-'
	;
ASTE	:	'*'
	;
SLASH	:	'/'
	;
COMMA	:	','
	;
DELIM	:	':'
	;
ABREPAR :	'('
	;
FECHAPAR:	')'
	;
ABRECOL :	'['
	;
FECHACOL:	']'
	;
CHAPEU	:	'^'
	;
AND	:	'&'
	;
RESTO	:	'%'
	;

COMENTARIO_N_FECHADO
	: '{'.*?~('}')
	;
CADEIA_N_FECHADA
	: '"'.*?~('"')
	;

ERRO: .;