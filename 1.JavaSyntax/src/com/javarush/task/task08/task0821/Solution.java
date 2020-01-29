package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        Map<String, String> map = new HashMap<>();
        map.put("Воскресенский","Игорь");
        map.put("Горбунов","Кирилл");
        map.put("Спиридонов","Роман");
        map.put("Карабко","Михаил");
        map.put("Нянин","Михаил");
        map.put("Гарновесов","Александр");
        map.put("Христоев","Олег");
        map.put("Якушов","Павел");
        map.put("Карабко","Николай");
        map.put("Карабко","Михаил");
        return map;

    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
