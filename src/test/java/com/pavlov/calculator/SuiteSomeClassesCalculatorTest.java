package com.pavlov.calculator;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        MathOperationsTest.class,
        CalculatorInputNumbersTest.class
})
public class SuiteSomeClassesCalculatorTest {
}
