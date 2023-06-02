package com.llqlv.algotasks.third;

import com.llqlv.algotasks.third.converter.ConverterStringChecker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConverterStringCheckerTest {

    @Test
    public void testCheckTypeOfValidInputData() {
        String input = "2 meters = 200 centimeters";
        boolean result = ConverterStringChecker.checkTypeOfInputData(input);
        Assertions.assertTrue(result);
    }

    @Test
    public void testCheckTypeOfInvalidInputData() {
        String input = "2 meters = 200";
        boolean result = ConverterStringChecker.checkTypeOfInputData(input);
        Assertions.assertFalse(result);
    }

    @Test
    public void testCheckTypeOfValidInputQuestion() {
        String input = "5 meters = ? centimeters";
        boolean result = ConverterStringChecker.checkTypeOfInputQuestion(input);
        Assertions.assertTrue(result);
    }

    @Test
    public void testCheckTypeOfInvalidInputQuestion() {
        String input = "5 meters = 200 centimeters";
        boolean result = ConverterStringChecker.checkTypeOfInputQuestion(input);
        Assertions.assertFalse(result);
    }
}

