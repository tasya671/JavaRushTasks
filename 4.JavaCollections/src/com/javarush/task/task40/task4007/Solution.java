package com.javarush.task.task40.task4007;

/* 
Работа с датами
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws ParseException {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        boolean printData = false;
        boolean printTime = false;

        if(date.matches("\\d{1,2}:\\d{1,2}:\\d{1,2}")) {
            printTime = true;
            SimpleDateFormat dateFormat3 = new SimpleDateFormat("HH:mm:ss");
            calendar.setTime(dateFormat3.parse(date));
        }

        if(date.matches("\\d{1,2}\\.\\d{1,2}\\.\\d{4,5}")){
            printData = true;
            SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd.MM.yyyy");
            calendar.setTime(dateFormat2.parse(date));
        }

        if(date.matches("\\d{1,2}\\.\\d{1,2}\\.\\d{4,5}\\s\\d{1,2}:\\d{1,2}:\\d{1,2}")){
            printTime = true;
            printData = true;
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            calendar.setTime(dateFormat1.parse(date));
        }

        if(printData){
            System.out.println("День: " + calendar.get(Calendar.DATE));
            int dayWeek = calendar.get(Calendar.DAY_OF_WEEK)-1 == 0 ? 7 : calendar.get(Calendar.DAY_OF_WEEK)-1;
            System.out.println("День недели: " + dayWeek);
            System.out.println("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH));
            System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR));
            System.out.println("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH));
            System.out.println("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
            System.out.println("Месяц: " + (calendar.get(Calendar.MONTH)+1));
            System.out.println("Год: " + calendar.get(Calendar.YEAR));
        }

        if(printTime){
            System.out.println("AM или PM: " + (calendar.get(Calendar.AM_PM) == 0 ? "AM" : "PM"));
            System.out.println("Часы: " + calendar.get(Calendar.HOUR));
            System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
            System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
            System.out.println("Секунды: " + calendar.get(Calendar.SECOND));
        }
    }
}
