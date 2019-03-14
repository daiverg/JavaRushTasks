package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader cR = new BufferedReader(new InputStreamReader(System.in));
        String fileName = cR.readLine();
        cR.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        StringBuffer stringBuffer;

        while (fileReader.ready()) {
            stringBuffer = new StringBuffer(fileReader.readLine());
            stringBuffer.reverse();
            System.out.println(stringBuffer);

        }

        fileReader.close();

    }
}
