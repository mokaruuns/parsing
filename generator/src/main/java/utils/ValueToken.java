package utils;

import java.util.ArrayList;

public class ValueToken {
    private final String name;
    private final Type type;
    private final ArrayList<String> args = new ArrayList<>();

    public ValueToken(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public ArrayList<String> getArgs() {
        return args;
    }

    public void addArg(String arg) {
        args.add(normalizeArg(arg));
    }

    private String normalizeArg(String arg) {
        return arg.replace("$", "tree.");
    }
}


