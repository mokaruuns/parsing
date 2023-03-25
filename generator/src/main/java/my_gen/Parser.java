package my_gen;

import java.util.*;
import java.io.*;
import java.util.regex.*;
import my_gen.Tree;
import my_gen.Lexer;

public class Parser {
	private final String EPS = "EPS";
	private final String END = "END";
	Lexer lexer;

	public Tree parse(String input) {
		lexer = new Lexer(input);
		lexer.nextToken();
		Tree tree = expr();
		return tree;
	}

	private Tree expr() {
		Tree tree = new Tree("expr");
		switch (lexer.getToken()) {
		case OPEN:
case NUMBER:
tree.addChild(term());
tree.addChild(exprPrime());
break;

		default:
		throw new RuntimeException("Unexpected token: " + lexer.getToken());
		}
		return tree;
	}

	private Tree exprPrime() {
		Tree tree = new Tree("exprPrime");
		switch (lexer.getToken()) {
		case SUM:
tree.addChild(new Tree(lexer.getTokenStr()));nextToken();
tree.addChild(term());
tree.addChild(exprPrime());
break;
case SUB:
tree.addChild(new Tree(lexer.getTokenStr()));nextToken();
tree.addChild(term());
tree.addChild(exprPrime());
// {$val = 0;}
break;
case END:
case CLOSE:
// loltree.addChild(new Tree(lexer.getTokenStr()));nextToken();
break;

		default:
		throw new RuntimeException("Unexpected token: " + lexer.getToken());
		}
		return tree;
	}

	private Tree term() {
		Tree tree = new Tree("term");
		switch (lexer.getToken()) {
		case OPEN:
case NUMBER:
tree.addChild(factor());
tree.addChild(termPrime());
break;

		default:
		throw new RuntimeException("Unexpected token: " + lexer.getToken());
		}
		return tree;
	}

	private Tree termPrime() {
		Tree tree = new Tree("termPrime");
		switch (lexer.getToken()) {
		case MUL:
tree.addChild(new Tree(lexer.getTokenStr()));nextToken();
tree.addChild(factor());
tree.addChild(termPrime());
break;
case DIV:
tree.addChild(new Tree(lexer.getTokenStr()));nextToken();
tree.addChild(factor());
tree.addChild(termPrime());
break;
case SUM:
case SUB:
case END:
case CLOSE:
// loltree.addChild(new Tree(lexer.getTokenStr()));nextToken();
break;

		default:
		throw new RuntimeException("Unexpected token: " + lexer.getToken());
		}
		return tree;
	}

	private Tree factor() {
		Tree tree = new Tree("factor");
		switch (lexer.getToken()) {
		case OPEN:
tree.addChild(new Tree(lexer.getTokenStr()));nextToken();
tree.addChild(expr());
tree.addChild(new Tree(lexer.getTokenStr()));nextToken();
break;
case NUMBER:
tree.addChild(new Tree(lexer.getTokenStr()));nextToken();
break;

		default:
		throw new RuntimeException("Unexpected token: " + lexer.getToken());
		}
		return tree;
	}

	private void nextToken() {
		lexer.nextToken();
	}

	private  class Expr extends Tree {
private Integer val;
private Expr (String node) {
              super(node);
        }
}

	private  class ExprPrime extends Tree {
private Integer val;
private ExprPrime (String node) {
              super(node);
        }
}

	private  class Term extends Tree {
private Integer val;
private Term (String node) {
              super(node);
        }
}

	private  class TermPrime extends Tree {
private Integer val;
private TermPrime (String node) {
              super(node);
        }
}

	private  class Factor extends Tree {
private Integer val;
private Factor (String node) {
              super(node);
        }
}

}