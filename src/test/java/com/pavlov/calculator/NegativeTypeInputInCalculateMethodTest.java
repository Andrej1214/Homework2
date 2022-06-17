package com.pavlov.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class NegativeTypeInputInCalculateMethodTest {
    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @Test
    public void testCatchExpressionInCalculateMethod() {
        //since the method is waiting for the correct operation value from the user,
        // we give the correct operation sign ( / ) to our stream
        ByteArrayInputStream in = new ByteArrayInputStream("/".getBytes());
        System.setIn(in);
        // and in order for the method to throw out an input error message,
        // we substitute an incorrect char value into the method variable (e.g. '^')
        CalculatorInputUtils.calculate(5, 7, '^');
        assertThat(output.toString())
                .as("discrepancy between entered expression and expected one")
                .isEqualToIgnoringWhitespace("Calculator может осуществляет только следующие операции - +,-,/,*. Выберите одну из них. \nВведите операцию:");
    }

    @AfterEach
    public void cleanUpStreams() {
        System.setOut(null);
    }
}
