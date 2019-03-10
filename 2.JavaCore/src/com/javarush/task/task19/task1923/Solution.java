package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        String file1 = args[0];
        String file2 = args[1];

        BufferedReader fileReader = new BufferedReader(new FileReader(file1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file2));

        while (fileReader.ready()) {
            String[] tmp = fileReader.readLine().split(" ");

            for (int i = 0; i < tmp.length; i++) {
                if (tmp[i].matches(".*?\\d.*")) {
                    fileWriter.write(tmp[i]+" ");
                }
            }

        }
        fileReader.close();
        fileWriter.flush();
        fileWriter.close();

    }
}
