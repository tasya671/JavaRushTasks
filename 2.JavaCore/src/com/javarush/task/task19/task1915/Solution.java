package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/


import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        PrintStream console = System.out;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        System.setOut(printStream);
        testString.printSomething();
        String text = stream.toString();
        FileOutputStream outputStream = new FileOutputStream(filename);
        outputStream.write(text.getBytes());
        outputStream.flush();
        outputStream.close();
        System.setOut(console);
        System.out.println(text);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

