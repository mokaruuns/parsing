grammar Meta;

@header{import grammar.*;}

start
    :
    grammar_name
    rule+
    EOF
    ;

rule
    :
    term
    | nonTerm
    ;

term returns [Term t]
    :
    TERM ':' REGEX ';' {$t = new Term($TERM.text, $REGEX.text);}
    ;

nonTerm returns [NonTerm nt]
    :
    NONTERM {$nt = new NonTerm($NONTERM.text);}
    (argsValue {$nt.setArgs($argsValue.array);})?
    (returnedValue {$nt.setReturnValue($returnedValue.rValue);})?
    ':'
    right {$nt.addAlternative($right.array);}
    ('|' right {$nt.addAlternative($right.array);})*
    ';'
    ;


returnedValue returns [ExtraValue rValue]
    :
    'returns' '[' TERM NONTERM ']' {$rValue = new ExtraValue($TERM.text, $NONTERM.text);}
    ;

argsValue returns [ArrayList<ExtraValue> array]
    :
    {$array = new ArrayList();}
    'args' '('
    TERM NONTERM {$array.add(new ExtraValue($TERM.text, $NONTERM.text));}
    (',' TERM NONTERM {$array.add(new ExtraValue($TERM.text, $NONTERM.text));})*
     ')'
     ;


right returns[ArrayList<ValueToken> array]
    :
    {$array = new ArrayList();}
    (
    {ValueToken v;}

    (TERM {v = new ValueToken($TERM.text, Type.TERM);}

    | NONTERM {v = new ValueToken($NONTERM.text, Type.NON_TERM);}
    ('(' NONTERM {v.addArg($NONTERM.text);}
    (','  NONTERM {v.addArg($NONTERM.text);})*
    ')')?

    | CODE {v = new ValueToken($CODE.text, Type.CODE);}
    )
    {$array.add(v);}
    )+
    ;

grammar_name
    :
    'grammar' TERM ';'
    ;

TERM   : [A-Z][a-zA-Z0-9_.]*;
NONTERM  : [a-z$][a-zA-Z0-9_.]*;





REGEX : '"' .+? '"';
CODE : '{' .+? '}';

WS : [ \t\r\n] -> skip;