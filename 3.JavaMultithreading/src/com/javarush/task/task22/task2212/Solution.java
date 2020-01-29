package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {

        if (telNumber ==null) return false;

        String str = telNumber.replaceAll("\\D","");
        if (str.length() ==12){
        if(telNumber.matches("^\\+\\d+(\\(\\d{3}\\))??\\d+(\\-\\d+){0,2}\\d+$")) return true;}
        else if (str.length() ==10){
        if(telNumber.matches("^(\\(\\d{3}\\))??\\d+(\\-\\d+){0,2}\\d+$")) return true;}

        return false;
    }

    public static void main(String[] args) {

        System.out.println(checkTelNumber("+380501234567"));
        System.out.println(checkTelNumber("+38(050)1234567"));
        System.out.println(checkTelNumber("+38050123-45-67"));
        System.out.println(checkTelNumber("+38)050(1234567"));

    }
}
