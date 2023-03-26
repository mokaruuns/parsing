package tests.math;

import my_gen.Math.Parser;
import org.testng.annotations.Test;
import tests.Tester;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;

public class MathParserTest extends Tester {

    private static final Path dirPath = Paths.get("/dot/parser");

    @Test
    public void sumTest() {
        String expression = "1 + 2";
        test(expression, 3);
    }

    @Test
    public void subTest() {
        String expression = "10 - 2";
        test(expression, 8);
    }

    @Test
    public void mulTest() {
        String expression = "10 * 2";
        test(expression, 20);
    }

    @Test
    public void divTest() {
        String expression = "10 / 2";
        test(expression, 5);
    }

    @Test
    public void bracketsTest() {
        String expression = "10 - (40 - 30)";
        test(expression, 0);
    }


    private void assertValue(Integer expected, Integer actual) {
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        assert expected.equals(actual);
    }

    private void test(String expression, Integer expected) {
        System.out.println("expr: " + expression);
        this.setDirPath(Paths.get("dot/math"));
        Parser actual = new Parser(expression);
        Parser.SumSub sumSub = actual.sumSub();
        generateGraph(sumSub, expression);
        assertValue(expected, sumSub.val);
    }

}
