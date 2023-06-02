package com.llqlv.algotasks.second;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class MainTest {

    @Test
    public void testMain() {
        int n = 10;
        String filePath = "src/main/resources/out.txt";

        // Удаление файла, если он существует
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }

        // Запуск метода main
        Main.fileThreadMethod(n);

        // Проверка финального значения в файле
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String finalValue = reader.readLine();
            reader.close();

            int expectedValue = n;
            Assertions.assertEquals(String.valueOf(expectedValue), finalValue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
