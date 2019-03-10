package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
        File file1 = new File(reader1.readLine());
        File file2 = new File(reader2.readLine());

        BufferedReader fileReader1 = new BufferedReader(new FileReader(file1));
        while (fileReader1.ready()) {
            allLines.add(fileReader1.readLine());
        }
        BufferedReader fileReader2 = new BufferedReader(new FileReader(file2));
        while (fileReader2.ready()) {
            forRemoveLines.add(fileReader2.readLine());
        }
        fileReader1.close();
        fileReader2.close();
        reader1.close();
        reader2.close();

        Solution sol1 = new Solution();
        sol1.joinData();


    }

    public void joinData() throws CorruptedDataException {

        if(allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        }else{
            allLines.clear();
            throw new CorruptedDataException();
        }

    }
}
