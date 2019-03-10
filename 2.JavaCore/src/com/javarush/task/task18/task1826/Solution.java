package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {


    public static void main(String[] args) throws IOException {


        String fileName = args[1];
        String fileOutputName = args[2];

        InputStreamReader is = new InputStreamReader(new FileInputStream(fileName));
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(fileOutputName));

        switch (args[0]) {
            case "-d":
                while (is.ready()) {
                    out.write(is.read() + 1);
                }
                is.close();
                out.flush();
                out.close();
                break;

            case "-e":
                while (is.ready()) {
                    out.write(is.read() - 1);
                }
                is.close();
                out.flush();
                out.close();
                break;

        }
    }
}








