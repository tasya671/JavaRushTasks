package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b =sc.nextInt();
        int c = sc.nextInt();

        int [] mas = {a, b, c};
        int out, in;

        for (out = mas.length-1; out>=1; out--) {
            for (in = 0; in < out; in++){
                if (mas[in] < mas[in + 1]) {
                    int temp = mas[in];
                    mas[in] = mas[in + 1];
                    mas[in + 1] = temp;
                }
            }
        }
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i]+" "); }
        }
    }
