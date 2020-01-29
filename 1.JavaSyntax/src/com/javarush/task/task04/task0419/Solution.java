package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
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
        int d = sc.nextInt();

        int temp = a;
        int [] mas = {a, b, c, d};
        for (int i = 0; i <mas.length ; i++) {
            if (temp<mas[i])
                temp=mas[i];
        }
        System.out.println(temp);
    }
}
