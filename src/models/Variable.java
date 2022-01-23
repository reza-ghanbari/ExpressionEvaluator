package models;

import components.VariableMap;

public class Variable implements Node {
    private final String variableName;

    public Variable(String variableName) {
        this.variableName = variableName;
    }

    @Override
    public int calculate() {
        return VariableMap.variableMap.get(variableName);
    }
}
