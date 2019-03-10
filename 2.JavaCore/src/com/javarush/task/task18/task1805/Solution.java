package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;


/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fis = new FileInputStream(fileName);
        Map<Byte, Integer> map = new HashMap();
        ArrayList<Byte> arrayList = new ArrayList();
//        int min = Integer.MAX_VALUE;

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

//        put all key (byte) in arrayList
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            arrayList.add(entry.getKey());
        }

        Collections.sort(arrayList);



//        System.out.println(min);
//        sout byte
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i)+ " ");
        }
    }
}
