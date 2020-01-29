package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        List <Integer> list =new ArrayList<>();

        Scanner reader = new Scanner(System.in);


        for (int i = 0; i <10; i++) {
            list.add(reader.nextInt());
        }

        reader.close();

        Map <Integer, Integer> map = new HashMap<>();

        map.put(list.get(0), 1);

        for (int i = 1; i <list.size(); i++) {

            int tempPrevius = list.get(i-1);
            int temp= list.get(i);
            int count = 1;
            while (temp == tempPrevius  && i<list.size()){
                i++;
                count++;
                if(i<list.size())
                    temp= list.get(i); }

            if(map.containsKey(tempPrevius))
            {if (map.get(tempPrevius)<count)
                    map.put(tempPrevius, count);}
            else
                map.put(tempPrevius, count);
        }

        int number = map.get(list.get(0));

        for (Integer tem: map.values()) {
            if (tem > number)
                number = tem;
        }

        System.out.println(number);

    }
}