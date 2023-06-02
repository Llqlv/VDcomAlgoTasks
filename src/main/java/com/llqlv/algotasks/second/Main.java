package com.llqlv.algotasks.second;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Задайте значение: ");
        int n = sc.nextInt();

        fileThreadMethod(n);
    }

    public static void fileThreadMethod(int n) {
        try {
            PrintWriter writer = new PrintWriter("src/main/resources/out.txt");
            writer.println(0);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        AtomicInteger counter = new AtomicInteger(0);

        Thread thread1 = new Thread(() -> {
            while (counter.getAndIncrement() < n) {
                synchronized (counter) {
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/out.txt"));
                        int oldValue = Integer.parseInt(reader.readLine());
                        int newValue = oldValue + 1;
                        System.out.println("Thread 1: Old value = " + oldValue + ", New value = " + newValue);
                        reader.close();

                        PrintWriter writer = new PrintWriter("src/main/resources/out.txt");
                        writer.println(newValue);
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (counter.getAndIncrement() < n) {
                synchronized (counter) {
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/out.txt"));
                        int oldValue = Integer.parseInt(reader.readLine());
                        int newValue = oldValue + 1;
                        System.out.println("Thread 2: Old value = " + oldValue + ", New value = " + newValue);
                        reader.close();

                        PrintWriter writer = new PrintWriter("src/main/resources/out.txt");
                        writer.println(newValue);
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/out.txt"));
            String finalValue = reader.readLine();
            System.out.println("Final value in out.txt: " + finalValue);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
