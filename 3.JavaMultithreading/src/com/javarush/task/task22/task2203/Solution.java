package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {

        if (string == null){ throw new TooShortStringException();}

        int first = string.indexOf("\t");
        if (first != -1 && first < string.length()-1){
            int second = string.indexOf("\t", first+1);
            if (second != -1){
                String result = string.substring(first+1, second);
                return result;
            } else throw new TooShortStringException();
        } else throw new TooShortStringException();
    }

    public static class TooShortStringException extends Exception { }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
