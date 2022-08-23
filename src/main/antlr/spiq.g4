grammar spiq;

@header {
    package gen;
}

@lexer::members {
    public int lexicalErrors=0;
}

prog : progbody EOF;

progbody : 'ciao';

WHITESP  : ( '\t' | ' ' | '\r' | '\n' )+    -> channel(HIDDEN) ;
COMMENT : '/*' .*? '*/' -> channel(HIDDEN) ;
ERR   	 : . {
    System.out.println("Invalid char: " + getText() + " at line " + getLine());
    lexicalErrors++;
    } -> channel(HIDDEN);