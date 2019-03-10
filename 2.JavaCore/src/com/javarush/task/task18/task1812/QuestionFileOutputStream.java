package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/



public class QuestionFileOutputStream implements AmigoOutputStream {

    private AmigoOutputStream orig;

    public QuestionFileOutputStream(AmigoOutputStream orig){
        this.orig = orig;
    }

    public void flush() throws IOException{
        orig.flush();
    }

    public void write(int b) throws IOException{

        orig.write(b);

    }

    public void write(byte[] b) throws IOException{
        orig.write(b);

    }

    public void write(byte[] b, int off, int len) throws IOException{
        orig.write(b, off, len);

    }

    @Override
    public void close() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        String answer = reader.readLine();
        reader.close();
        if (answer.equals("Д")) {
            orig.close();

        }

    }
}


