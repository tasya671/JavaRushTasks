package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        if(args.length==2){
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
            Pattern pattern = Pattern.compile("\\.*?(\\d)+\\.*");

            while (reader.ready()) {
                String[] data = reader.readLine().split(" ");
                for (String str : data) {
                    Matcher matcher = pattern.matcher(str);
                    if (matcher.find()) {
                        writer.write(str + " ");
                        System.out.println(str);
                    }
                }
            }
            writer.close();
            reader.close();



        }
    }
}
