package com.pavlov.calculator;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

@Execution(ExecutionMode.CONCURRENT)
public class MathOperationsTest {

    @ParameterizedTest
    @DisplayName("sum nested elements")
    @CsvSource(value = {" 2, 5, 7.0 ", "-2, -5, -7.0 ", "  -2, 5, 3.0 ", " 4.5, 4.5, 9.0 "})
    public void testSumCalculator(double number1, double number2, double result) {
        assertEquals(result, MathOperations.sum(number1, number2), "Incorrect sum");
    }

    @ParameterizedTest
    @DisplayName("subtract nested elements")
    @CsvSource(value = {" 7, 5, 2.0 ", "-2, -5, 3.0 ", "  -2, 5, -7.0 ", " -9.5, -4.9, -4.6 "})
    public void testSubtractCalculator(double number1, double number2, double result) {
        assertEquals(result, MathOperations.subtract(number1, number2), "Incorrect subtract");
    }

    @ParameterizedTest
    @DisplayName("multiply nested elements")
    @CsvSource(value = {" 2, 5, 10.0 ", "-2, -5, 10.0 ", "  -2, 5, -10.0 ", " 1.5, 1.5, 2.25 "})
    public void testMultiplyCalculator(double number1, double number2, double result) {
        assertEquals(result, MathOperations.multiply(number1, number2), "Incorrect multiply");
    }

    @ParameterizedTest
    @DisplayName("divide nested elements")
    @CsvSource(value = {" 12, 5, 2.4 ", "-2, -5, 0.4 ", "  -4, 5, -0.8 ", " 15.0, 7.5, 2.0 "})
    public void testDivideCalculator(double number1, double number2, double result) {
        assertEquals(result, MathOperations.divide(number1, number2), "Incorrect divide");
    }
}