package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = consoleReader.readLine() ;
        consoleReader.close();

        PrintStream sysOut = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream myOut = new PrintStream(byteArrayOutputStream);
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);

        System.setOut(myOut);
        testString.printSomething();
        fileOutputStream.write(byteArrayOutputStream.toByteArray());
        fileOutputStream.flush();
        fileOutputStream.close();



        System.setOut(sysOut);
        System.out.println(byteArrayOutputStream.toString());

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

