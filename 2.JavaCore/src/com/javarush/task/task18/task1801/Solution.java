package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.*;


/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fis = new FileInputStream(fileName);
        byte[] array = new byte[(fis.available())]; /*= fis.readAllBytes();*/
        int ii = 0;

        while (fis.available() > 0) {
            array[ii] = (byte) fis.read();
            ii++;
        }

        Arrays.sort(array);
        ArrayList<Byte> byt1 = new ArrayList();

        for (int i = 0; i < array.length; i++) {
            byt1.add(array[i]);
//            System.out.println("add "+array[i]);
        }
//        reader.close();
        fis.close();


        System.out.println(byt1.get((byt1.size() - 1)));


    }
}
