package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException, IOException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();

        //add your code here - добавьте код тут
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        t1.printResult();
        t2.printResult();

        reader.close();
    }



    //add your code here - добавьте код тут
    public static class Read3Strings extends Thread {

        private ArrayList <String> list = new ArrayList<>();

        public Read3Strings() {
            super(); }

        @Override
        public void run() {
            synchronized (reader){
            for (int i = 0; i < 3; i++) {
                    try {
                        list.add(reader.readLine()); }
                        catch (IOException e) { e.printStackTrace(); }
                }
            }
        }

        public void printResult(){
            for (String str:list) {
                System.out.print(str+" ");
            }
            System.out.println();
        }

    }
}
