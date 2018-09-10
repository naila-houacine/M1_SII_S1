grammar Tiny_language_SII;

start_rule : 'compil' PROGNAME '(' ')'
'{'
DECLARATIONS
'start'
'}';


DECLARATIONS : TYPE VARIABLES ';' ;
TYPE : 'intcompil' | 'floatcompil';

VARIABLES
        :   ID
        |   ID ',' VARIABLES
        ;

var
        :   ID NEWLINE
        |   ID ',' VARIABLES
        ;

OPERATEUR
        :   '+'
        |   '-'
        |   '*'
        |   '/'
        ;


INSTIF :  'if' '(' CONDITION ')' 'then' INSTRUCTIONS ELSE 'endif' ';' ;

fragment ELSE
            :  'else' INSTRUCTIONS
            |
            ;


CONDITION
        :   EXP '>' EXP
        |   EXP '<' EXP
        ;


fragment INSTRUCTIONS
                    :   AFFECTATION INSTRUCTIONS
                    |   INSTIF INSTRUCTIONS
                    |
                    ;

AFFECTATION : ID '=' VALUE ;

EXP : INT OPERATEUR INT
    | FLOAT OPERATEUR FLOAT
    ;

VALUE : FLOAT | INT ;

PROGNAME : [A-Z]+[a-zA-Z0-9_]* ;
ID : [a-zA-Z]+[a-zA-Z0-9]* ;

FLOAT
    :   '-'? INT '.' INT
    |   '-'? INT
    ;

INT :   '0' | [1-9] [0-9]* ; // no leading zeros

COMMENT : '/*' .*? '*/' -> channel(HIDDEN) ;

WS : [ \t\n\r]+ -> channel(HIDDEN) ;


