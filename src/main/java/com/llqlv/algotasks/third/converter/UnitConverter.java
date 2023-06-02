package com.llqlv.algotasks.third.converter;

public class UnitConverter {

    private final ConverterService converterService = new ConverterServiceImpl();

    public void start() {
        converterService.startDataInput();
        converterService.startQuestionInput();
        converterService.printAnswers();
    }
}
