package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int [] temp = new int[15];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < temp.length; i++) {
            temp[i]= Integer.parseInt(reader.readLine());
        }
        reader.close();
        int sumeven =temp[0];
        int  sumodd =0;

        for (int i = 1; i < temp.length; i++) {
            if(i%2==0)
                sumeven+=temp[i];
            else
                sumodd+=temp[i];
        }

        if (sumeven>sumodd)
            System.out.println("В домах с четными номерами проживает больше жителей.");
        else System.out.println("В домах с нечетными номерами проживает больше жителей.");
    }
}
