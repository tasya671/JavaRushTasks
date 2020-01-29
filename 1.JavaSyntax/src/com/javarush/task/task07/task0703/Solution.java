package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String [] text = new String[10];
        int [] namber = new int[10];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i <text.length ; i++) {
            text[i]=reader.readLine(); }
         reader.close();

        for (int i = 0; i < namber.length ; i++) {
            namber[i]=text[i].length();
            System.out.println(namber[i]);
        }
    }
}
