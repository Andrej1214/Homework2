package com.pavlov.calculator;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorInputUtilsTest {

    @Order(1)
    @Test
    public void testGetOperation() {
        ByteArrayInputStream in = new ByteArrayInputStream("*".getBytes());
        System.setIn(in);
        assertEquals('*', CalculatorInputUtils.getOperation(), "discrepancy between the entered operation sign and the expected value");
        System.setIn(System.in);
    }

    @Order(2)
    @ParameterizedTest
    @DisplayName("calculate some elements")
    @CsvSource(value = {" 7, 5,'+',12.0 ", "-2, -5,'-', 3.0 ", " -2, 5,'/', -0.4 ", " -1.5, -1.5, '*', 2.25 "})
    public void testSubtractCalculator(double number1, double number2, char operation, double result) {
        assertEquals(result, CalculatorInputUtils.calculate(number1, number2, operation), "Incorrect result of operation");
    }
}