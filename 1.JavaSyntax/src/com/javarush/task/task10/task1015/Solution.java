package com.javarush.task.task10.task1015;

import java.util.*;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
        List<String> list =Arrays.asList("Ветер", "Не приносит облегчение", "Усталость", "Я больше не твоя марионетка");
        ArrayList<String> text[] = new ArrayList[10];
        for (int i = 0; i <text.length ; i++) {
            text[i]=new ArrayList<>();
            text[i].addAll(list);
        }


        return text;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}