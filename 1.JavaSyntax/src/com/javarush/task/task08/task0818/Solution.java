package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        //напишите тут ваш код
        Map<String, Integer> map = new HashMap<>();
        map.put("Воскресенский", 1000);
        map.put("Горбунов",100);
        map.put("Спиридонов",1500);
        map.put("Карабко",200);
        map.put("Нянин",250);
        map.put("Гарновесов",10000);
        map.put("Христоев",420);
        map.put("Якушов",700);
        map.put("Петев",450);
        map.put("Сухарев",870);
        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        //напишите тут ваш код
        Map <String, Integer> copy = new HashMap<>(map);
        for (Map.Entry<String, Integer> pair: copy.entrySet()) {
            if(pair.getValue()< 500)
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {


    }
}