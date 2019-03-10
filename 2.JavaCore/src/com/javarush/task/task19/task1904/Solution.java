package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String str[] = fileScanner.nextLine().split(" ");
            Date date = null;

            try {
                date = new SimpleDateFormat("dd/MM/yyyy").parse(String.format("%s/%s/%s", str[3], str[4], str[5]));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return new Person(str[1], str[2], str[0], date);

        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }


    public static void main(String[] args) throws IOException {
// System.out.println(new PersonScannerAdapter(new Scanner(new File("2.txt"))).read());
    }
}
