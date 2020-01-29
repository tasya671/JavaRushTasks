package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner cs = new Scanner(System.in);
        cs.useLocale(Locale.ENGLISH);

        double number = cs.nextDouble();

        double cicle = number%5;

        if ((cicle>=0)&&(cicle<3))
            System.out.println("зеленый");
        else if ((cicle>=3)&&(cicle<4))
            System.out.println("желтый");
        else if ((cicle>=4)&&(cicle<5))
            System.out.println("красный");
        cs.close();
    }
}