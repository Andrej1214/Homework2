package com.pavlov.calculator;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorInputNumbersTest {

    @Test
    public void testGetNumber() {
        ByteArrayInputStream in = new ByteArrayInputStream("55,0".getBytes());
        System.setIn(in);
        assertEquals(55.0, CalculatorInputUtils.getNumber(),"discrepancy between the entered number and the expected value");
        System.setIn(System.in);
    }
}
