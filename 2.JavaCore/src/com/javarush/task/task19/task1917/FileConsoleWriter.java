package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter {

    private FileWriter fileWriter;

    public static void main(String[] args) {

        try {
            FileConsoleWriter fileConsoleWriter = new FileConsoleWriter("D://t.txt");
            fileConsoleWriter.write(1245);
            fileConsoleWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public FileConsoleWriter(File file) throws IOException {
        this.fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd){
        this.fileWriter = new FileWriter(fd);
    }

    public FileConsoleWriter (String fileName) throws IOException {
        this.fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter (String fileName, boolean append) throws IOException {
        this.fileWriter = new FileWriter(fileName, append);
    }

    public void write(char[] cbuf, int off, int len) throws IOException{
        fileWriter.write(cbuf, off, len);
        String rez ="";
        for (int i = off; i <(off+len) ; i++) {
            rez+=cbuf[i];
        }
        System.out.println(rez);
    }

    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.println(c);
    }

    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.println(str);
    }

    public void write(String str, int off, int len){
        try {
            fileWriter.write(str, off, len);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(str.substring(off, off+len));
    }

    public void write(char[] cbuf) throws IOException{
        fileWriter.write(cbuf);
        String rez ="";
        for (int i = 0; i <cbuf.length ; i++) {
            rez+=cbuf[i];
        }
        System.out.println(rez);
    }

    public void close() throws IOException{
        fileWriter.close();
    }
}