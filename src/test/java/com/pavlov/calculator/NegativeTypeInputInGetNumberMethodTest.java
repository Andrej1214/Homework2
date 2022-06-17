package com.pavlov.calculator;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class NegativeTypeInputInGetNumberMethodTest {
    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @Test
    public void testNegativeGetNumber() {
        // using the features of the nextDouble() method (if you enter them separated by a space,
        // they will both be accepted, and depending on whether we assign a value to one variable or two,
        // only the first or both values will be caught at once (each for its own variable)) we are entering
        // a combination of characters that will force the getNumber() method to the first part of it "a"
        // throw out the message being checked, and on the second "5" end the method
        ByteArrayInputStream in = new ByteArrayInputStream("a  5,5".getBytes());
        System.setIn(in);
        CalculatorInputUtils.getNumber();
        assertThat(output.toString())
                .as("discrepancy between the entered expression and the expected one")
                .isEqualToIgnoringWhitespace("Введите число:" +
                        "\nВы ввели не число или число в неверном формате." +
                        "\nРазрешенные форматы: 5/-5 ; 2,5/-2,5 ; NaN ; Infinity/-Infinity." +
                        "\nПопробуйте еще раз.");
    }

    @AfterEach
    public void cleanUpStreams() {
        System.setOut(null);
    }

}
