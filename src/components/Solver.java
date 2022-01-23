package components;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Solver {

    public Solver() {}

    public ArrayList<String> solveExpressions(ArrayList<String> expressions, int finalResult) {
        return expressions.stream()
                .filter(expression -> calculateFinalValue(expression) == finalResult)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private int calculateFinalValue(String expression) {
        int aggregatedValue = 0;
        int currentValue = VariableMap.variableMap.get(expression.charAt(0));
        for (int i = 1; i < expression.length() - 1; i += 2) {
            if (expression.charAt(i) == '+') {
                aggregatedValue += currentValue;
                currentValue = VariableMap.variableMap.get(expression.charAt(i + 1));
            } else if (expression.charAt(i) == '*') {
                currentValue *= VariableMap.variableMap.get(expression.charAt(i + 1));
            }
        }
        return aggregatedValue + currentValue;
    }
}
