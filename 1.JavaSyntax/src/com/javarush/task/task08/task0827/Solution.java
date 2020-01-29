package com.javarush.task.task08.task0827;

import sun.text.resources.FormatData;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) throws ParseException {
        DateFormat formatData = new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH);
        Date dat = formatData.parse(date);
        Calendar calendar1 = new GregorianCalendar();
        calendar1.setTime(dat);
        calendar1.set(Calendar.MONTH, Calendar.JANUARY);
        calendar1.set(Calendar.DAY_OF_MONTH, 1);
        Date date1 = calendar1.getTime();
        long diff = dat.getTime()-date1.getTime();
        int day = (int) (diff/(24*60*60*1000))-1;
        System.out.print(formatData.format(dat)+" = ");

        if(day%2==0){
            return false;}
            else{
                return true;}
    }
}
