package com.llqlv.algotasks.first;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class FooBarTest {


    @Test
    public void testFirstMethod() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        FooBar.firstMethod(16);
        String expectedOutput = "1\n2\nFoo\n4\nBar\nFoo\n7\n8\nFoo\nBar\n11\nFoo\n13\n14\nFooBar\n";
        assertLinesMatch(expectedOutput, outputStream.toString());
    }

    @Test
    public void testOptimalMethod() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        FooBar.optimalMethod(16);
        String expectedOutput = "1\n2\nFoo\n4\nBar\nFoo\n7\n8\nFoo\nBar\n11\nFoo\n13\n14\nFooBar\n";
        assertLinesMatch(expectedOutput, outputStream.toString());
    }

    @Test
    public void testStreamMethod() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        FooBar.streamMethod(16);
        String expectedOutput = "1\n2\nFoo\n4\nBar\nFoo\n7\n8\nFoo\nBar\n11\nFoo\n13\n14\nFooBar\n";
        assertLinesMatch(expectedOutput, outputStream.toString());
    }

    private void assertLinesMatch(String expected, String actual) {
        List<String> expectedLines = Arrays.asList(expected.split("\\R"));
        List<String> actualLines = Arrays.asList(actual.split("\\R"));

        Assertions.assertEquals(expectedLines.size(), actualLines.size());

        for (int i = 0; i < expectedLines.size(); i++) {
            Assertions.assertEquals(expectedLines.get(i), actualLines.get(i));
        }
    }
}

