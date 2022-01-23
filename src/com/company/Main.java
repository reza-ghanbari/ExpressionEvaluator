package com.company;

import components.ExpressionGenerator;
import components.Solver;

public class Main {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        ExpressionGenerator generator = new ExpressionGenerator();
        Solver solver = new Solver();
        System.out.println(solver.solveExpressions(generator.generateExpressions(inputHandler.getExpressionLength()), inputHandler.getFinalResult()));
    }
}
