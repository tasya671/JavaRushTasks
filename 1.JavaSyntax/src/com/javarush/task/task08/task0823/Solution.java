package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        StringBuilder builder = new StringBuilder();
        reader.close();
        int i=0;
        while (string.substring(i, i+1).equals(" ")){
            i++; }
        String temp =string.substring(i, string.length());

        String [] text = temp.split(" +");

        for (int j = 0; j < text.length; j++) {
            text[j]=text[j].substring(0,1).toUpperCase()+text[j].substring(1);
            builder.append(text[j]+ " ");
        }
        System.out.println(builder);



        //напишите тут ваш код
    }
}
