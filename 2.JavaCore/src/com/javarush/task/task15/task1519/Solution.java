package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text;
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "-"));
        while (true){
            text = reader.readLine();
            if(text.equals("exit"))
                break;
            for (int i = 0; i <text.length() ; i++) {
                if(!list.contains(text.substring(i,i+1))){
                    print(text);
                    break;}
                if (i == text.length()-1){
                    for (int j = 0; j <text.length() ; j++) {
                        if (text.substring(j, j+1).equals(".")){
                            double d = Double.parseDouble(text);
                            print(d);
                            break;}
                        if (j == text.length()-1){
                            int a = Integer.parseInt(text);
                            if(a>0 && a<128)
                                print((short) a);
                            else if (a<=0 || a>=128)
                                print((Integer) a);
                        }
                    }
                }
            }
        }
    }


    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
