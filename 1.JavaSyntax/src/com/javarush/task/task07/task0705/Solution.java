package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int [] temp = new int[20];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 20; i++) {
            temp[i]=Integer.parseInt(reader.readLine());
        }
        reader.close();
        int [] mas1 = new int[10];
        int [] mas2 = new int[10];
        int j=0;

        for (int i = 0; i < temp.length; i++) {
            if(i<10)
                mas1[i]=temp[i];
            else {
                mas2[j]=temp[i];
                j++;
            }
        }

        for (int i = 0; i <mas2.length ; i++) {
            System.out.println(mas2[i]);
        }
    }
}
