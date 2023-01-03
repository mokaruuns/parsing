package classes;

import java.util.ArrayList;

public class MathFormula {
    private final ArrayList<MathItem> mathItems;

    public MathFormula() {
        mathItems = new ArrayList<>();
    }

    public MathFormula(ArrayList<MathItem> mathItems) {
        this.mathItems = mathItems;
    }

    public void add(MathItem mathItem) {
        this.mathItems.add(mathItem);
    }
}
