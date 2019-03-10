package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inFile = reader.readLine();
        String outFile = reader.readLine();
        reader.close();

        FileReader fr = new FileReader(inFile);
        FileWriter fw = new FileWriter(outFile);
        int counter = 0;
        while (fr.ready()) {
            int a = fr.read();
            counter++;
            if (counter % 2 == 0) {
                fw.write(a);
            }
        }
        fr.close();
        fw.flush();
        fw.close();
    }
}
