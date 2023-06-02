package com.llqlv.algotasks.third.converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConverterServiceImpl implements ConverterService {

    private StringParserImpl parser = new StringParserImpl();


    @Override
    public void startDataInput() {
        System.out.println("Start input data in format 'a V = b W' \n Type 'exit' to stop");
        try {
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(System.in));
            String str = bufferedReader.readLine();
            while (str != null && !str.isBlank()) {
                if (str.equals("exit"))
                    break;
                //TODO stringChecker.checkTypeOfInputData(str);
                if (ConverterStringChecker.checkTypeOfInputData(str)) {
                    parser.dataParser(str);
                } else {
                    System.out.println("Incorrect input data format, try again");
                }
                str = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //TODO parser.completeTypes();
    }

    @Override
    public void startQuestionInput() {
        System.out.println("Start input question in format 'a V = ? W' \n Type 'exit' to stop");
        try {
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(System.in));
            String str = bufferedReader.readLine();
            while (str != null && !str.isBlank()) {
                if (str.equals("exit"))
                    break;
                //TODO stringChecker.checkTypeOfInputQuestion(str);
                if (ConverterStringChecker.checkTypeOfInputQuestion(str)) {
                    parser.questionParser(str);
                } else {
                    System.out.println("Incorrect input data format, try again");
                }
                str = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void printAnswers() {
        parser.printAnswers();
    }
}
