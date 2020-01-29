package com.javarush.task.task03.task0314;

/* 
Таблица умножения
*/

public class Solution {

    public static void print(int[] a){
        for (int i=0; i<a.length; i++){
            System.out.print(a[i]+" ");}
            System.out.println();
        }
    public static void sum(int l, int [] a) {
        a[0] = a[0] + l;
        for (int i = 1; i < a.length; i++) {
            a[i] = a[i - 1] + l;
        }
    }
    public static void zero(int [] a){
            for (int i=0; i<a.length; i++){
                a[i]=0;
            }
        }


    public static void main(String[] args) {
        //напишите тут ваш код
        int [] rez = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i=1; i<=10; i++){
            sum(i, rez);
            print(rez);
            zero(rez);
        }
    }
}
