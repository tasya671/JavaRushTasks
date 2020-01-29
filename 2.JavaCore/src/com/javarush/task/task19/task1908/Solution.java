package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.text.ParseException;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileNameOne = reader.readLine();
        String fileNameTwo = reader.readLine();
        reader.close();


       BufferedReader reader1 = new BufferedReader(new FileReader(fileNameOne));
       BufferedWriter writer = new BufferedWriter(new FileWriter(fileNameTwo));
       StringBuilder builder = new StringBuilder();


        while (reader1.ready()) {
            builder.append(reader1.readLine());
        }
        reader1.close();

        String text = builder.toString();
        String[] words = text.split(" ");

        for (String w : words) {
            try{
                int c = Integer.parseInt(w);
                writer.write(w+" ");
                writer.flush();
            }catch (NumberFormatException exp){ }
        }

        writer.close();
    }
}