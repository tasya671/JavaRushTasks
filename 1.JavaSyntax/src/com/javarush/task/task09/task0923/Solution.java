package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        reader.close();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <text.length() ; i++) {
            if(!text.substring(i,i+1).equals(" "))
                builder.append(text.substring(i,i+1));
        }

        char [] mas = builder.toString().toCharArray();
        ArrayList <Character> list1 = new ArrayList<>();
        ArrayList <Character> list2 = new ArrayList<>();

        for (int i = 0; i <mas.length ; i++) {
            if(isVowel(mas[i]))
                list1.add(mas[i]);
            else
                list2.add(mas[i]);
        }
        for (Character ch:list1) {
            System.out.print(ch+" ");
        }
        System.out.println();
        for (Character ch:list2) {
            System.out.print(ch+" ");
        }
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}