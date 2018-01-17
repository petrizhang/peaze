grammar Peaze;

program : topunit+;

topunit
    :  define # DefineTopunit
    |  apply  # ApplyTopunit
    ;

define
    :  '(' DEFINE '(' ID paramList ')' sequence ')'  # ProcDefine
    |  '(' DEFINE ID lambda ')'                      # LambdaDefine
    |  '(' DEFINE ID expr ')'                        # VarDefine
    ;

apply
    : '(' procedure expr*')'
    ;

expr
    :  if_      # IfExpr
    |  literal  # LiteralExpr
    |  apply    # ApplyExpr
    |  lambda   # LambdaExpr
    |  varRef   # VarRefExpr
    ;

if_
    : '(' 'if' cond expr else_body ')'   # FullIf
    | '(' 'if' cond expr ')'             # PartialIf
    ;

lambda
    :  '(' LAMBDA '(' paramList ')' sequence ')'
    ;

varRef
    :  ID
    ;

literal
    :  Digits         # IntegerLiteral
    |  BooleanLiteral # BooleanLiteral
    |  DecimalLiteral # DecimalLiteral
    ;

sequence
   :  (define|expr)+
   ;

procedure : expr;

cond : expr;

else_body : expr;

paramList
    : ID*
    ;


//  Keywords
LAMBDA : 'lambda';
DEFINE : 'define';

//  Separators

LPAREN : '(';
RPAREN : ')';

//  Operators


//  Integer Literals
Digits : [0-9]+;

BooleanLiteral
    : '#t'
    | '#f'
    ;

DecimalLiteral
    : Digits '.' Digits
    ;

ID
    :  [a-zA-Z0-9!$%&*+-./:<=>?@^_~]+
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