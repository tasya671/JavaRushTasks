package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) {
                break;
            }
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        // напишите тут ваш код
        int coutW =0;
        int countN=0;

        for (int i = 0; i < array.length; i++) {
            if(!isNumber(array[i])){
                coutW++;
            } else
                countN++;
        }

        String [] text = new String[coutW];
        int [] number = new int[countN];
        int in=0;
        int it =0;

        for (int i = 0; i < array.length; i++) {
            if(!isNumber(array[i])){
                text[it]=array[i];
                it++;
            } else {
                number[in]=Integer.parseInt(array[i]);
                in++;
            }
        }
            for (int j = text.length-1; j >=1 ; j--){
                for (int k = 0; k < j; k++){
                if(isGreaterThan(text[k], text[k+1])){
                    String temp = text[k];
                    text[k]=text[k+1];
                    text[k+1] = temp;
                }
                }
            }
            for (int j = number.length-1; j >=1 ; j--) {
                for (int k = 0; k < j; k++) {
                    if (number[k] < number[k+1]) {
                        int temp = number[k];
                        number[k]=number[k+1];
                        number[k+1]=temp;
                    }
                }
            }
            in=0;
            it=0;
            for (int j = 0; j < array.length; j++) {
                if (isNumber(array[j])){
                    array[j]=String.valueOf(number[in]);
                    in++;
                }else {
                    array[j]=text[it];
                    it++;
                }
            }
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
