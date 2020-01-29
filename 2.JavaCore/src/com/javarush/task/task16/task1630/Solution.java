package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();  }
            catch (IOException exp){}
    }

    //add your code here - добавьте код тут

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);

        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface{
        private String fileRead;
        private String contex = "";

        @Override
        public void setFileName(String fullFileName) {
            fileRead = fullFileName;
        }

        @Override
        public String getFileContent() {
            return contex;
        }


        @Override
        public void run(){
                StringBuilder builder = new StringBuilder();
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(new File(fileRead)));
                    String text;
                    while ((text=reader.readLine()) != null){
                        builder.append(text);
                        builder.append(" ");
                    }
                    reader.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace(); }
                catch (IOException exp){
                    exp.printStackTrace();}
                contex = builder.toString();
            }
        }
    }
