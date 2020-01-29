package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        reader.close();

        BufferedInputStream inputStream1 = new BufferedInputStream(new FileInputStream(file1));
        byte [] buffer1 = new byte[inputStream1.available()];
        inputStream1.read(buffer1);
        inputStream1.close();


        BufferedInputStream inputStream2 = new BufferedInputStream(new FileInputStream(file2));
        byte [] buffer2 = new byte[inputStream2.available()];
        inputStream2.read(buffer2);
        inputStream2.close();


        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file1));
        outputStream.write(buffer2);
        outputStream.flush();
        outputStream.write(buffer1);
        outputStream.flush();
        outputStream.close();






    }
}
