package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileIn = consoleReader.readLine()  ;
        String fileOut = consoleReader.readLine() ;
        consoleReader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileIn));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileOut));

        while (fileReader.ready()) {
            String str = fileReader.readLine();
            String str2 = str.replaceAll("\\.", "!");
//            System.out.println(str2);
            fileWriter.write(str2);
        }


        fileReader.close();
        fileWriter.flush();
        fileWriter.close();
    }
}
