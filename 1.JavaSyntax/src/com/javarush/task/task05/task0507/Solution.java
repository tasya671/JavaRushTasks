package com.javarush.task.task05.task0507;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Среднее арифметическое
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();

        while (true){
            int number = scanner.nextInt();
            if (number!=-1)
                arrayList.add(number);
            else break;
        }

        scanner.close();

        int sum =0;
        for (int i = 0; i < arrayList.size(); i++) {
            sum+=arrayList.get(i); }


        System.out.println((double) sum/arrayList.size());
    }
}

