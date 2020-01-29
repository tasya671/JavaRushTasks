package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream concole = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream = new MyStream(new PrintStream(byteArrayOutputStream));
        System.setOut(stream);
        testString.printSomething();
        String rez = byteArrayOutputStream.toString();
        System.setOut(concole);
        System.out.println(rez);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }

    public static class MyStream extends PrintStream {

        private static int count =0;
        private PrintStream stream;
        private String cr = "\nJavaRush - курсы Java онлайн";

        public MyStream(PrintStream stream) {
            super(stream);
            this.stream = stream;
        }

        @Override
        public void println(String s) {
            if(count==1){
            super.println(s+cr);
            count=0;}
            else {
                super.println(s);
                count++;
            }

        }
    }
}
