package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {

        ArrayList<String> list = new ArrayList<>();

        if (args.length == 2) {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

            while (reader.ready()){
                String [] data = reader.readLine().split(" ");
                for (String str: data) {
                    if(str.length()>6){
                        list.add(str);
                    }
                }
            }
            reader.close();
            for (int i = 0; i <list.size()-1 ; i++) {
                writer.write(list.get(i)+",");
            }
            writer.write(list.get(list.size()-1));
            writer.close();

        }
    }
}