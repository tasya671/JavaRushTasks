package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Переверни массив
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int [] temp = new int[10];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i <temp.length ; i++) {
            temp[i]= Integer.parseInt(reader.readLine());
        }
        reader.close();
        for (int i = temp.length-1; i >=0 ; i--) {
            System.out.println(temp[i]);
        }
    }
}

