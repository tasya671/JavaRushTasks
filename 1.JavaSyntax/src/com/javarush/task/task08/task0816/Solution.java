package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));
        map.put("Воскресенский", dateFormat.parse("NOVEMBER 28 1991"));
        map.put("Лекарева", dateFormat.parse("JULY 17 1990"));
        map.put("Денисов", dateFormat.parse("JULY 25 1990"));
        map.put("Сухарев", dateFormat.parse("JUNE 22 1988"));
        map.put("Христоев", dateFormat.parse("OCTOBER 14 1987"));
        map.put("Гарновесов", dateFormat.parse("MARCH 22 1991"));
        map.put("Нянин", dateFormat.parse("AUGUST 31 1981"));
        map.put("Якушов", dateFormat.parse("NOVEMBER 28 1989"));
        map.put("Сидорова", dateFormat.parse("OCTOBER 23 1994"));
        return map;

        //напишите тут ваш код
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<String, Date> gert = iterator.next();
            Date date = gert.getValue();
            if (date.getMonth()>=5 && date.getMonth()<8) {
               iterator.remove();
            }
        }

    }

    public static void main(String[] args) throws ParseException {

    }
}
