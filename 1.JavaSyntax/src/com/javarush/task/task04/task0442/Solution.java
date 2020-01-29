package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int rez=0;
        while (true){
            int a = sc.nextInt();
            rez+=a;
            if(a==-1)
                break;
        }
        System.out.println(rez);

    }
}
