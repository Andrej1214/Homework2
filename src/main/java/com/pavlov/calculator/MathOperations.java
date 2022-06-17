package com.pavlov.calculator;

public class MathOperations {
    protected static double sum(double a, double b) {
        return a + b;
    }

    protected static double subtract(double a, double b) {
        return a - b;
    }

    protected static double multiply(double a, double b) {
        return a * b;
    }

    protected static double divide(double a, double b) {
        if (b == 0.0) {
            System.out.println("Недопустимая операция. Деление на ноль. Введите другое число");
            b = CalculatorInputUtils.getNumber();
        }
        return a / b;
    }
}
