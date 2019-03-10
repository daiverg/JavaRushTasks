package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileIn = consoleReader.readLine() ;
        String fileOut = consoleReader.readLine() ;
        consoleReader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileIn));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileOut));

        while(fileReader.ready()) {
            String str[] = fileReader.readLine().split("\\s");
            for (int i =0; i<str.length; i++) {
                if(str[i].matches("\\d+")) {
                    fileWriter.write((str[i]+" "));
//                    System.out.print(str[i]+" ");

                }
            }
        }
        fileReader.close();
        fileWriter.flush();
        fileWriter.close();

    }

}
