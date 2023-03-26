package utils;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class NonTerm {
    private final ArrayList<ArrayList<ValueToken>> alternatives;
    private ExtraValue returnValue;
    private ArrayList<ExtraValue> args = new ArrayList<>();
    private final String name;


    public NonTerm(String name) {
        this.name = name;
        this.alternatives = new ArrayList<>();
    }

    public void addAlternative(ArrayList<ValueToken> rule) {
        this.alternatives.add(rule);
    }

    public ArrayList<ArrayList<ValueToken>> getAlternatives() {
        return this.alternatives;
    }

    public String name() {
        return name;
    }

    public ExtraValue getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(ExtraValue returnValue) {
        this.returnValue = returnValue;
    }

    public ArrayList<ExtraValue> getArgs() {
        return args;
    }

    public ArrayList<String> getArgsString() {
        if (this.args == null) {
            return new ArrayList<>();
        }
        return this.args.stream().map(extraValue -> extraValue.type() + " " + extraValue.name()).collect(Collectors.toCollection(ArrayList::new))
                ;

    }

    public void addArg(ExtraValue arg) {
        args.add(arg);
    }

    public void setArgs(ArrayList<ExtraValue> args) {
        this.args = args;
    }


}
