package com.company;

import components.VariableMap;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {
    private int finalResult;
    private int expressionLength;
    private final Scanner inputScanner;

    public int getFinalResult() {
        return finalResult;
    }

    public int getExpressionLength() {
        return expressionLength;
    }

    public InputHandler() {
        this.inputScanner = new Scanner(System.in);
        this.getExpressionLengthFromUser();
        this.getExpressionResult();
    }

    private void getExpressionLengthFromUser() {
        while (true) {
            this.expressionLength = getInputs("Insert the length of the expression");
            if (this.expressionLength % 2 != 0 && this.expressionLength > 0) break;
            System.err.println("The length of the expression must be odd & it must be bigger than 0");
        }
    }

    private void getExpressionResult() {
        int upperBound = this.getUpperBound();
        int lowerBound = this.getLowerBound();
        while (true) {
            this.finalResult = getInputs("Insert the desired result of the expression");
            if (this.finalResult < upperBound && this.finalResult > lowerBound) break;
            System.err.println("The result must be between " + lowerBound + " and " + upperBound);
        }
    }

    private int getUpperBound() {
        return VariableMap.variableMap.values()
                .stream()
                .map(val -> (int) Math.pow(val, (this.expressionLength >> 1) + 1))
                .reduce(Integer::max)
                .get();
    }

    private int getLowerBound() {
        return VariableMap.variableMap.values()
                .stream()
                .map(val -> ((this.expressionLength >> 1) + 1) * val)
                .reduce(Integer::min)
                .get();
    }

    private int getInputs(String message) {
        int input;
        while (true) {
            try {
                System.out.println(message);
                input = inputScanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.err.println("Insert an integer");
                inputScanner.nextLine();
            }
        }
        return input;
    }
}
