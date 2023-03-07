package grammar;

import java.util.ArrayList;

public class NonTerm {
    private final ArrayList<ArrayList<ValueToken>> alternatives;
    private ReturnValue returnValue;
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

    public ReturnValue getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(ReturnValue returnValue) {
        this.returnValue = returnValue;
    }
}
