package com.javarush.task.task03.task0319;

/* 
Предсказание на будущее
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();

        System.out.println(name+" получает "+number1+" через "+number2+" лет.");
        sc.close();
    }
}
