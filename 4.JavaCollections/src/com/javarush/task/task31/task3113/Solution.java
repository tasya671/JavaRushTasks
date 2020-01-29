package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution extends SimpleFileVisitor<Path> {

    public static void main(String[] args) throws IOException {


        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        Path pathDirectory = Paths.get(console.readLine());
        console.close();

        if(!Files.isDirectory(pathDirectory)){
            System.out.println(String.format("%s - не папка", pathDirectory));
            return;
        }

        Solution solution = new Solution();
        Files.walkFileTree(pathDirectory, solution);
        System.out.println("Всего папок - "+solution.countDirectory);
        System.out.println("Всего файлов - "+solution.countFile);
        System.out.println("Общий размер - "+solution.size);


    }

    private int countDirectory = -1;
    private int countFile;
    private long size;


    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        countFile++;
        size+=attrs.size();
        return super.visitFile(file, attrs);
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        countDirectory++;
        return super.preVisitDirectory(dir, attrs);
    }


    public int getCountDirectiry() {
        return countDirectory;
    }

    public int getCountFile() {
        return countFile;
    }

    public long getSize() {
        return size;
    }
}
