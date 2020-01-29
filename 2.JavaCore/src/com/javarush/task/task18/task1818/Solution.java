package com.javarush.task.task18.task1818;

/* 
Два в одном
*/


import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        reader.close();

        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file1, true));
        BufferedInputStream inputStream1 = new BufferedInputStream(new FileInputStream(file2));
        BufferedInputStream inputStream2 = new BufferedInputStream(new FileInputStream(file3));

        byte [] buffer1 = new byte[inputStream1.available()];
        byte [] buffer2 = new byte[inputStream2.available()];
        inputStream1.read(buffer1);
        outputStream.write(buffer1);
        outputStream.flush();
        inputStream1.close();
        inputStream2.read(buffer2);
        outputStream.write(buffer2);
        outputStream.flush();
        inputStream2.close();
        outputStream.close();


    }
}
