package components;

import java.util.ArrayList;
import java.util.List;

public class ExpressionGenerator {
    private ArrayList<String> expressions;
    private ArrayList<String> constants;
    private ArrayList<String> operators;

    public ExpressionGenerator() {
        this.constants = new ArrayList<>(VariableMap.variableMap.keySet());
        this.constants.addAll(List.of("1", "2"));
        this.operators = new ArrayList<>(List.of("*", "+"));
        this.expressions = new ArrayList<>(this.constants);
    }

    public ArrayList<String> generateExpressions(int length) {
        String item = expressions.remove(0);
        while (item.length() < length) {
            String finalItem = item;
            ((item.length() % 2 == 1) ? operators : constants).forEach(value -> expressions.add(finalItem + value));
            item = expressions.remove(0);
        }
        expressions.add(item);
        return expressions;
    }
}
