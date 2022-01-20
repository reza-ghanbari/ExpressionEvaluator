package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {
    private int finalResult;
    private int expressionLength;
    private final Scanner inputScanner;

    public InputHandler() {
        this.inputScanner = new Scanner(System.in);
        this.getExpressionLength();
        this.getExpressionResult();
    }

    private void getExpressionLength() {
        while (true) {
            this.expressionLength = getInputs("Insert the length of the expression");
            if (this.expressionLength % 2 != 0) break;
            System.err.println("The length of the expression must be odd");
        }
    }

    private void getExpressionResult() {
        int upperBound = (int) Math.pow(3, (this.expressionLength >> 1) + 1);
        int lowerBound = (this.expressionLength >> 1) + 1;
        while (true) {
            this.finalResult = getInputs("Insert the desired result of the expression");
            if (this.finalResult < upperBound && this.finalResult > lowerBound) break;
            System.err.println("The result must be between " + lowerBound + " and " + upperBound);
        }
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
