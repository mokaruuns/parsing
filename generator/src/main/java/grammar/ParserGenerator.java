package grammar;

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
        addField("private final String EPS = \"EPS\"");
        addField("private final String END = \"END\"");
        addField("Lexer lexer");

        addConstructor(new Method("parse", "public", "Tree",
                        List.of("String input"),
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

        addMethod(new Method("nextToken", "private", "void",
                        new ArrayList<>(),
                        List.of("lexer.nextToken();")
                )
        );
        generateReturns(nonTerms);

    }


    public LinkedHashSet<String> getFirstByRightPart(ArrayList<ValueToken> rightPart, LinkedHashMap<String, LinkedHashSet<String>> first) {
        LinkedHashSet<String> result = new LinkedHashSet<>();
        boolean eps = true;
        for (ValueToken token : rightPart) {
            if (token.type().equals(Type.CODE)) {
                continue;
            }
            if (token.type().equals(Type.TERM)) {
                result.add(token.name());
            } else {
                result.addAll(first.get(token.name()));
            }
            eps = false;
            break;
        }
        if (eps) {
            result.add("EPS");
        }
        return result;
    }

    public String generateCases(NonTerm nonTerm, LinkedHashMap<String, LinkedHashSet<String>> first, LinkedHashMap<String, LinkedHashSet<String>> follow) {
        StringBuilder sb = new StringBuilder();
        List<ValueToken> rightPartWithEps = null;
        for (ArrayList<ValueToken> alternatives : nonTerm.getAlternatives()) {
            LinkedHashSet<String> firstSet = getFirstByRightPart(alternatives, first);
            if (firstSet.contains("EPS")) {
                rightPartWithEps = alternatives;
                continue;
            }
            for (String token : firstSet) {
                sb.append("case ").append(token).append(":\n");
            }
            generateCase(sb, alternatives);
        }
        if (rightPartWithEps != null) {
            for (String token : follow.get(nonTerm.name())) {
                sb.append("case ").append(token).append(":\n");
            }
            sb.append("// lol");
            generateCase(sb, rightPartWithEps);
        }

        return sb.toString();
    }

    private void generateCase(StringBuilder sb, List<ValueToken> rightPart) {
        for (ValueToken token : rightPart) {
            if (token.type().equals(Type.CODE)) {
                sb.append("// ").append(token.name()).append("\n");
            } else if (token.type().equals(Type.TERM)) {
                System.out.println("tree.addChild(" + "new Tree(\"" + token.name() + "\")\n");
                sb.append("tree.addChild(").append("new Tree(lexer.getTokenStr())").append(");");
                sb.append("nextToken();\n");
            } else {
                sb.append("tree.addChild(").append(token.name()).append("());\n");
            }
        }
        sb.append("break;\n");
    }

    public void writeToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/my_gen/Parser.java"))) {
            writer.write(toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String toUpperFirstLetter(String s) {
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }

    public void generateReturns(ArrayList<NonTerm> nonTerms) {
        for (NonTerm nonTerm : nonTerms) {
            addClass(new Class(toUpperFirstLetter(nonTerm.name()), "private", nonTerm.getReturnValue().type(), nonTerm.getReturnValue().name()));
        }
    }


}
