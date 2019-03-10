package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int maxId = 0;
        String productName = "";
        String price = "";
        String quantity = "";

        if (args.length > 0) {
            productName = (String.format("%-30s", args[1]));
            price = (String.format("%-8s", args[2]));
            quantity = (String.format("%-4s", args[3]));
        }


        if (args.length > 0 && args[0].equals("-c")) {

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = consoleReader.readLine();
        consoleReader.close();

            BufferedReader br = new BufferedReader(new FileReader(fileName));

            while (br.ready()) {
                int getId = Integer.parseInt(br.readLine().substring(0, 8).trim());
                if (getId > maxId) {
                    maxId = (getId);
                }
            }
            br.close();


            int nextId = (maxId+1);
            String id = (String.format("%-8s", nextId));
            String result = id + productName + price + quantity;
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
            bw.write("\n");
            bw.write(result);
            bw.flush();
            bw.close();

        }
    }
}
