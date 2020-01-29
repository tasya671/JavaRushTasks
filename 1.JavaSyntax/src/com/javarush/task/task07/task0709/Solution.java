package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> strings = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            strings.add(reader.readLine());
        }
        reader.close();
        int min = 0;

        for (int i = 1; i < strings.size(); i++) {
            if (strings.get(min).length()> strings.get(i).length())
                min =i; }
        for (int i = 0; i <strings.size() ; i++) {
            if (strings.get(min).length()==strings.get(i).length()){
                System.out.println(strings.get(i));
            }

        }
    }
}
