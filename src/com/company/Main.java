package com.company;

import components.ExpressionGenerator;

public class Main {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        ExpressionGenerator generator = new ExpressionGenerator();
        System.out.println(generator.generateExpressions(inputHandler.getExpressionLength()));
    }
}
