package components;

import java.util.HashMap;

public class VariableMap {
    public static final HashMap<Character, Integer> variableMap = new HashMap<>();
    static {
        variableMap.put('1', 1);
        variableMap.put('2', 2);
        variableMap.put('x', 2);
        variableMap.put('y', 3);
    }
}
