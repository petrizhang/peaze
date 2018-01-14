grammar Peaze;

program : apply+;

apply
    : '(' function args ')';

expression
    :  IntegerLiteral
    |  apply
    ;

args : expression+;

function
    :   '+'
    |   '-'
    |   '*'
    |   '/';

//  Integer Literals

IntegerLiteral
	:  [0-9]+
	;


// Whitespace and comments

WS  :  [ \t\r\n\u000C]+ -> skip
    ;

COMMENT
    :   '/*' .*? '*/' -> skip
    ;

LINE_COMMENT
    :   '//' ~[\r\n]* -> skip
    ;