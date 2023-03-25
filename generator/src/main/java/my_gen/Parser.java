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

	public  Parser(String input) {
		lexer = new Lexer(input);
		nextToken();
	}

	public SumSub sumSub() {
		SumSub tree = new SumSub("sumSub");
		switch (lexer.getToken()) {
		case OPEN:
case NUMBER:
case SQRT:
{
MulDiv mulDiv = mulDiv();
tree.addChild(mulDiv);
SumSubPrime sumSubPrime = sumSubPrime(mulDiv.val);
tree.addChild(sumSubPrime);
		tree.val = sumSubPrime.val;
break;
}

		default:
		throw new RuntimeException("Unexpected token: " + lexer.getToken());
		}
		return tree;
	}

	public SumSubPrime sumSubPrime(Integer acc) {
		SumSubPrime tree = new SumSubPrime("sumSubPrime");
		switch (lexer.getToken()) {
		case SUM:
{
tree.addChild(new Tree(lexer.getTokenStr()));
String SUM = lexer.getTokenStr();
nextToken();
MulDiv mulDiv = mulDiv();
tree.addChild(mulDiv);
		tree.val = acc + mulDiv.val;
SumSubPrime sumSubPrime = sumSubPrime(tree.val);
tree.addChild(sumSubPrime);
		tree.val = sumSubPrime.val;
break;
}
case SUB:
{
tree.addChild(new Tree(lexer.getTokenStr()));
String SUB = lexer.getTokenStr();
nextToken();
MulDiv mulDiv = mulDiv();
tree.addChild(mulDiv);
		tree.val = acc - mulDiv.val;
SumSubPrime sumSubPrime = sumSubPrime(tree.val);
tree.addChild(sumSubPrime);
		tree.val = sumSubPrime.val;
break;
}
case END:
case CLOSE:
tree.val = acc;
break;
		default:
		throw new RuntimeException("Unexpected token: " + lexer.getToken());
		}
		return tree;
	}

	public MulDiv mulDiv() {
		MulDiv tree = new MulDiv("mulDiv");
		switch (lexer.getToken()) {
		case OPEN:
case NUMBER:
case SQRT:
{
Factor factor = factor();
tree.addChild(factor);
MulDivPrime mulDivPrime = mulDivPrime(factor.val);
tree.addChild(mulDivPrime);
		tree.val = mulDivPrime.val;
break;
}

		default:
		throw new RuntimeException("Unexpected token: " + lexer.getToken());
		}
		return tree;
	}

	public MulDivPrime mulDivPrime(Integer acc) {
		MulDivPrime tree = new MulDivPrime("mulDivPrime");
		switch (lexer.getToken()) {
		case MUL:
{
tree.addChild(new Tree(lexer.getTokenStr()));
String MUL = lexer.getTokenStr();
nextToken();
Factor factor = factor();
tree.addChild(factor);
		tree.val = acc * factor.val;
MulDivPrime mulDivPrime = mulDivPrime(tree.val);
tree.addChild(mulDivPrime);
		tree.val = mulDivPrime.val;
break;
}
case DIV:
{
tree.addChild(new Tree(lexer.getTokenStr()));
String DIV = lexer.getTokenStr();
nextToken();
Factor factor = factor();
tree.addChild(factor);
		tree.val = acc / factor.val;
MulDivPrime mulDivPrime = mulDivPrime(tree.val);
tree.addChild(mulDivPrime);
		tree.val = mulDivPrime.val;
break;
}
case SUM:
case SUB:
case END:
case CLOSE:
tree.val = acc;
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
{
tree.addChild(new Tree(lexer.getTokenStr()));
String OPEN = lexer.getTokenStr();
nextToken();
SumSub sumSub = sumSub();
tree.addChild(sumSub);
tree.addChild(new Tree(lexer.getTokenStr()));
String CLOSE = lexer.getTokenStr();
nextToken();
		tree.val = sumSub.val;
break;
}
case NUMBER:
{
tree.addChild(new Tree(lexer.getTokenStr()));
String NUMBER = lexer.getTokenStr();
nextToken();
		tree.val = Integer.parseInt(NUMBER);
break;
}
case SQRT:
{
tree.addChild(new Tree(lexer.getTokenStr()));
String SQRT = lexer.getTokenStr();
nextToken();
tree.addChild(new Tree(lexer.getTokenStr()));
String OPEN = lexer.getTokenStr();
nextToken();
SumSub sumSub = sumSub();
tree.addChild(sumSub);
tree.addChild(new Tree(lexer.getTokenStr()));
String CLOSE = lexer.getTokenStr();
nextToken();
		tree.val = (int) Math.sqrt(sumSub.val);
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

	public  class SumSub extends Tree {
public Integer val;
public SumSub (String node) {
              super(node);
        }
}

	public  class SumSubPrime extends Tree {
public Integer val;
public SumSubPrime (String node) {
              super(node);
        }
}

	public  class MulDiv extends Tree {
public Integer val;
public MulDiv (String node) {
              super(node);
        }
}

	public  class MulDivPrime extends Tree {
public Integer val;
public MulDivPrime (String node) {
              super(node);
        }
}

	public  class Factor extends Tree {
public Integer val;
public Factor (String node) {
              super(node);
        }
}

}