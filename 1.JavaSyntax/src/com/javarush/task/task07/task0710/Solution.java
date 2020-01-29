package com.javarush.task.task07.task0710;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
В начало списка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList <String> list= new ArrayList<>();
        for (int i = 9; i >=0 ; i--) {
            list.add(" ");}
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 9; i >=0 ; i--) {
            list.set(i, reader.readLine());
        }
        reader.close();
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }
    }
}
