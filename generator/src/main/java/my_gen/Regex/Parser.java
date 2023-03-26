package my_gen.Regex;

import java.util.*;
import java.io.*;
import java.util.regex.*;
import utils.Tree;;

public class Parser {
	private final String EPS = "EPS";
	private final String END = "END";
	Lexer lexer;

	public  Parser(String input) {
		lexer = new Lexer(input);
		nextToken();
	}

	public Expr expr() {
		Expr tree = new Expr("expr");
		switch (lexer.getToken()) {
		case OPEN:
case VAR:
{
Factor factor = factor();
tree.addChild(factor);
ExprPrime exprPrime = exprPrime();
tree.addChild(exprPrime);
break;
}

		default:
		throw new RuntimeException("Unexpected token: " + lexer.getToken());
		}
		return tree;
	}

	public ExprPrime exprPrime() {
		ExprPrime tree = new ExprPrime("exprPrime");
		switch (lexer.getToken()) {
		case OR:
{
tree.addChild(new Tree(lexer.getTokenStr()));
String OR = lexer.getTokenStr();
nextToken();
Factor factor = factor();
tree.addChild(factor);
ExprPrime exprPrime = exprPrime();
tree.addChild(exprPrime);
break;
}
case END:
case CLOSE:
break;
		default:
		throw new RuntimeException("Unexpected token: " + lexer.getToken());
		}
		return tree;
	}

	public Factor factor() {
		Factor tree = new Factor("factor");
		switch (lexer.getToken()) {
		case OPEN:
case VAR:
{
Star star = star();
tree.addChild(star);
FactorPrime factorPrime = factorPrime();
tree.addChild(factorPrime);
break;
}

		default:
		throw new RuntimeException("Unexpected token: " + lexer.getToken());
		}
		return tree;
	}

	public FactorPrime factorPrime() {
		FactorPrime tree = new FactorPrime("factorPrime");
		switch (lexer.getToken()) {
		case OPEN:
case VAR:
{
Star star = star();
tree.addChild(star);
FactorPrime factorPrime = factorPrime();
tree.addChild(factorPrime);
break;
}
case OR:
case END:
case CLOSE:
break;
		default:
		throw new RuntimeException("Unexpected token: " + lexer.getToken());
		}
		return tree;
	}

	public Star star() {
		Star tree = new Star("star");
		switch (lexer.getToken()) {
		case OPEN:
case VAR:
{
Value value = value();
tree.addChild(value);
StarPrime starPrime = starPrime();
tree.addChild(starPrime);
break;
}

		default:
		throw new RuntimeException("Unexpected token: " + lexer.getToken());
		}
		return tree;
	}

	public StarPrime starPrime() {
		StarPrime tree = new StarPrime("starPrime");
		switch (lexer.getToken()) {
		case STAR:
{
tree.addChild(new Tree(lexer.getTokenStr()));
String STAR = lexer.getTokenStr();
nextToken();
StarPrime starPrime = starPrime();
tree.addChild(starPrime);
break;
}
case OPEN:
case VAR:
case OR:
case END:
case CLOSE:
break;
		default:
		throw new RuntimeException("Unexpected token: " + lexer.getToken());
		}
		return tree;
	}

	public Value value() {
		Value tree = new Value("value");
		switch (lexer.getToken()) {
		case OPEN:
{
tree.addChild(new Tree(lexer.getTokenStr()));
String OPEN = lexer.getTokenStr();
nextToken();
Expr expr = expr();
tree.addChild(expr);
tree.addChild(new Tree(lexer.getTokenStr()));
String CLOSE = lexer.getTokenStr();
nextToken();
break;
}
case VAR:
{
tree.addChild(new Tree(lexer.getTokenStr()));
String VAR = lexer.getTokenStr();
nextToken();
break;
}

		default:
		throw new RuntimeException("Unexpected token: " + lexer.getToken());
		}
		return tree;
	}

	private void nextToken() {
		lexer.nextToken();
	}

	public class Expr extends Tree {
public Expr(String node) { super(node);}
}

	public class ExprPrime extends Tree {
public ExprPrime(String node) { super(node);}
}

	public class Factor extends Tree {
public Factor(String node) { super(node);}
}

	public class FactorPrime extends Tree {
public FactorPrime(String node) { super(node);}
}

	public class Star extends Tree {
public Star(String node) { super(node);}
}

	public class StarPrime extends Tree {
public StarPrime(String node) { super(node);}
}

	public class Value extends Tree {
public Value(String node) { super(node);}
}

}