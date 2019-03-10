package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        String fileName = bf.readLine();
        bf.close();
        int count = 0;


        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        while (fileReader.ready()){
            String str[] = (fileReader.readLine()).split("\\s?[^\\w]");
            for (int i = 0; i < str.length; i++ ){
                if (str[i].equals("world")) {
                    count++;
                }
            }
        }
        System.out.println(count);
        fileReader.close();
    }
}
