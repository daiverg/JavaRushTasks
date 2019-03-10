package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream sysOut = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        PrintStream myOut = new PrintStream(byteArrayOutputStream);

        System.setOut(myOut);
        testString.printSomething();

        System.setOut(sysOut);
        System.out.println(byteArrayOutputStream.toString().replaceAll("te","??"));



    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
