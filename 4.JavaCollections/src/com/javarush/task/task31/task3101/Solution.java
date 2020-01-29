package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) {

        if(args.length!=2)
            return;

        File target = new File(args[1]);
        File path = new File(args[0]);
        File out =new File(target.getParent()+"/allFilesContent.txt");

        if(FileUtils.isExist(target)){
            FileUtils.renameFile(target,out);
        }

        List<File> result = walkTree(path);
        Collections.sort(result, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });


        try(FileOutputStream outputStream = new FileOutputStream(out, true)){
            for (int i = 0; i <result.size() ; i++) {
                FileInputStream inputStream = new FileInputStream(result.get(i));
                byte [] byffer = new byte[inputStream.available()];
                inputStream.read(byffer);
                outputStream.write(byffer);
                outputStream.write(System.lineSeparator().getBytes());
                outputStream.flush();
                inputStream.close();
            }

        }catch (IOException e){
            e.printStackTrace(); }
    }

    public static List<File> walkTree(File file){

        List<File> list = new ArrayList<>();

        if(file.isDirectory()){
            for (File entry: file.listFiles()){
                if(entry.isDirectory())
                    list.addAll(walkTree(entry));
                else if(entry.length()<=50){
                    list.add(entry);
                }
            }
        }
        return list;
    }
}
