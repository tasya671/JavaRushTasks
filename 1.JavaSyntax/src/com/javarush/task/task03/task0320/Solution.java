package com.javarush.task.task03.task0320;


/* 
Скромность украшает программиста
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        System.out.println(name+" зарабатывает $5,000. Ха-ха-ха!");
        sc.close();
    }
}
