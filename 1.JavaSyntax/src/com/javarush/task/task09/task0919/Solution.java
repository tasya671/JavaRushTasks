package com.javarush.task.task09.task0919;

/* 
Деление на ноль
*/

public class Solution {

    public static void main(String[] args) {
        try{
            divideByZero();}
        catch (ArithmeticException exp){
            System.out.println(exp);
            exp.printStackTrace();
        }
    }


    public static void divideByZero(){
        System.out.println(50/0);
    }
}
