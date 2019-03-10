package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        FileInputStream fis = new FileInputStream(fileName1);
        FileOutputStream fos2 = new FileOutputStream(fileName2);


        while (fis.available() > 0) {
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            for (int i = buffer.length - 1; i >= 0; i--) {
                fos2.write(buffer[i]);
            }
        }

        reader.close();
        fis.close();
        fos2.close();


    }
}
