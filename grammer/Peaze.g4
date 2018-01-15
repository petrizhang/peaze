grammar Peaze;

program : topunit+;

topunit
    :  define
    |  apply
    ;

lambda
    :  '(' LAMBDA '(' symbol+ ')' sequence ')'
    ;

define
    :  '(' DEFINE '(' symbol+ ')' sequence ')' # FuncDefine
    |  '(' DEFINE symbol lambda ')'            # LambdaDefine
    |  '(' DEFINE symbol expr ')'              # VarDefine
    ;

apply
    : '(' builtin expr* ')'  # BuiltinApply
    | '(' lambda expr* ')'   # LambdaApply
    | '(' expr+ ')'          # ExprApply
    ;

sequence
    :  (define|expr)+
    ;

expr
    :  literal
    |  symbol
    |  lambda
    |  apply
    ;

empty : '(' ')';

builtin
    :  ADD
    |  SUB
    |  MUL
    |  DIV
    ;

literal
    :  Digits         # IntegerLiteral
    |  BooleanLiteral # BooleanLiteral
    |  DecimalLiteral # DecimalLiteral
    ;

symbol
    :  SYMBOL
    ;

//  Keywords
LAMBDA : 'lambda';
DEFINE : 'define';

//  Separators

LPAREN : '(';
RPAREN : ')';

//  Operators
GT : '>';
LT : '<';
BANG : '!';
TILDE : '~';
EQUAL : '=';
LE : '<=';
GE : '>=';
NOTEQUAL : '!=';
AND : 'and';
OR : 'or';
XOR : 'xor';
ADD : '+';
SUB : '-';
MUL : '*';
DIV : '/';
MOD : '%';
BITAND : '&';
BITOR : '|';
CARET : '^';

//  Integer Literals
Digits : [0-9]+;

BooleanLiteral
    : 'true'
    | 'false'
    ;

DecimalLiteral
    : Digits '.' Digits
    ;

SYMBOL
    :  SYMBOL_HEAD [a-zA-Z0-9_$]*
    ;

SYMBOL_HEAD
    :  [a-zA-Z_$]+
    ;

// Whitespace and comments

WS  :  [ \t\r\n\u000C]+ -> skip
    ;

COMMENT
    :  '/*' .*? '*/' -> skip
    ;
COMMENT1
    :  '#|' .*? '|#' -> skip
    ;
LINE_COMMENT
    :  '//' ~[\r\n]* -> skip
    ;
LINE_COMMENT1
    :  ';;;' ~[\r\n]* -> skip
    ;