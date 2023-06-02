package com.llqlv.algotasks.first;

import java.util.Scanner;
import java.util.stream.IntStream;

public class FooBar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите значение FooBar");
        var num = sc.nextInt();

        firstMethod(num);
        System.out.println("---------------------------------------------");
        optimalMethod(num);
        System.out.println("---------------------------------------------");
        streamMethod(num);
    }
    public static void firstMethod(int num) {
        for (int i = 1; i < num; i++) {
            if (i % 3 == 0 && i % 5 == 0)
                System.out.println("FooBar");
            else if (i % 3 == 0)
                System.out.println("Foo");
            else if (i % 5 == 0)
                System.out.println("Bar");
            else
                System.out.println(i);
        }
    }

    public static void optimalMethod(int num) {
        for (int i = 1; i < num; i++) {
            StringBuilder output = new StringBuilder();

            if (i % 3 == 0)
                output.append("Foo");
            if (i % 5 == 0)
                output.append("Bar");

            if (output.isEmpty())
                output.append(i);

            System.out.println(output);
        }
    }

    public static void streamMethod(int num) {
        IntStream.range(1, num)
                .mapToObj(i ->
                        (i % 3 == 0) && (i % 5 == 0)
                                ? "FooBar"
                                : (i % 3 == 0) ? "Foo"
                                : (i % 5 == 0) ? "Bar" : i
                ).forEach(System.out::println);
    }
}