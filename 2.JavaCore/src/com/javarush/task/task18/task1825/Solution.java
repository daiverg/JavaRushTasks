package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;


/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> partArray = new ArrayList();

        while (true) {
            String partFileName = reader.readLine();
            if (!partFileName.equals("end")) {
                partArray.add(partFileName);

            } else {
                break;
            }

        }
        reader.close();
        Collections.sort(partArray);

        String destFile = partArray.get(0).substring(0, (partArray.get(0).lastIndexOf(".")));
        BufferedOutputStream buffOut = new BufferedOutputStream(new FileOutputStream(destFile),1024);


        for (int i = 0; i < partArray.size(); i++){
            BufferedInputStream buffInput = new BufferedInputStream(new FileInputStream(partArray.get(i)),1024);
            while (buffInput.available() > 0){
                buffOut.write(buffInput.read());
            }
            buffInput.close();
            buffOut.flush();
        }
        buffOut.flush();
        buffOut.close();




    }
}
