package com.pavlov.calculator;

public class ExecutorCalculatorApplication {
    public void executionApplication() {
        double firstNumber = CalculatorInputUtils.getNumber();
        double secondNumber = CalculatorInputUtils.getNumber();
        char operation = CalculatorInputUtils.getOperation();
        double result = CalculatorInputUtils.calculate(firstNumber, secondNumber, operation);
        System.out.println("Результат операции: " + result);
    }
}
