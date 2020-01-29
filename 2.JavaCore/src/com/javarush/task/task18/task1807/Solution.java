package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file = reader.readLine();
        reader.close();
        int count = 0;

        FileInputStream fileInputStream = new FileInputStream(file);
        while (fileInputStream.available()>0){
            int reads = fileInputStream.read();
            if (reads == 44){
                count++;
            }
        }
        fileInputStream.close();
        System.out.println(count);

    }
}
