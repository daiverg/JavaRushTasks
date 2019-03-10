package com.javarush.task.task19.task1914;

/* 
Решаем пример
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

        String [] aXb = byteArrayOutputStream.toString().split(" ");
        int a = Integer.parseInt(aXb[0]);
        int b = Integer.parseInt(aXb[2]);
        int result = 0;

        switch (aXb[1]) {
            case "+":
                result = a+b;
                break;
            case "-":
                result = a-b;
                break;
            case "*":
                result = a*b;
                break;
        }

        String out = String.format("%d %s %d = %d",a,aXb[1],b,result);
        System.setOut(sysOut);

        System.out.println( out );


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

