package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();
        reader.close();
        FileReader reader1 = new FileReader(fileName);
        StringBuilder builder = new StringBuilder();

        while (reader1.ready()){
            builder.append(String.valueOf((char)reader1.read()));
        }
        reader1.close();

        String text = builder.toString();
        String [] words = text.split("\\PL+");
        int count =0;

        for (String w :words) {
            if(w.equalsIgnoreCase("world"))
                count++;
        }

        System.out.println(count);



    }
}
