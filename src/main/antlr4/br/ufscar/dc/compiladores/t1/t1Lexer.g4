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
E	
	: 'e'
	;
OU
	: 'ou'
	;
NUM_INT
	: ('+'|'-')?('0'..'9')+
	;
NUM_REAL
	: ('+'|'-')?('0'..'9')+ ('.' ('0'..'9')+)?
	;
IDENT
	: ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'0'..'9')*
	;
CADEIA
	: ('"'.*?'"')
	;
COMENTARIO
    :   ('{'.*?'}') {skip();}
    ;
WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {skip();}
    ;
DOTS	:	'..'
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