package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0,"ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        while (reader1.ready()){
            String [] data = reader1.readLine().split(" ");
            String rezult = "";
            for (String str:data) {
                try {
                    int number = Integer.parseInt(str);
                    if (map.containsKey(number)) {
                        str = map.get(number); }
                    rezult += str + " ";
                } catch (NumberFormatException exp){
                    rezult+=str+" ";
                }
            }
            System.out.println(rezult.substring(0, rezult.length()-1));
        }
        reader1.close();

    }
}
