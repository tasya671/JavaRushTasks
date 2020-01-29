package com.javarush.task.task04.task0424;

/* 
Три числа
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

        int rez = a;
        if ((a!=b)&&(b!=c)&&(a!=c)){
            rez =0; }
        else {if((a==b)&&(a!=c)){
            rez = 3;}
        else if ((a==c)&&(a!=b)){
            rez =2;}
        else if((b==c)&&(c!=a)){
            rez =1;}
            System.out.println(rez);}


        sc.close();
    }
}
