package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[0]);

        double letterCount = 0;
        double spaceCount = 0; //32 = space
        while (fis.available() > 0) {
            int tmp = fis.read();
            letterCount++;
            if (tmp == 32) spaceCount++;
        }
        fis.close();

        double d = spaceCount/letterCount*100;
        d = new BigDecimal(d).setScale(2, RoundingMode.UP).doubleValue();
        System.out.println(d);

    }
}
