package com.javarush.task.task19.task1910;

/* 
Пунктуация
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

        while (reader1.ready()) {
            writer.write((reader1.readLine()).replaceAll("[\\p{Punct}\\n]",""));
        }
        reader1.close();
        writer.flush();
        writer.close();
    }
}

