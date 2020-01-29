package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int [] mas = new int[20];
        for (int i = 0; i <20 ; i++) {
            mas[i]=Integer.parseInt(reader.readLine());
        }
        reader.close();

        int maximum = mas[0];
        int minimum = mas[0];

        for (int i = 0; i < mas.length; i++) {
            if(mas[i]>maximum)
                maximum=mas[i];
            if(mas[i]<minimum)
                minimum=mas[i];
            }


        System.out.print(maximum + " " + minimum);
    }
}
