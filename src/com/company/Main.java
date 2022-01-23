package com.company;

import components.ExpressionGenerator;
import components.Solver;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        ExpressionGenerator generator = new ExpressionGenerator();
        Solver solver = new Solver();
        ArrayList<String> result = solver.solve(generator.generateExpressions(inputHandler.getExpressionLength()), inputHandler.getFinalResult());
        System.out.println(result.size() + " expression found");
        System.out.println(result);
    }
}
