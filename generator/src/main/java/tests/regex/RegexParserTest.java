package tests.regex;

import graph.Graph;

import my_gen.Regex.Parser;
import org.testng.annotations.Test;
import tests.Tester;
import utils.Tree;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;

public class RegexParserTest extends Tester {

    @Test
    public void factorTest() {
        this.setDirPath(Paths.get("dot/regex"));
        draw("a");
    }
    @Test
    public void orTest() {
        this.setDirPath(Paths.get("dot/regex"));
        draw("a|b");
    }

    @Test
    public void andTest() {
        this.setDirPath(Paths.get("dot/regex"));
        draw("ab");
    }

    @Test
    public void bracketTest() {
        draw("(a)");
    }

    @Test
    public void starTest() {
        draw("a*");
    }

    @Test
    public void hardTest1() {
        draw("a|b|(cde)*");
    }

    @Test
    public void hardTest2() {
        draw("(a|b)|(c*de)");
    }


    private void draw(String expression) {
        this.setDirPath(Paths.get("dot/regex"));
        Parser actual = new Parser(expression);
        Parser.Expr expr = actual.expr();
        generateGraph(expr, expression);
    }
}
