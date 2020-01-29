package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {

        File file = new File(root);
        ArrayDeque<File> queue = new ArrayDeque<>();
        List<String> list = new ArrayList<>();
        if(file.isFile()){
            list.add(file.getAbsolutePath());
            return list;
        }

        queue.add(file);
        while (!queue.isEmpty()){
            File current = queue.poll();
            for (File entry : current.listFiles()) {
                if (entry.isDirectory()){
                    queue.add(entry);
                    continue;
                }
                list.add(entry.getAbsolutePath());
            }
        }

        return list;

    }

    public static void main(String[] args) {

        try {
            System.out.println(getFileTree("D:\\SomeDir"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
