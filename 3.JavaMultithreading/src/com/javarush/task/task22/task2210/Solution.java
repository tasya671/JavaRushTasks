package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(getTokens("level22.lesson13.task01", ".")));

    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        ArrayList <String> list = new ArrayList<>();
        while (tokenizer.hasMoreElements()){
            list.add(tokenizer.nextToken());
        }
        String [] result = new String[list.size()];
        int i = 0;
        for (String str:list) {
            result[i] = str;
            i++;
        }

       return  result;}
}
