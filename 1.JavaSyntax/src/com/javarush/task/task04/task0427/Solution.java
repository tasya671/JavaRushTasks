package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();

        if ((a>=1)&&(a<=999)){
            if ((a>=1)&&(a<=9)&&((a%2)==0))
                System.out.println("четное однозначное число");
        else if ((a>=1)&&(a<=9)&&((a%2)!=0))
                System.out.println("нечетное однозначное число");
        else if ((a>=10)&&(a<=99)&&((a%2)==0))
                System.out.println("четное двузначное число");
        else if ((a>=10)&&(a<=99)&&((a%2)!=0))
                System.out.println("нечетное двузначное число");
        else if ((a>=100)&&(a<=999)&&((a%2)==0))
                System.out.println("четное трехзначное число");
        else if ((a>=100)&&(a<=999)&&((a%2)!=0))
                System.out.println("нечетное трехзначное число");}

        scanner.close();

    }
}
