package components;

import java.util.HashMap;

public class VariableMap {
    public static final HashMap<String, Integer> variableMap = new HashMap<>();
    static {
        variableMap.put("x", 2);
        variableMap.put("y", 3);
    }
}
