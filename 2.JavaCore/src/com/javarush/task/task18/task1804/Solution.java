package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
//
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fis = new FileInputStream(fileName);
        Map<Byte, Integer> map = new HashMap();
        ArrayList<Byte> maximal = new ArrayList();
        int min = Integer.MAX_VALUE;

        while (fis.available() > 0) {
            byte byt = (byte) fis.read();
            if (map.containsKey(byt)) {
                map.put(byt, (map.get(byt)+1));
            } else map.put(byt, +1);
        }
        fis.close();
        reader.close();


//        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
//            System.out.println("байт - " + entry.getKey() + " кол-во - " + entry.getValue());
//        }

//        get maximum value from map
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            if (entry.getValue() < min) {
                min = entry.getValue();
            }
        }
//      put byte in ArrayList
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            if (entry.getValue() == min) {
                maximal.add(entry.getKey());
            }
        }

//        System.out.println(min);
//        sout byte
        for (int i = 0; i < maximal.size(); i++) {
            System.out.print(maximal.get(i)+ " ");
        }





    }
}
