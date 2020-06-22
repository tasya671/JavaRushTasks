package com.javarush.task.task40.task4009;

/* 
Buon Compleanno!
*/

import javax.swing.text.Style;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getWeekdayOfBirthday("30.05.1984", "2015"));
    }

    public static String getWeekdayOfBirthday(String birthday, String year) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy", Locale.ITALIAN);
        LocalDate localDate = LocalDate.parse(birthday, formatter);
        LocalDate result = localDate.withYear(Year.parse(year).getValue());

        return result.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ITALIAN);
    }
}
