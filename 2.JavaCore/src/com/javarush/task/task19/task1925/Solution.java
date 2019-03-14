package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.*;


public class Solution {
    public static void main(String[] args) throws IOException {

        String fileIn = args[0];
        String fileout = args[1];

        BufferedReader fileReader = new BufferedReader(new FileReader(fileIn));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileout));

        ArrayList<String> res = new ArrayList();;


        while (fileReader.ready()) {
            String[] tmp = fileReader.readLine().split(" ");

            for (int i = 0; i < tmp.length; i++) {
                if (tmp[i].length()>6) {
                    res.add(tmp[i]+",");
                }
            }


        }
        if (res.size()>0) {
            String tmp2 = res.get(res.size()-1).replaceAll(",","");
            res.remove(res.size()-1);
            res.add(tmp2);

        }

        for (String s : res) {
//                System.out.println(res.size());
            fileWriter.write(s);
//                System.out.println(s);
        }


        fileReader.close();
        fileWriter.flush();
        fileWriter.close();

    }
}
