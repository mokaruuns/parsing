package grammar;

import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.stream.Collectors;

public class LexerGenerator extends ClassPrinter {

    public LexerGenerator(String packageName, String className) {
        super(packageName, className);
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

    public void writeToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/java/my_gen/Lexer.java"))) {
//            bufferedWriter.write("""
//                    package my_gen;
//
//                    import java.util.regex.Matcher;
//                    import java.util.regex.Pattern;
//
//                    public class Lexer {
//                    """);
//
//
//
//            bufferedWriter.write(String.format("\tprivate final static Pattern PATTERN_EXPRESSION = Pattern.compile(\"%s\");\n", patternExpr));
//
//            bufferedWriter.write("""
//                    private final Matcher tokenMatcher;
//
//                        private TypeToken curToken;
//
//                        public Lexer(String expression) {
//                            this.tokenMatcher = PATTERN_EXPRESSION.matcher(expression);
//                        }
//
//                        public void nextToken() {
//                            while (tokenMatcher.find()) {
//
//                                if (Character.isWhitespace(tokenMatcher
//                                        .group()
//                                        .charAt(0))
//                                ) {
//                                    continue;
//                                }
//
//                                for (var typeToken : TypeToken.values()) {
//                                    String tokenStr = tokenMatcher.group();
//                                    if (typeToken.match(tokenStr)) {
//                                        curToken = typeToken;
//                                        return;
//                                    }
//                                }
//
//                            }
//
//                            curToken = TypeToken.END;
//                        }
//
//                        public TypeToken getToken() {
//                            return curToken;
//                        }
//                    }
//                    """);
//
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

}
