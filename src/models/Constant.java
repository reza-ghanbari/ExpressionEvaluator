package models;

public class Constant implements Node {
    private int value;

    public Constant(int value) {
        this.value = value;
    }

    @Override
    public int calculate() {
        return value;
    }
}
