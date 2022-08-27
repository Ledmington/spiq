grammar spiq;

@header {
    package gen;
}

@lexer::members {
    public int lexicalErrors=0;
}

prog : progbody EOF;

progbody : (decl DOT)+ ;

decl : ID IS number ;

number   : sign? ( integer | fraction | real ) ;
sign     : PLUS | MINUS ;
integer  : DIGIT+ ;
fraction : num=integer SLASH den=integer ;
real     : integer DOT integer #normalForm
         | DIGIT (DOT integer)? EXP sign? integer #exponentialForm
         ;

IS : 'is';

PLUS  : '+';
MINUS : '-';
SLASH : '/';
DOT   : '.';
EXP   : 'e';

DIGIT : ( '0'..'9' ) ;

ID       : ('a'..'z' | 'A'..'Z')+ ;
WHITESP  : ( '\t' | ' ' | '\r' | '\n' )+  -> channel(HIDDEN) ;
//COMMENT  : '/*' .*? '*/' -> channel(HIDDEN) ;
ERR   	 : . {
    System.out.println("Invalid char: " + getText() + " at line " + getLine());
    lexicalErrors++;
    } -> channel(HIDDEN);