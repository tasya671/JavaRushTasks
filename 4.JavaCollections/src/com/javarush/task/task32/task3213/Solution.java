package com.javarush.task.task32.task3213;

import java.io.IOException;
import java.io.StringReader;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {

        StringBuilder builder = new StringBuilder();
        if (reader != null){
            char [] buffer = new char[1024];
            int count = reader.read(buffer, 0, buffer.length);
            while (count> 0){
                for (int i = 0; i <count ; i++)
                    builder.append((char) ((int)buffer[i]+key));
                count = reader.read(buffer, 0, buffer.length);
            }
        }

        return builder.toString();
    }
}
