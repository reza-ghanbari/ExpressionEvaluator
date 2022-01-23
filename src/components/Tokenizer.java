package components;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    private final ArrayList<String> operators;
    String base;

    public Tokenizer(String input) {
        this.operators = new ArrayList<>(List.of("*", "+"));
        this.base = input;
    }

    public String nextToken() {
        int endIndex;
        if (operators.contains(base.substring(0, 1))) {
            endIndex = 1;
        } else {
            endIndex = this.getNextOperatorIndex();
        }
        String returnedValue = base.substring(0, endIndex);
        base = base.substring(endIndex);
        return returnedValue;
    }

    public boolean isEmpty() { return base.isEmpty(); }

    private int getNextOperatorIndex() {
        int nextPlusIndex = base.indexOf("+");
        int nextMultiplyIndex = base.indexOf("*");
        if (nextMultiplyIndex == -1 && nextPlusIndex == -1) return base.length();
        else if (nextMultiplyIndex == -1) return nextPlusIndex;
        else if (nextPlusIndex == -1) return nextMultiplyIndex;
        else return Math.min(nextMultiplyIndex, nextPlusIndex);
    }

}
