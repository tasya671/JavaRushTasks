package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) {

        if (args.length < 2)
            return;

        Path resultFileName = Paths.get(args[0]);
        List<String> listParts = new ArrayList<>();
        List<InputStream> streamList = new ArrayList<>();
        try {
            for (int i = 1; i < args.length; i++) {
                listParts.add(args[i]); }
        Collections.sort(listParts);

            for (int i = 0; i < listParts.size(); i++) {
                streamList.add(new FileInputStream(listParts.get(i))); }

        try (FileOutputStream outputStream = new FileOutputStream(resultFileName.toString());
             ZipInputStream inputStream = new ZipInputStream(new SequenceInputStream(Collections.enumeration(streamList)))) {
            ZipEntry entry = inputStream.getNextEntry();
            while (entry != null) {
                byte[] buffer = new byte[1024];
                int count = 0;
                while ((count = inputStream.read(buffer)) != -1)
                    outputStream.write(buffer, 0, count);
                outputStream.flush();
                entry = inputStream.getNextEntry();
            }
        }
        } catch (IOException exp){
            exp.printStackTrace(); }
    }
}
