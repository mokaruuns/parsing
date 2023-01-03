grammar Grammar;

math returns [MathFormula formula_]
    : '$' equation '$' { $formula_ = new MathFormula($equation.items_) };

equation returns [List<MathItem> items_]
    @init { $items_ = new ArrayList<MathItem>(); }
    : (mathItem { $items_.add($mathItem.item_); })*;

mathItem returns [MathItem item_] :
    string { $item_ = $string.text_; } |
    mathSymbol { $item_ = $mathSymbol.item_; };

string returns [String text_]: STRING { $text_ = $STRING.text; };

mathSymbol returns [MathItem item_]: greek { $item_ = new MathSymbol($greek.text); };

WS            : [ \t\r\n]+ -> skip ;
STRING        : ~[ _^\\\t\r\n{}$]+ ;


greek :	'\\Gamma' | '\\Delta'  | '\\Theta'   | '\\Lambda' | '\\Pi'
      | '\\Sigma' | '\\Phi'    | '\\Psi'     | '\\Omega'  | '\\alpha' | '\\beta'
      | '\\gamma' | '\\delta'  | '\\epsilon' | '\\eta'    | '\\theta' | '\\iota'
      | '\\kappa' | '\\lambda' | '\\mugreek' | '\\nu'     | '\\xi'    | '\\pi'  | '\\rho'
      | '\\sigma' | '\\tau'    | '\\upsilon' | '\\phi'    | '\\chi'   | '\\psi' | '\\omega' ;
