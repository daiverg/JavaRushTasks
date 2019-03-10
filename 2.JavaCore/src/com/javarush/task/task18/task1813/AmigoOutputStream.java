package com.javarush.task.task18.task1813;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{

    private FileOutputStream fOS;

    public static String fileName = "C:/tmp/result.txt";

    public AmigoOutputStream(FileOutputStream fOS) throws FileNotFoundException {
        super(fileName);
        this.fOS = fOS;
    }

    @Override
    public void write(int b) throws IOException {
        fOS.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        fOS.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        fOS.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        String s = "JavaRush © All rights reserved.";
        fOS.write(s.getBytes());
        fOS.flush();
        fOS.close();
    }

    @Override
    public void flush() throws IOException {
        fOS.flush();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));

    }

}
