package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удваиваем слова
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // Считать строки с консоли и объявить ArrayList list тут
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i <10 ; i++) {
            list.add(reader.readLine()); }

        reader.close();

        ArrayList<String> result = doubleValues(list);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i)); }

        // Вывести на экран result
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        //напишите тут ваш код
        for (int i = 0; i <list.size() ; i++) {
            String str = list.get(i);
            list.add(i+1, str);
            i++;
        }

        return list;
    }
}
