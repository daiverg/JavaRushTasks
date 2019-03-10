package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName1 = reader.readLine();
//        String fileName2 = reader.readLine();
//        File temp = File.createTempFile("temp",".txt");
//        reader.close();
//
//
//        FileReader reader1 = new FileReader(fileName1);
//        FileWriter tempWriter = new FileWriter(temp,true);
//
//        while (reader1.ready()) // Read and write to temp file
//        {
//            tempWriter.write(reader1.read());
//        }
//        reader1.close();
//        tempWriter.close();
//
//
//        FileReader reader2 = new FileReader(fileName2);
//        FileWriter writer2 = new FileWriter(fileName1, false);
//
//        while (reader2.ready()) // Read from 2 & write to 1
//        {
//            writer2.write(reader2.read());
//        }
//        reader2.close();
//        writer2.close();
//
//
//        FileReader tempreader = new FileReader(temp);
//        FileWriter writerto1 = new FileWriter(fileName1, true);
//
//        while (tempreader.ready()) {
//            writerto1.write(tempreader.read());
//        }
//        tempreader.close();
//        writerto1.close();
//        temp.delete();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String output = reader.readLine();
        byte[] first;
        byte[] second;
        FileInputStream one = new FileInputStream(input);
        FileInputStream two = new FileInputStream(output);
        first = new byte[one.available()];
        one.read(first);
        one.close();

        second = new byte[two.available()];
        two.read(second);
        two.close();

        FileOutputStream three = new FileOutputStream(input);
        three.write(second);
        three.write(first);
        three.close();


        reader.close();




    }
}
