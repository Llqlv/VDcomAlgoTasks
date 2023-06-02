package com.llqlv.algotasks.third.converter;

public class ConverterStringChecker{

    private ConverterStringChecker() {}

    public static boolean checkTypeOfInputData(String check) {
        return check.matches("^\\d+(\\.\\d+)?\\s\\w+\\s=\\s\\d+(\\.\\d+)?\\s\\w+$");
    }

    public static boolean checkTypeOfInputQuestion(String check) {
        return check.matches("^\\d+(\\.\\d+)?\\s\\w+\\s=\\s\\?\\s\\w+$");
    }
}
