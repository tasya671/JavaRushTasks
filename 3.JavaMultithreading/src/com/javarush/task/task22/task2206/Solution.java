package com.javarush.task.task22.task2206;

import java.util.Date;

/* 
Форматирование даты
*/
public class Solution {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(String.format(getFormattedString(), date, date, date, date, date, date));
        //должен быть вывод аналогичный следующему
        //31:10:13 15:59:59 (число:месяц:год часы:минуты:секунды)
    }

    public static String getFormattedString() {
        return "%1$td:%2$tm:%3$ty %4$tH:%5$tM:%6$tS";
    }
}
