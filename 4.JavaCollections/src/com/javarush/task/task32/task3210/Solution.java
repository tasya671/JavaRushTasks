package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {

        if(args.length <3)
            return;

        RandomAccessFile file = new RandomAccessFile(args[0],"rws");
        int course = Integer.parseInt(args[1]);
        String text = args[2];

        byte [] buffer = new byte[text.length()];
        file.seek(course);

        file.read(buffer,0, text.length());
        String str = new String(buffer);
        file.seek(file.length());
        if(str.equals(text))
            file.write("true".getBytes());
        else
            file.write("false".getBytes());

        file.close();
    }
}
