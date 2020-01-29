package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i <10 ; i++) {
            list.add(reader.readLine()); }

        reader.close();
        int number=0;

        for (int i = 0; i < list.size()-1; i++) {
            if(list.get(i).length()>list.get(i+1).length())
            { number = i+1;
            break;} else
                number =-1;
        }

        if (number!=-1)
            System.out.println(number);
    }
}

