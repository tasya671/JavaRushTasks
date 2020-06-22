package com.javarush.task.task40.task4008;

/* 
Работа с Java 8 DateTime API
*/
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) {
        printDate("9.10.2017 5:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        boolean printData = false;
        boolean printTime = false;
        LocalTime time = LocalTime.now();
        LocalDate date1 = LocalDate.now();
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("H:mm:ss",  Locale.ENGLISH);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("d.M.yyyy", Locale.ENGLISH);


        if(date.matches("\\d{1,2}:\\d{1,2}:\\d{1,2}")) {
            printTime = true;
            time = LocalTime.parse(date, formatter1);
        }

        if(date.matches("\\d{1,2}\\.\\d{1,2}\\.\\d{4,5}")){
            printData = true;
            date1 =  LocalDate.parse(date, formatter2);

        }

        if(date.matches("\\d{1,2}\\.\\d{1,2}\\.\\d{4,5}\\s\\d{1,2}:\\d{1,2}:\\d{1,2}")){
            printTime = true;
            printData = true;
            String[] data = date.split(" ");
            time = LocalTime.parse(data[1], formatter1);
            date1 =  LocalDate.parse(data[0], formatter2);
        }

        if(printData){
            System.out.println("День: " + date1.get(ChronoField.DAY_OF_MONTH));
            System.out.println("День недели: " + date1.get(ChronoField.DAY_OF_WEEK));
            System.out.println("День месяца: " + date1.get(ChronoField.DAY_OF_MONTH));
            System.out.println("День года: " + date1.get(ChronoField.DAY_OF_YEAR));
            System.out.println("Неделя месяца: " + date1.get(ChronoField.ALIGNED_WEEK_OF_MONTH));
            System.out.println("Неделя года: " + date1.get(ChronoField.ALIGNED_WEEK_OF_YEAR));
            System.out.println("Месяц: " + date1.get(ChronoField.MONTH_OF_YEAR));
            System.out.println("Год: " + date1.get(ChronoField.YEAR));
        }

        if(printTime){
            System.out.println("AM или PM: " + (time.get(ChronoField.AMPM_OF_DAY) == 0 ? "AM" : "PM"));
            System.out.println("Часы: " + time.get(ChronoField.CLOCK_HOUR_OF_AMPM));
            System.out.println("Часы дня: " + time.get(ChronoField.HOUR_OF_DAY));
            System.out.println("Минуты: " + time.get(ChronoField.MINUTE_OF_HOUR));
            System.out.println("Секунды: " + time.get(ChronoField.SECOND_OF_MINUTE));
        }
    }
}
