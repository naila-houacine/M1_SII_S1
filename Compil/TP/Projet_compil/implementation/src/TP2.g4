grammar TP2;

start_rule : 'compil' PROGNAME '(' ')'
'{'
declarations
'start'
instructions
'}';

declarations
           :    type variables ';' declarations?
           ;
variables:  ID (',' ID)*;

type : 'intcompil' | 'floatcompil';

instructions
           :    instAff ';' instructions?
           |    instIf ';' instructions?
           |    instScan ';' instructions?
           |    instPrint';' instructions?
           |    instFor';' instructions?
           |    instWhile';' instructions?
           |    instCase';' instructions?
           ;

instAff:    ID '=' expression;

instIf: 'if' '(' condition ')' 'then' instructions ('else' instructions 'endif' ';')? ;

instScan : 'scancompil' '(' variables ')' ;
instPrint : 'printcompil' '(' (variables | TEXT) ')' ;
instFor : 'for' '('instAff ';' condition ';' instAff ')' '{' instructions '}' ;
instWhile : 'while' '('condition')' '{' instructions '}' ;
instCase : ID 'match' '{' cases '}' ;

cases : 'case' value '=>' instructions 'break' ';' cases? ;

condition : expression ('>'|'<') expression ;

expression
         :  expression ('*'|'/') expression
         |  expression ('+'|'-') expression
         |  '(' expression ')'
         |  value
         ;

value :     INT
      |     FLOAT
      |     ID
      ;

//Lexicale

PROGNAME : [A-Z]+[a-zA-Z0-9_]* ;
ID : [a-zA-Z]+[a-zA-Z0-9]* ;

FLOAT
    :   '-'? INT '.' INT
    |   '-'? INT
    ;

INT :   '0' | [1-9] [0-9]* ; // no leading zeros

COMMENT : '/*' .*? '*/' -> channel(HIDDEN) ;

TEXT : '"' (~'"'|'\\"')* '"'  ;

WS : [ \t\n\r]+ -> channel(HIDDEN) ;

