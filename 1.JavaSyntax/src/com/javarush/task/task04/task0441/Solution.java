package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c= sc.nextInt();

        int [] mas = {a, b, c};

        for (int out = mas.length-1; out >=1 ; out--) {
            for (int in = 0; in <out ; in++) {
                if(mas[in]>mas[in+1]){
                    int temp = mas[in];
                    mas[in]= mas[in+1];
                    mas[in+1]= temp;
                }


            }
        }
        System.out.print(mas[1]);
        sc.close();
    }
}
