package com.javarush.task.task22.task2211;

import java.io.*;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        if(args.length < 2) return;
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        FileOutputStream fileOutputStream = new FileOutputStream(args[1]);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        byte [] buffer = new byte[bufferedInputStream.available()];
        bufferedInputStream.read(buffer);
        String str = new String(buffer, "Windows-1251");
        buffer = str.getBytes("UTF-8");
        bufferedOutputStream.write(buffer);
        bufferedOutputStream.flush();
        bufferedInputStream.close();
        bufferedOutputStream.close();

    }
}
