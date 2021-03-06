package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        Double maxLohn = 0.0;
        Map<String, Double> list = new TreeMap();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        while (fileReader.ready()) {
            String[] a = fileReader.readLine().split(" ");

            if (list.containsKey(a[0])) {
                Double tmp = Double.parseDouble(a[1]) + list.get(a[0]);
                list.put(a[0], tmp);
            } else list.put(a[0], (Double.parseDouble(a[1])));
        }
        fileReader.close();

        for (Map.Entry<String, Double> s : list.entrySet()) {
            if (s.getValue() > maxLohn) {
                maxLohn = s.getValue();
            }
        }

        for (Map.Entry<String, Double> s : list.entrySet()) {
            if (s.getValue().equals(maxLohn)) {
                System.out.println(s.getKey());
            }
//            System.out.println(s.getKey()+" "+s.getValue());
        }

    }
}