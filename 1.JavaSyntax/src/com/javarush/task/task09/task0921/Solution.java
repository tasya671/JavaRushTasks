package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {

        readData();
    }

    public static void readData() {
        List <Integer> list = new ArrayList<>();
        try {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            int k = Integer.parseInt(reader.readLine());
            list.add(k); }
        } catch (NumberFormatException exp){
            for (Integer i:list) {
                System.out.println(i); }}
          catch (IOException exp){
                exp.printStackTrace(); }
    }
}

