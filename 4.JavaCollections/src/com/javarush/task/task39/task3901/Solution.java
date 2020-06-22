package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Уникальные подстроки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        int max =0;
        if (s != null && !s.equals("") && !s.equals("null")) {
            Set<String> uniqueSubstring = new TreeSet<>();
            String[] str = s.split("");
            for (String current : str) {
                if(!uniqueSubstring.contains(current)){
                   uniqueSubstring.add(current);
                   max = uniqueSubstring.size()< max ? max : uniqueSubstring.size();
                } else {
                    uniqueSubstring.clear();
                    uniqueSubstring.add(current);
                }
            }
            return max;
        } else
            return 0;
    }
}
