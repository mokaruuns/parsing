package generators;

import java.util.List;

public class TreeGenerator extends ClassPrinter {
    public TreeGenerator(String packageName, String className, String type) {
        super(packageName, className, type);
    }

    public void generateTree() {
        addImport("java.util.ArrayList");
        addImport("java.util.List");
        addField("String node");
        addField("List<Tree> children");
        addConstructor(new Method(className, "public", "", List.of("String node", "Tree... children"), List.of("this.node = node;", "this.children = List.of(children);")));
        addConstructor(new Method(className, "public", "", List.of("String node"), List.of("this.node = node;", "this.children = new ArrayList<>();")));
        addMethod(new Method("addChild", "public", "void", List.of("Tree child"), List.of("if (child != null) {", "\tchildren.add(child);", "}")));
        addMethod(new Method("toString", "public", "String", List.of(), List.of("if (children == null || children.isEmpty()) {", "\treturn node;", "} else {", "\tArrayList<String> childrenStrings = new ArrayList<>();", "\tfor (Tree child : children) {", "\t\tchildrenStrings.add(child.toString());", "\t}", "\treturn node + \"(\" + String.join(\", \", childrenStrings) + \")\";", "}")));
        addMethod(new Method("getChildren", "public", "List<Tree>", List.of(), List.of("return children;")));
        addMethod(new Method("getNode", "public", "String", List.of(), List.of("return node;")));
        addMethod(new Method("setNode", "public", "void", List.of("String s"), List.of("this.node = s;")));
    }
}