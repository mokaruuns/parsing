import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import gen.*;
import grammar.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        testParse();
    }

    private static void testParse() {
        Path path = Paths.get("src/main/antlr/Math.mg4");
        try {
            MetaLexer lexer = new MetaLexer(CharStreams.fromPath(path));
            MetaParser parser = new MetaParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.start();
            MetaBaseVisitor<String> visitor = new MetaBaseVisitor<>();
//            String result = visitor.visit(tree).;
            ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
            parseTreeWalker.walk(new MainGenerator(), tree);


            System.out.println(tree.toStringTree(parser));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

