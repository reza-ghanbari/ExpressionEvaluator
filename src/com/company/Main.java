package com.company;

import components.ExpressionGenerator;
import components.Solver;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        ExpressionGenerator generator = new ExpressionGenerator();
        Solver solver = new Solver();
        ArrayList<String> expressions = solver.solveExpressions(generator.generateExpressions(inputHandler.getExpressionLength()), inputHandler.getFinalResult());
        System.out.println(expressions.size() + " expressions found");
        System.out.println(expressions);
    }
}
