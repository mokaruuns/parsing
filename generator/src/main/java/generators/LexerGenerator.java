package generators;

import utils.Term;

import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.stream.Collectors;

public class LexerGenerator extends ClassPrinter {

    public LexerGenerator(String packageName, String className, String type) {
        super(packageName, className, type);
    }

    public void generateLexer(ArrayList<Term> terms) {
        addImport("java.util.regex.Matcher");
        addImport("java.util.regex.Pattern");
        String patternExpr = terms.stream().map(term -> term.value().substring(1, term.value().length() - 1)).collect(Collectors.joining("|"));
        addField("private Pattern PATTERN_EXPRESSION = Pattern.compile(\"" + patternExpr + "\")");
        addField("private final Matcher tokenMatcher");
        addField("private TypeToken curToken");
        addField("private String curTokenStr");

        addConstructor(new Method(className, "public", "", List.of("String expression"), List.of("this.tokenMatcher = PATTERN_EXPRESSION.matcher(expression);")));
        addMethod(new Method("nextToken", "public", "void", List.of(),
                List.of("while (tokenMatcher.find()) {",
                        "if (Character.isWhitespace(tokenMatcher.group().charAt(0))) {",
                        "continue;",
                        "}",
                        "for (var typeToken : TypeToken.values()) {",
                        "String tokenStr = tokenMatcher.group();",
                        "if (typeToken.match(tokenStr)) {",
                        "curToken = typeToken;",
                        "curTokenStr = tokenStr;",
                        "return;",
                        "}",
                        "}",
                        "}",
                        "curToken = TypeToken.END;")));
        addMethod(new Method("toString", "public", "String", List.of(), List.of("return curToken.toString();")));
        addMethod(new Method("getToken", "public", "TypeToken", List.of(), List.of("return curToken;")));
        addMethod(new Method("getTokenStr", "public", "String", List.of(), List.of("return curTokenStr;")));
    }

}