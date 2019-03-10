package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
//        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(new FileInputStream(fileName1));


//        FileInputStream fis = new FileInputStream("1.txt");
//        FileOutputStream fos = new FileOutputStream("2.txt");

        FileWriter fw = new FileWriter(fileName2);

        while (sc.hasNext()){
                Double number = Double.parseDouble(sc.next());
                int i = (int)Math.round(number);
                String str = String.valueOf(i);
                fw.write(str+" ");
//                System.out.println(str);
        }
        fw.flush();
        fw.close();

        sc.close();
    }
}
