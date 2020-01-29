package com.javarush.task.task03.task0322;


/* 
Большая и чистая
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        String name1 = sc.next();
        String name2 = sc.next();
        String name3 = sc.next();
        System.out.println(name1+" + "+name2+" + "+ name3+" = Чистая любовь, да-да!");
        sc.close();
    }
}