package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(name);
        Set<Integer> set = new HashSet<>();

        while (inputStream.available()>0){
            set.add(inputStream.read());
        }
        inputStream.close();
        Object [] list =  set.toArray();
        int [] result = new int[list.length];
        for (int i = 0; i <list.length ; i++) {
            result[i]= (Integer) list[i];
        }
        Arrays.sort(result);

        for (int i = 0; i <result.length ; i++) {
            System.out.print(result[i]+" ");
        }
    }
}
