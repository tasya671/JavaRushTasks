package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();

        BufferedReader inputStream = new BufferedReader(new FileReader(file));
        String text;
        while ((text=inputStream.readLine())!=null){
        String[] res = text.split(" ");
        if(res[0].equals(args[0])) {
            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i] + " "); }
            break; }
        }
        inputStream.close();
    }
}
