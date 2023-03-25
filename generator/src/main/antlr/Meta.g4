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
    (returnedValue {$nt.setReturnValue($returnedValue.rValue);})?
    ':'
    right {$nt.addAlternative($right.array);}
    ('|' right {$nt.addAlternative($right.array);})*
    ';'
    ;


returnedValue returns [ReturnValue rValue]
    :
    'returns' '[' TERM NONTERM ']' {$rValue = new ReturnValue($TERM.text, $NONTERM.text);}
    ;

right returns[ArrayList<ValueToken> array]
    :
    {$array = new ArrayList();}
    (TERM {$array.add(new ValueToken($TERM.text, Type.TERM));}
    | NONTERM {$array.add(new ValueToken($NONTERM.text, Type.NON_TERM));}
    | CODE {$array.add(new ValueToken($CODE.text, Type.CODE));}
    )+
    ;

grammar_name
    :
    'grammar' TERM ';'
    ;

TERM   : [A-Z][a-zA-Z0-9_]*;
NONTERM  : [a-z][a-zA-Z0-9_]*;



REGEX : '"' .+? '"';
CODE : '{' .+? '}';


VARIABLE : [a-z][a-zA-Z0-9_]*;
WS : [ \t\r\n] -> skip;