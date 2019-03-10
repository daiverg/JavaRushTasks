package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String fileName = reader.readLine();
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(fileName);

            if (file.length() < 1000) {
                fis.close();
                throw new DownloadException();
            }

        }

    }

    public static class DownloadException extends Exception {

    }
}
