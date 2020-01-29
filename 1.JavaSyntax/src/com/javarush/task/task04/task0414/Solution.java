package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner cs = new Scanner(System.in);
        int year = cs.nextInt();
        int day;
        if((year%400)==0)
            day = 366;
        else if ((year%100)==0)
            day =365;
        else if ((year%4)==0)
            day = 366;
        else day =365;

        System.out.println("количество дней в году: "+day);
    }
}