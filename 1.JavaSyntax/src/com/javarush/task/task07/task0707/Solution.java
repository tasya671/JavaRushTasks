package com.javarush.task.task07.task0707;

import java.util.ArrayList;
import java.util.List;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();

        list.add("Лось");
        list.add("Время");
        list.add("Ветер");
        list.add("Запад");
        list.add("Терем");

        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
