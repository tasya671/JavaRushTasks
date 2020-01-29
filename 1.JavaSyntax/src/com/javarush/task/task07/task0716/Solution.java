package com.javarush.task.task07.task0716;

import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("роза");
        strings.add("лоза");
        strings.add("лира");
        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {
        //напишите тут ваш код
        ArrayList <String> rezult = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            String str = strings.get(i);
            if (str.contains("л") && str.contains("р"))
                rezult.add(str);
            else if(str.contains("л")) {
                rezult.add(str);
                rezult.add(str); }
            else if (!str.contains("л") && !str.contains("р"))
                rezult.add(str);}


        return rezult;
    }
}