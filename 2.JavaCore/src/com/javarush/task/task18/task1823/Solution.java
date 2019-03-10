package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader readFileName = new BufferedReader(new InputStreamReader(System.in));


        String fileName = readFileName.readLine();
        while (true) {
            if (fileName.equals("exit")) {
                break;
            }
            Thread t = new ReadThread(fileName);
            t.start();
            fileName = readFileName.readLine();

        }

        readFileName.close();


        System.out.println(resultMap);
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) throws IOException {
            this.fileName = fileName;
            //implement constructor body
        }

        @Override
        public void run() {

            try {
                FileInputStream fis = new FileInputStream(fileName);
                Map<Byte, Integer> map = new HashMap();
                ArrayList<Byte> maximal = new ArrayList();
                int max = 0;
                int maxByte = 0;

                while (fis.available() > 0) {
                    byte byt = (byte) fis.read();
                    if (map.containsKey(byt)) {
                        map.put(byt, (map.get(byt)+1));
                    } else map.put(byt, +1);
                }
                fis.close();

//                get maximum value from map
                for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
                    if (entry.getValue() > max) {
                        max = entry.getValue();
                    }
                }
//                put byte's in ArrayList
                for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
                    if (entry.getValue() == max) {
                        maxByte =(int) entry.getKey();
                    }
                }

                synchronized (resultMap) {
                    resultMap.put(fileName, maxByte);
                }

//                //        put byte's to resultMap
////                for (int i = 0; i < maximal.size(); i++) {
////                    System.out.print(maximal.get(i)+ " ");
//                    resultMap.put(fileName,max);
//                }

            } catch (IOException e) {

            }
        }



        // implement file reading here - реализуйте чтение из файла тут
    }
}
