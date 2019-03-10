package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        FileInputStream fis = new FileInputStream(fileName1);
        FileOutputStream fos2 = new FileOutputStream(fileName2);
        FileOutputStream fos3 = new FileOutputStream(fileName3);

        if (fis.available() > 0) {
            byte[] buffer = new byte[fis.available()];
            int count = fis.read(buffer);
            if(count%2 == 0) {
                fos2.write(buffer, 0, count / 2);
                fos3.write(buffer, count / 2, count / 2);
            }
            else {
                fos2.write(buffer, 0, count / 2+1);
                fos3.write(buffer, count / 2+1, count / 2);
            }
        }


        reader.close();
        fis.close();
        fos2.close();
        fos3.close();
    }
}
