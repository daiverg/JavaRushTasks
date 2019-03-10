package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        String id = (args[0]);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName= reader.readLine();
        reader.close();

        BufferedReader readline = new BufferedReader(new FileReader(fileName));

        while (readline.ready()) {
            String a = readline.readLine();
            if (a.startsWith(id+" ")) {
                System.out.println(a);
            }
        }
        readline.close();

    }
}
