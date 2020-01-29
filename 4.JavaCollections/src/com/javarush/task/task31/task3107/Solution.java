package com.javarush.task.task31.task3107;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

/*
Null Object Pattern
*/
public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {
        try {
            Path file = Paths.get(pathToFile);
            this.fileData = new ConcreteFileData(Files.isHidden(file),Files.isExecutable(file),Files.isDirectory(file),Files.isWritable(file));

        } catch (IOException e) {
            e.printStackTrace();
            this.fileData = new NullFileData(e);
        }
    }

    public FileData getFileData() {
        return fileData;
    }
}
