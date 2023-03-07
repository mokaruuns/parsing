grammar Regex;

expr : factor exprPrime;

exprPrime : '|' factor exprPrime
            | epsilon;

factor : star factorPrime;

factorPrime : star factorPrime
              | epsilon;
              
star : value starPrime;

starPrime : '*' starPrime
             | epsilon;

epsilon: ;

value : '(' expr ')' | VAR;

VAR : [a-zA-Z];




             

