grammar spiq;

@header {
    package gen;
}

@lexer::members {
    public int lexicalErrors=0;
}

prog : progbody EOF;

progbody : (decl DOT)+ ;

decl : ID IS numberDeclaration ;

numberDeclaration       : withoutValueDeclaration | withValueDeclaration ;
withoutValueDeclaration : A ( NUMBER | FRACTION | RATIONAL | REAL )
                        | AN INTEGER ;
withValueDeclaration    : SIGN? ( integer | fraction | real ) ;
integer  : DIGIT+ ;
fraction : num=integer SLASH den=integer ;
real     : integer DOT integer #normalForm
         | DIGIT (DOT DIGIT+)? EXP SIGN? integer #exponentialForm
         ;

IS : 'is';

SIGN  : PLUS | MINUS ;
PLUS  : '+';
MINUS : '-';
SLASH : '/';
DOT   : '.';
EXP   : 'e';
A     : 'a';
AN    : 'an';
INTEGER  : 'integer';
NUMBER   : 'number';
FRACTION : 'fraction';
RATIONAL : 'rational';
REAL     : 'real';

DIGIT : ( '0'..'9' ) ;

ID       : ('a'..'z' | 'A'..'Z')+ ;
WHITESP  : ( '\t' | ' ' | '\r' | '\n' )+  -> channel(HIDDEN) ;
//COMMENT  : '/*' .*? '*/' -> channel(HIDDEN) ;
ERR   	 : . {
    System.out.println("Invalid char: " + getText() + " at line " + getLine());
    lexicalErrors++;
    } -> channel(HIDDEN);