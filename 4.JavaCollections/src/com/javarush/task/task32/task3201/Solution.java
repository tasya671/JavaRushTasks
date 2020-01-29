package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {

        if(args.length<3)
            return;

        RandomAccessFile file = new RandomAccessFile(args[0],"rw");
        int skeep = Integer.parseInt(args[1]);
        long size = file.length();

        if(skeep > size) { file.seek(size); }
        else { file.seek(skeep); }


        file.write(args[2].getBytes());
        file.close();
    }
}
