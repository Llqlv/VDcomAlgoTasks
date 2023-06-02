package com.llqlv.algotasks.third;
import com.llqlv.algotasks.third.converter.StringParser;
import com.llqlv.algotasks.third.converter.StringParserImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringParserImplTest {

    private StringParserImpl parser;

    @BeforeEach
    public void setup() {
        parser = new StringParserImpl();
    }

    @Test
    public void test_dataParser() {
        String input = "2 meters = 200 centimeters";
        parser.dataParser(input);

        Map<String, Map<String, Double>> expectedTypes = new HashMap<>();
        expectedTypes.put("meters", new HashMap<>());
        expectedTypes.put("centimeters", new HashMap<>());
        expectedTypes.get("meters").put("centimeters", 100.0);
        expectedTypes.get("meters").put("meters", 1.0);
        expectedTypes.get("centimeters").put("meters", 0.01);
        expectedTypes.get("centimeters").put("centimeters", 1.0);

        Assertions.assertEquals(expectedTypes, parser.getTypes());
    }

    @Test
    public void test_questionParser_ConversionPossible() {
        String input = "2 meters = 200 centimeters";
        parser.dataParser(input);

        String question = "5 meters = ? centimeters";

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        parser.questionParser(question);

        List<String> expectedAnswers = Arrays.asList("5 meters = 500.0 centimeters");
        Assertions.assertEquals(expectedAnswers, parser.getAnswers());
    }

    @Test
    public void test_questionParser_ConversionNotPossible() {
        String input = "2 meters = 200.0 centimeters";
        parser.dataParser(input);

        String question = "5 meters = ? kilograms";

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        parser.questionParser(question);

        List<String> expectedAnswers = Arrays.asList("Conversion not possible.");
        Assertions.assertEquals(expectedAnswers, parser.getAnswers());
    }
}
