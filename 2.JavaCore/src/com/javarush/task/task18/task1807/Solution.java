package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fis = new FileInputStream(fileName);
        Map<Byte, Integer> map = new HashMap();
        ArrayList<Byte> arrayList = new ArrayList();
        int count = 0;
        int asciComaCod = 44;

//        read all bytes from file, count  and put in map
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
//
//        System.out.println();
//        System.out.println(map.containsKey((byte)44));
        System.out.println(map.get((byte)44));



    }
}
