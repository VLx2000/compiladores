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
IDENT : ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'0'..'9')*
	;
CADEIA : ('"'.*?'"')
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
COMMA	:	','
	;
DELIM	:	':'
	;
ABREPAR :	'('
	;
FECHAPAR:	')'
	;