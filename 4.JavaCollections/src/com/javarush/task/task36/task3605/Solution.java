package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        TreeSet<Character> set = new TreeSet<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]))) {
            while (fileReader.ready()) {
                String s = fileReader.readLine().toLowerCase().replaceAll("[^\\p{Alpha}]",""); //\s\p{Punct}
                for (int i = 0; i < s.length(); i++)
                    set.add(s.charAt(i));
            }
        }
        set.stream().limit(5).forEach(e -> System.out.print(e));
    }
}
