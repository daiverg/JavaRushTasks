package com.javarush.task.task18.task1828;

/*
Прайсы 2
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        int id = 0;
        String productName = "";
        String price = "";
        String quantity = "";

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = consoleReader.readLine();
        consoleReader.close();


        if (args[0].equals("-u")) {
            id = Integer.parseInt(args[1]);
            productName = (String.format("%-30s", args[2]));
            price = (String.format("%-8s", args[3]));
            quantity = (String.format("%-4s", args[4]));

            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            List<String> arrIn = new ArrayList<String>();

            while (fileReader.ready()) {
                String str = fileReader.readLine();
                int idInFile = Integer.parseInt(str.substring(0, 8).trim());
                if (idInFile == id) {
                    arrIn.add((String.format("%-8s", String.valueOf(id))) + productName + price + quantity);

                } else arrIn.add(str);
            }
            fileReader.close();

            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName));
            for (String s : arrIn) {
                fileWriter.write(s+System.lineSeparator());
            }
            fileWriter.flush();
            fileWriter.close();
        }

        if (args[0].equals("-d")) {
            id = Integer.parseInt(args[1]);
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            List<String> arrIn = new ArrayList<String>();

            while (fileReader.ready()) {
                String str = fileReader.readLine();
                int idInFile = Integer.parseInt(str.substring(0, 8).trim());
                if (idInFile == id) {
                    continue;
                } else arrIn.add(str);

            }
            fileReader.close();

            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName));
            for (String s : arrIn) {
                fileWriter.write(s+System.lineSeparator());
            }
            fileWriter.flush();
            fileWriter.close();

        }

    }
}
