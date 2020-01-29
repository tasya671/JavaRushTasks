package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(file);
        OutputStreamWriter writer = new OutputStreamWriter(System.out);

        while (inputStream.available() > 0){
            writer.write(inputStream.read());
        }
        writer.flush();
        inputStream.close();
        writer.close();
    }
}