package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        List<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text;
        while (!(text=reader.readLine()).equalsIgnoreCase("end")){
            list.add(text);
        }
        reader.close();
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1.replaceAll("\\D+","");
                String str2 = o2.replaceAll("\\D+","");
                return Integer.parseInt(str1)-Integer.parseInt(str2);
            }
        });
        String file = list.get(0);

        FileOutputStream outputStream = new FileOutputStream((file.substring(0, file.lastIndexOf("."))), true);


        for (String name :list) {
           FileInputStream stream = new FileInputStream(name);
           byte [] buffer = new byte[stream.available()];
           stream.read(buffer);
           outputStream.write(buffer);
           outputStream.flush();
           stream.close();
        }

        outputStream.close();

    }
}
