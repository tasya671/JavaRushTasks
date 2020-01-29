package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count= Integer.parseInt(reader.readLine());
        int [] mas = new int[count];
        for (int i = 0; i <count ; i++) {
            mas[i]=Integer.parseInt(reader.readLine());}


        int maximum = mas[0];
        for (int i = 0; i <mas.length ; i++) {
            if(maximum<mas[i])
                maximum=mas[i]; }

        reader.close();

        System.out.println(maximum);
    }
}
