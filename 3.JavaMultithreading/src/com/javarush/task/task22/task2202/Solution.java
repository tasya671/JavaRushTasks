package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null) {
            throw new TooShortStringException();
        }
        String[] r = string.split(" ");
        if (r.length < 5) {
            throw new TooShortStringException();
        } else {
            String rez = r[1]+" "+r[2]+" "+r[3]+" "+r[4];
            return rez;
        }
    }


    public static class TooShortStringException extends RuntimeException {

        public TooShortStringException() {
            super(); }

        public TooShortStringException(Exception exp) {
            super(exp);
        }
    }
}
