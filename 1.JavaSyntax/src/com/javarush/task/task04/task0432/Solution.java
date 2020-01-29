package com.javarush.task.task04.task0432;



/* 
Хорошего много не бывает
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        int n = sc.nextInt();
        int i =1;
        while (i<=n){
            System.out.println(text);
            i++;
        }
        sc.close();

    }
}
