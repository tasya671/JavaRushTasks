package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner cs = new Scanner(System.in);
        int number = cs.nextInt();
        if(number>0)
            number*=2;
        else if (number<0)
            number++;
        System.out.println(number);
        cs.close();

    }

}