package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
//        String fileName = ;
        int letterCount = 0;

        FileInputStream fis = new FileInputStream(args[0]);

        while (fis.available() > 0) {
            int tmp = fis.read();
            System.out.println(tmp);
//            if ((tmp >= 65 && tmp <= 90) || (tmp >= 97 && tmp <= 122)) {
////                System.out.println(tmp);
//                letterCount++;
//            }
        }
        fis.close();
//        System.out.println(letterCount);
    }
}
