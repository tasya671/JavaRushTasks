package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());
        int e = Integer.parseInt(reader.readLine());


        int [] mas = {a, b, c, d, e};

        for (int i = mas.length-1; i >=1 ; i--) {
            for (int j = 0; j < i; j++) {
                if (mas[j] > mas[j+1]) {
                    int temp = mas[j];
                    mas[j]=mas[j+1];
                    mas[j+1]= temp;
                }
            }
        }
        for (int i = 0; i <mas.length ; i++) {
            System.out.println(mas[i]);
        }
    }
}
