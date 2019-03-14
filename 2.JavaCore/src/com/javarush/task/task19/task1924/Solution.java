package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }


    public static void main(String[] args) throws IOException {

        BufferedReader cR = new BufferedReader(new InputStreamReader(System.in));
        String fileName = cR.readLine();
        cR.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        while (fileReader.ready()) {
            String line = fileReader.readLine();
            String[] mas = line.split(" ");

            for (int i = 0; i < mas.length; i++) {
                for (Map.Entry<Integer, String> pair : map.entrySet()) {
                    if (mas[i].equals(pair.getKey().toString())) {
                        mas[i] = pair.getValue();
                    }
                }
            }
            for (int i = 0; i < mas.length; i++) {
                System.out.print(mas[i]+" ");
            }
            System.out.println();
        }

        fileReader.close();

    }
}
