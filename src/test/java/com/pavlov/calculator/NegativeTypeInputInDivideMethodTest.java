package com.pavlov.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

public class NegativeTypeInputInDivideMethodTest {
    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @Test
    public void testCatchExpressionInDivideMethod() {
        //since this method calls the getNumber() method after throwing a message about the inadmissibility
        // of the division operation, we will give it a valid value of 5 in our thread so that it can terminate.
        ByteArrayInputStream in = new ByteArrayInputStream("5".getBytes());
        System.setIn(in);
        MathOperations.divide(9.9, 0);
        assertThat(output.toString())
                .as("discrepancy between entered expression and expected one")
                .isEqualToIgnoringWhitespace("Недопустимая операция. Деление на ноль. Введите другое число"
                        + "\nВведите число:");
    }

    @AfterEach
    public void cleanUpStreams() {
        System.setOut(null);
    }

}
