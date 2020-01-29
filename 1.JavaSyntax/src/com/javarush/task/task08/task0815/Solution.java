package com.javarush.task.task08.task0815;

import java.util.*;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<>();
        map.put("Воскресенский","Игорь");
        map.put("Горбунов","Кирилл");
        map.put("Спиридонов","Роман");
        map.put("Карабко","Михаил");
        map.put("Нянин","Михаил");
        map.put("Гарновесов","Александр");
        map.put("Христоев","Олег");
        map.put("Якушов","Павел");
        map.put("Петев","Николай");
        map.put("Сухарев","Михаил");
        return map;

    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        //напишите тут ваш код
        Collection <String> list = map.values();
        int count = 0;
        for (String nam : list) {
            if(nam.equals(name))
                count++;
        }
        return count; }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        //напишите тут ваш код
        Collection <String> list = map.keySet();
        int count=0;
        for (String nam : list) {
            if(nam.equals(lastName))
                count++;
        }
        return count;

    }

    public static void main(String[] args) {

    }
}
