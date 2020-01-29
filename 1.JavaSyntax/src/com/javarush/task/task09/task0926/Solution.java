package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        int [] mas1 = {5, 7, 3, 1, 7};
        int [] mas2 ={4, 6};
        int [] mas3 = {8, 1, 2, 6};
        int [] mas4 = {6, 8, 11, 43, 5, 9, 7};
        int [] mas5 ={};

        ArrayList<int[]> list= new ArrayList<>();
        list.add(mas1);
        list.add(mas2);
        list.add(mas3);
        list.add(mas4);
        list.add(mas5);
        return list;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
