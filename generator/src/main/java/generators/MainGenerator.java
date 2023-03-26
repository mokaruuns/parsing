package generators;

import gen.MetaBaseListener;
import gen.MetaParser;
import utils.NonTerm;
import utils.Term;
import utils.Type;
import utils.ValueToken;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class MainGenerator extends MetaBaseListener {
    private final String EPS = "EPS";
    private final String END = "END";

    private final ArrayList<NonTerm> nonTerms = new ArrayList<>();
    private final ArrayList<Term> terms = new ArrayList<>();
    private String start = "";
    private final LinkedHashMap<String, LinkedHashSet<String>> first = new LinkedHashMap<>();
    private final LinkedHashMap<String, LinkedHashSet<String>> follow = new LinkedHashMap<>();

    private final String grammarName;

    private final Path dirPath = Paths.get("src/main/java/my_gen");


    public MainGenerator(String grammarName) {
        super();
        this.grammarName = grammarName;
    }

    @Override
    public void exitStart(MetaParser.StartContext ctx) {
        init();
        generateTypeToken();
        generateLexer();
        generateParser();
    }

    private void generateTypeToken() {
        TypeTokenGenerator typeTokenGenerator = new TypeTokenGenerator("my_gen." + grammarName, "TypeToken", "enum");
        typeTokenGenerator.generateTypeToken(terms);
        typeTokenGenerator.writeToFile(dirPath.resolve(grammarName), "TypeToken.java");
    }

    private void generateTree() {
        TreeGenerator treeGenerator = new TreeGenerator("my_gen." + grammarName, "Tree", "class");
        treeGenerator.generateTree();
        treeGenerator.writeToFile(dirPath.resolve(grammarName), "Tree.java");

    }

    private void generateLexer() {
        LexerGenerator lexerGenerator = new LexerGenerator("my_gen." + grammarName, "Lexer", "class");
        lexerGenerator.generateLexer(terms);
        lexerGenerator.writeToFile(dirPath.resolve(grammarName), "Lexer.java");
    }

    private void generateParser() {
        ParserGenerator parserGenerator = new ParserGenerator("my_gen." + grammarName, "Parser", "class");
        parserGenerator.generateParser(nonTerms, terms, first, follow, start);
        parserGenerator.writeToFile(dirPath.resolve(grammarName), "Parser.java");
    }

    private void init() {
        for (NonTerm nonTerm : nonTerms) {
            first.put(nonTerm.name(), new LinkedHashSet<>());
            follow.put(nonTerm.name(), new LinkedHashSet<>());
            if (start == null || start.length() == 0) {
                start = nonTerm.name();
            }
        }

        generateFirst();
        generateFollow();
    }

    private void printNonTermInfo() {
        for (NonTerm nonTerm : nonTerms) {
            System.out.println(nonTerm.name() + " -> " + first.get(nonTerm.name()) + " -> " + follow.get(nonTerm.name()));
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
                        if (token.getType().equals(Type.TERM) || token.getType().equals(Type.CODE)) {
                            continue;
                        }
                        LinkedHashSet<String> newlst = getFirstByRightPart(new ArrayList<>(alternatives.subList(i + 1, alternatives.size())));
                        if (newlst.remove(EPS)) {
                            newlst.addAll(follow.get(nonTerm.name()));
                        }
                        changed |= follow.get(token.getName()).addAll(newlst);
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
