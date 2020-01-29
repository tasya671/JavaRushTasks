package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int []mas ={a,b,c};

        int negativ =0;
        int positiv =0;

        for (int i = 0; i < mas.length ; i++) {
            if(mas[i]>0)
                positiv++;
            else if (mas[i]<0)
                negativ++;
        }
        System.out.println("количество отрицательных чисел: "+negativ);
        System.out.println("количество положительных чисел: "+positiv);
        sc.close();

    }
}
