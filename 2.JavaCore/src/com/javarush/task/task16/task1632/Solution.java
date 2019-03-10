package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    public static void main(String[] args) {



        
//        threads.get(0).start();
//        threads.get(1).start();
//        threads.get(1).interrupt();

//        threads.get(2).start();
//        threads.get(3).start();
//        threads.get(4).start();


    }

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    public static class Thread1 extends Thread{
        @Override
        public void run() {
            while (true);
        }
    }

    public static class Thread2 extends Thread{
        @Override
        public void run() {
            if (isInterrupted()) {
                try {
                    throw new InterruptedException("InterruptedException");
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }

    public static class Thread3 extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Ура");
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Thread4 extends Thread implements Message{
        volatile boolean flag;

        @Override
        public void run() {
            while (!flag) {
            }
        }

        @Override
        public void showWarning() {
            this.flag = true;
        }
    }

    public static class Thread5 extends Thread{
        public void run () {
            int Summa = 0;

            while (true) {
                BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
                String s = null;

                try {
                    s = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (!s.equals("N")) {
                    int i = Integer.parseInt(s);
                    Summa += i;
                }

                else {
                    System.out.println(Summa);
                }
            }
        }
    }
}