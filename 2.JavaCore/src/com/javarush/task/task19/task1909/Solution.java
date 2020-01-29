package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

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
            builder.append("\n");
        }
        reader1.close();

        String text = builder.toString();
        String str = text.replaceAll("\\.","!");

        writer.write(str);
        writer.flush();
        writer.close();
    }
}
