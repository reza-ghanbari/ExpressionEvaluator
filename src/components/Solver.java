package components;

import models.*;

import java.util.ArrayList;
import java.util.stream.Collectors;


public class Solver {
    private Node root;

    public Solver() {}

    public ArrayList<String> solve(ArrayList<String> expressions, int finalResult) {
        return expressions.stream()
                .filter(expression -> createExpressionTree(expression).calculate() == finalResult)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private Node createExpressionTree(String expression) {
        Tokenizer tokenizer = new Tokenizer(expression);
        Node currentNode = null, leftNode = new Constant(0);
        while (!tokenizer.isEmpty()) {
            String token = tokenizer.nextToken();
            if (token.equals("+")) {
                root = new Addition(leftNode, currentNode);
                leftNode = root;
                currentNode = createLeaf(tokenizer.nextToken());
            } else if (token.equals("*")) {
                currentNode = new Multiplication(currentNode, createLeaf(tokenizer.nextToken()));
            } else {
                currentNode = createLeaf(token);
            }
        }
        return new Addition(leftNode, currentNode);
    }

    private Node createLeaf(String token) {
        return (VariableMap.variableMap.containsKey(token))
                ? new Variable(token)
                : new Constant(Integer.parseInt(token));
    }

}
