package com.javarush.task.task03.task0318;

/* 
План по захвату мира
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        String name;
        int year;
        year = sc.nextInt();
        name = sc.next();
        System.out.println(name +" захватит мир через "+year+" лет. Му-ха-ха!");
        sc.close();


    }
}
