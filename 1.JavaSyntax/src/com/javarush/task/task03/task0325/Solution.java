package com.javarush.task.task03.task0325;

import java.io.*;
import java.util.Scanner;

/* 
Финансовые ожидания
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner cs = new Scanner(System.in);
        int number = cs.nextInt();
        System.out.println("Я буду зарабатывать $" + number + " в час");
        cs.close();
    }
}
