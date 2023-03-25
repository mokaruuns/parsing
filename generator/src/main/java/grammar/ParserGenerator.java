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

        addConstructor(new Method("Parser", "public", "", List.of("String input"),
                List.of("lexer = new Lexer(input);", "nextToken();")));
        for (NonTerm nonTerm : nonTerms) {
            String className = toUpperFirstLetter(nonTerm.name());
            addMethod(
                    new Method(nonTerm.name(),
                            "public",
                            className,
                            nonTerm.getArgsString(),
                            List.of(className + " tree = new " + className + "(\"" + nonTerm.name() + "\");",
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
            if (token.getType().equals(Type.CODE)) {
                continue;
            }
            if (token.getType().equals(Type.TERM)) {
                result.add(token.getName());
            } else {
                result.addAll(first.get(token.getName()));
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
//            sb.append("// lol");
//            generateCase(sb, rightPartWithEps);
            sb.append("tree.val = acc;\n");
            sb.append("break;");
//            sb.append("// ke");
        }
        return sb.toString();
    }

    private void generateCase(StringBuilder sb, List<ValueToken> rightPart) {
        sb.append("{\n");
        for (ValueToken token : rightPart) {
            if (token.getType().equals(Type.CODE)) {
//                Systetem.out.println(normalizeCode(token.getName(), "tree."));
                sb.append("\t\t").append(normalizeCode(token.getName())).append("\n");
            } else if (token.getType().equals(Type.TERM)) {
                sb.append("tree.addChild(").append("new Tree(lexer.getTokenStr())").append(");\n");
                sb.append("String ").append(token.getName()).append(" = ").append("lexer.getTokenStr();\n");
                sb.append("nextToken();\n");
            } else {
                sb.append(toUpperFirstLetter(token.getName())).append(" ").append(token.getName()).append(" = ").append(token.getName()).append("(").append(String.join(", ", token.getArgs())).append(");\n");
                sb.append("tree.addChild(").append(token.getName()).append(");\n");
            }
        }
        sb.append("break;\n");
        sb.append("}\n");
    }

    private String normalizeCode(String code) {
        code = code.substring(1, code.length() - 1);
        return code.replace("$", "tree.");

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
            addClass(new Class(toUpperFirstLetter(nonTerm.name()), "public", nonTerm.getReturnValue().type(), nonTerm.getReturnValue().name()));
        }
    }


}
