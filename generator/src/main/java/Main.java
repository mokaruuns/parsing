import generators.MainGenerator;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import gen.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    private static final Path grammarDirPath = Paths.get("src/main/antlr");

    public static void main(String[] args) {
        generateFromMeta("Math");
        generateFromMeta("Regex");
    }

    private static void generateFromMeta(String grammarName) {
        try {
            Path grammarPath = grammarDirPath.resolve(grammarName);
            MetaLexer lexer = new MetaLexer(CharStreams.fromPath(grammarPath));
            MetaParser parser = new MetaParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.start();
            ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
            parseTreeWalker.walk(new MainGenerator(grammarName), tree);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

