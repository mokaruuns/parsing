package tests;

import graph.Graph;
import utils.Tree;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;

public class Tester {
    private Path dirPath;

    public void generateGraph(Tree tree, String initialString) {
        Graph graph = new Graph(tree, initialString);
        graph.build();
        graph.toDotFile(dirPath, replaceForbiddenChars(initialString) + ".gv");
    }

    public String replaceForbiddenChars(String filename) {
        String regex = "[\\\\/:*?\"<>|]";
        String replacement = "_";
        return filename.replaceAll(regex, replacement);
    }

    public void setDirPath(Path dirPath) {
        this.dirPath = dirPath;
    }
}
