package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны
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

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
        Collection<String> les = map.values();
        Set<String> list = new HashSet<>();
        for (String na :les) {
            int count = Collections.frequency(les, na);
            if (count>=2)
                list.add(na); }
        for (String value:list) {
            removeItemFromMapByValue(map, value); }
        }


    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {

    }
}
