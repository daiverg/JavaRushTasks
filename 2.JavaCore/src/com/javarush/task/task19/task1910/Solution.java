package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileIn = consoleReader.readLine();
        String fileOut = consoleReader.readLine();
        consoleReader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileIn));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileOut));

        while (fileReader.ready()) {
            String str = fileReader.readLine();
            fileWriter.write(str.replaceAll("\\p{Punct}",""));

        }
        fileReader.close();
        fileWriter.flush();
        fileWriter.close();



    }
}
