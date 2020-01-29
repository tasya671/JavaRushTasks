package com.javarush.task.task05.task0528;

/* 
Вывести на экран сегодняшнюю дату
*/

import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Date date = new Date();
        int day = date.getDate();
        int motday = date.getMonth()+1;
        int year = 1900+date.getYear();
        System.out.println(day+" "+motday+" "+year);

    }
}
