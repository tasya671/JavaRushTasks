package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 20; i++) {
            list.add(Integer.parseInt(bufferedReader.readLine()));
        }

        for (int i = 0; i <list.size() ; i++) {
            int temp = list.get(i);
            if(temp%3==0)
                list1.add(temp);
            if (temp%2==0)
                list2.add(temp);
            if (temp%2!=0 & temp%3!=0)
                list3.add(temp);
        }

        printList(list1);
        printList(list2);
        printList(list3);

    }

    public static void printList(ArrayList<Integer> list) {
        //напишите тут ваш код
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i)); }
    }
}
