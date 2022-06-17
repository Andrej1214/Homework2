package com.pavlov.calculator;

import java.util.Scanner;

public class CalculatorInputUtils {
    public static final Scanner scanner = new Scanner(System.in);

    public static double getNumber() {
        System.out.println("Введите число:");
        double number;
        while (!scanner.hasNextDouble()) {
            System.out.println("Вы ввели не число или число в неверном формате." +
                    "\nРазрешенные форматы: 5/-5 ; 2,5/-2,5 ; NaN ; Infinity/-Infinity." +
                    "\nПопробуйте еще раз.");
            scanner.next();
        }
        number = scanner.nextDouble();
        return number;
    }

    public static char getOperation() {
        System.out.println("Введите операцию:");
        char operation;
        while (!scanner.hasNext()) {
            System.out.println("Calculator может осуществляет только следующие операции : +,-,/,*. Выберите одну из них.");
            scanner.next();
        }
        operation = scanner.next().charAt(0);
        return operation;
    }

    public static double calculate(double x, double y, char operation) {
        double result;
        switch (operation) {
            case '+' -> result = MathOperations.sum(x, y);
            case '-' -> result = MathOperations.subtract(x, y);
            case '*' -> result = MathOperations.multiply(x, y);
            case '/' -> result = MathOperations.divide(x, y);
            default -> {
                System.out.println("Calculator может осуществляет только следующие операции - +,-,/,*. Выберите одну из них.");
                result = calculate(x, y, getOperation());
            }
        }
        return result;
    }
}
