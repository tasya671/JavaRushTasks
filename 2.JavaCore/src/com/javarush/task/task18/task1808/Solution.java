package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

        reader.close();

        FileInputStream inputStream = new FileInputStream(file1);

        int coutn = inputStream.available();
        int f1 = (inputStream.available()%2)==0 ? inputStream.available()/2 : inputStream.available()/2+1;
        int f2 = coutn - f1;

        FileOutputStream outputStream1 = new FileOutputStream(file2);
        byte [] buffer1 = new byte[f1];
        inputStream.read(buffer1);
        outputStream1.write(buffer1);
        outputStream1.flush();

        FileOutputStream outputStream2 = new FileOutputStream(file3);
        byte [] buffer2 = new byte[f2];
        inputStream.read(buffer2);
        outputStream2.write(buffer2);
        outputStream2.flush();

        inputStream.close();
        outputStream1.close();
        outputStream2.close();

    }
}
