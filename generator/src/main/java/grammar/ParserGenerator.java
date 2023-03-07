package grammar;

import org.jetbrains.kotlin.codegen.ValueKind;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class ParserGenerator extends ClassPrinter {
    public ParserGenerator(String packageName, String className) {
        super(packageName, className);
    }

    public void generateParser(ArrayList<NonTerm> nonTerms, ArrayList<Term> terms, LinkedHashMap<String, LinkedHashSet<String>> first, LinkedHashMap<String, LinkedHashSet<String>> follow, String start) {
        addImports("java.util.*", "java.io.*", "java.util.regex.*", "my_gen.Tree", "my_gen.Lexer");
        addField("private final String EPS = \"EPSILON\"");
        addField("private final String END = \"END\"");
        addField("Lexer lexer");

        addConstructor(new Method("parse", "public", "Tree",
                        List.of("String input", "Lexer lexer"),
                        List.of("lexer = new Lexer(input);",
                                "lexer.nextToken();",
                                "Tree tree = " + start + "();",
                                "return tree;")
                )
        );
        for (NonTerm nonTerm : nonTerms) {
            addMethod(new Method(nonTerm.name(), "private", "Tree",
                            new ArrayList<>(),
                            List.of("Tree tree = new Tree(\"" + nonTerm.name() + "\");",
                                    "switch (lexer.getToken()) {",
                                    generateCases(nonTerm, first, follow),
                                    "default:",
                                    "throw new RuntimeException(\"Unexpected token: \" + lexer.getToken());",
                                    "}",
                                    "return tree;")
                    )
            );
        }


    }


    public LinkedHashSet<String> getFirstByRightPart(ArrayList<ValueToken> rightPart, LinkedHashMap<String, LinkedHashSet<String>> first) {
        LinkedHashSet<String> result = new LinkedHashSet<>();
        boolean eps = true;
        for (ValueToken token : rightPart) {
            if (token.type().equals(Type.CODE)) {
                continue;
            }
            if (token.type().equals(Type.TERM)) {
                result.add(token.text());
            } else {
                result.addAll(first.get(token.text()));
            }
            eps = false;
            break;
        }
        if (eps) {
            result.add("EPS");
        }
        return result;
    }

    private String generateCase(List<ValueToken> rightPart) {
        StringBuilder sb = new StringBuilder();
        for (ValueToken token : rightPart) {
            if (token.type() == Type.CODE) {
                sb.append("// code");
            } else if (token.type() == Type.TERM) {
                sb.append("nextToken();").append(System.lineSeparator());
            } else {
                sb.append(token.text()).append("();").append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public String generateCases(NonTerm nonTerm, LinkedHashMap<String, LinkedHashSet<String>> first, LinkedHashMap<String, LinkedHashSet<String>> follow) {
        StringBuilder sb = new StringBuilder();
        ArrayList<ValueToken> rightPartWithEps = null;
        for (ArrayList<ValueToken> rightPart : nonTerm.getAlternatives()) {
            HashSet<String> firstByRightPart = getFirstByRightPart(rightPart, first);
            System.out.println(nonTerm.name() + " " + firstByRightPart);
            if (firstByRightPart.contains("EPS")) {
                rightPartWithEps = rightPart;
                continue;
            }
            for (String firstToken : firstByRightPart) {
                sb.append("case ").append(firstToken).append(":").append(System.lineSeparator());
            }
            sb.append(generateCase(rightPart)).append(System.lineSeparator());
        }
        if (rightPartWithEps != null) {
            for (String followToken : follow.get(nonTerm.name())) {
                sb.append("case ").append(followToken).append(":").append(System.lineSeparator());
            }
            sb.append(generateCase(rightPartWithEps)).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public void writeToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/my_gen/Parser.java"))) {
            writer.write(toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
