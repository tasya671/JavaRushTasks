package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546999));
    }

    public static int sumDigitsInNumber(int number) {
        //напишите тут ваш код
        String text = Integer.toString(number);
        int rez =0;
        for (int i = 0; i < text.length(); i++) {
            Integer l = Character.getNumericValue(text.charAt(i));

            rez+=l;
        }
    return rez;}
}