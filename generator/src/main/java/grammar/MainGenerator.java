package grammar;

import gen.MetaBaseListener;
import gen.MetaParser;

import java.util.*;
import java.util.stream.Collectors;

public class MainGenerator extends MetaBaseListener {
    private final String EPS = "EPS";
    private final String END = "END";

    private final ArrayList<NonTerm> nonTerms = new ArrayList<>();
    private final ArrayList<Term> terms = new ArrayList<>();
    private String start = "";
    private final LinkedHashMap<String, LinkedHashSet<String>> first = new LinkedHashMap<>();
    private final LinkedHashMap<String, LinkedHashSet<String>> follow = new LinkedHashMap<>();

    @Override
    public void exitStart(MetaParser.StartContext ctx) {
        init();

//        for (Term term : terms) {
//            System.out.println(term.name() + " " + term.value());
//        }
//
//        for (NonTerm nonTerm : nonTerms) {
//            System.out.println(nonTerm.name() + " "
//                    + nonTerm.getAlternatives().stream().map(rules -> rules.stream().map(ValueToken::text).collect(Collectors.joining(" "))).collect(Collectors.joining(" | "))
//                    );
//        }

        generateFirst();
        generateFollow();

        for (NonTerm nonTerm : nonTerms) {
            System.out.println(nonTerm.name() + " -> " + first.get(nonTerm.name()) + " -> " + follow.get(nonTerm.name()));
        }

        TypeTokenGenerator typeTokenGenerator = new TypeTokenGenerator();
        typeTokenGenerator.generateTypeToken(terms);

        TreeGenerator treeGenerator = new TreeGenerator("my_gen", "Tree");
        treeGenerator.generateTree();
        treeGenerator.writeToFile("src/main/java/my_gen/Tree.java");

        LexerGenerator lexerGenerator = new LexerGenerator("my_gen", "Lexer");
        lexerGenerator.generateLexer(terms);
        lexerGenerator.writeToFile("src/main/java/my_gen/Lexer.java");

        ParserGenerator parserGenerator = new ParserGenerator("my_gen", "Parser");
        parserGenerator.generateParser(nonTerms, terms, first, follow, start);
        parserGenerator.writeToFile("src/main/java/my_gen/Parser.java");
    }

    private void init() {
        for (NonTerm nonTerm : nonTerms) {
            first.put(nonTerm.name(), new LinkedHashSet<>());
            follow.put(nonTerm.name(), new LinkedHashSet<>());
            if (start == null || start.length() == 0) {
                start = nonTerm.name();
            }
        }
    }


    private void generateFollow() {
        boolean changed = true;

        follow.get(start).add(END);

        while (changed) {
            changed = false;

            for (NonTerm nonTerm : nonTerms) {
                for (ArrayList<ValueToken> alternatives : nonTerm.getAlternatives()) {
                    for (int i = 0; i < alternatives.size(); i++) {
                        ValueToken token = alternatives.get(i);
                        if (token.type().equals(Type.TERM) || token.type().equals(Type.CODE)) {
                            continue;
                        }
                        LinkedHashSet<String> newlst = getFirstByRightPart(new ArrayList<>(alternatives.subList(i + 1, alternatives.size())));
                        if (newlst.remove(EPS)) {
                            newlst.addAll(follow.get(nonTerm.name()));
                        }
                        changed |= follow.get(token.text()).addAll(newlst);
                    }
                }
            }
        }
    }


    private void generateFirst() {
        boolean changed = true;
        while (changed) {
            changed = false;
            for (NonTerm nonTerm : nonTerms) {
                for (ArrayList<ValueToken> alternatives : nonTerm.getAlternatives()) {
                    LinkedHashSet<String> newlst = getFirstByRightPart(alternatives);
                    if (!first.get(nonTerm.name()).containsAll(newlst)) {
                        first.get(nonTerm.name()).addAll(newlst);
                        changed = true;
                    }
                }
            }
        }
    }

    public LinkedHashSet<String> getFirstByRightPart(ArrayList<ValueToken> rightPart) {
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
            result.add(EPS);
        }
        return result;
    }

    @Override
    public void exitNonTerm(MetaParser.NonTermContext ctx) {
        nonTerms.add(ctx.nt);
    }

    @Override
    public void exitTerm(MetaParser.TermContext ctx) {
        terms.add(ctx.t);
    }
}
