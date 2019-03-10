package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

//        FileOutputStream fos = new FileOutputStream(fileName1);


        FileWriter fw = new FileWriter(fileName1, true);
        FileInputStream fis1 = new FileInputStream(fileName2);
        FileInputStream fis2 = new FileInputStream(fileName3);

        while (fis1.available() > 0) {
            fw.write(fis1.read());
        }
        fis1.close();
//        fos.close();

        while (fis2.available() > 0) {
            fw.write(fis2.read());
        }
        fis2.close();
        fw.close();

    }
}
