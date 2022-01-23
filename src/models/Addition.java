package models;

public class Addition implements Node {
    private final Node left;
    private final Node right;

    public Addition(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int calculate() {
        return left.calculate() + right.calculate();
    }
}
