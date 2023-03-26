package tests.math;

import my_gen.Lexer;
import my_gen.TypeToken;
import org.testng.annotations.Test;

import java.util.List;

public class MathLexerTest {

    @Test
    public void simpleTest() {
        Lexer lexer = new Lexer("1 + 2");
        lexer.nextToken();
        List<TypeToken> tokens = List.of(TypeToken.NUMBER, TypeToken.SUM, TypeToken.NUMBER);
        arrayCheck(tokens, lexer);
    }

    @Test
    public void complexTest() {
        Lexer lexer = new Lexer("1 + 2 * 3");
        lexer.nextToken();
        List<TypeToken> tokens = List.of(TypeToken.NUMBER, TypeToken.SUM, TypeToken.NUMBER, TypeToken.MUL, TypeToken.NUMBER);
        arrayCheck(tokens, lexer);
    }

    @Test
    public void bracketsTest() {
        Lexer lexer = new Lexer("1 + (2 * 3)");
        lexer.nextToken();
        List<TypeToken> tokens = List.of(TypeToken.NUMBER, TypeToken.SUM, TypeToken.OPEN, TypeToken.NUMBER, TypeToken.MUL, TypeToken.NUMBER, TypeToken.CLOSE);
        arrayCheck(tokens, lexer);
    }


    public void arrayCheck(List<TypeToken> tokens, Lexer lexer) {
        for (TypeToken token : tokens) {
            assert lexer.getToken() == token;
            lexer.nextToken();
        }
    }

}
