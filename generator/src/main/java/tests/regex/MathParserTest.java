package tests.regex;

import graph.Graph;
import my_gen.Lexer;
import my_gen.Parser;
import my_gen.Tree;
import org.testng.annotations.Test;

import java.text.ParseException;

public class MathParserTest {
    @Test
    public void simpleTest() throws ParseException {
        String expression = "a|b|(cd)*";
        Parser actual = new Parser(expression);
        Parser.Expr expr = actual.expr();
        System.out.println(actual.toString());
        generateGraph(expr, expression);

    }


    private void checkTree(Tree expected, Tree actual) {
        assert expected.getNode().equals(actual.getNode());
        assert expected.getChildren().size() == actual.getChildren().size();
        for (int i = 0; i < expected.getChildren().size(); i++) {
            checkTree(expected.getChildren().get(i), actual.getChildren().get(i));
        }
    }

    public static void generateGraph(Tree tree, String initialString) throws ParseException {
        Graph graph = new Graph(tree, initialString);
        graph.build();

        graph.toDotFile("dot/graph-" + initialString.hashCode() + ".gv");
    }
}
