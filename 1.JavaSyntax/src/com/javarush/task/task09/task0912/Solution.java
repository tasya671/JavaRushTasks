package com.javarush.task.task09.task0912;

/* 
Исключение при работе с числами
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try{
            int num = Integer.parseInt("XYZ");
            System.out.println(num);
        } catch (NumberFormatException exp){
            System.out.println(exp);
        }

        //напишите тут ваш код
    }
}
