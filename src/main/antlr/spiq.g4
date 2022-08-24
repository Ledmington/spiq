grammar spiq;

@header {
    package gen;
}

@lexer::members {
    public int lexicalErrors=0;
}

prog : progbody EOF;

progbody : decl+ ;

decl : ID IS number ;

number   : sign? ( integer | real | fraction ) ;
sign     : PLUS | MINUS ;
integer  : ZERO | NON_ZERO_DIGIT DIGIT* ;
fraction : integer SLASH integer ;
real     : integer DOT integer #normalForm
         | DIGIT DOT DIGIT+ 'e' sign? integer #exponentialForm
         ;

IS : 'is';

PLUS  : '+';
MINUS : '-';
DOT   : '.';
SLASH : '/';

ZERO  : '0' ;
DIGIT : ( '0'..'9' ) ;
NON_ZERO_DIGIT : ('1'..'9') ;

ID       : ('a'..'z' | 'A'..'Z')+ ;
WHITESP  : ( '\t' | ' ' | '\r' | '\n' )+  -> channel(HIDDEN) ;
COMMENT  : '/*' .*? '*/' -> channel(HIDDEN) ;
ERR   	 : . {
    System.out.println("Invalid char: " + getText() + " at line " + getLine());
    lexicalErrors++;
    } -> channel(HIDDEN);