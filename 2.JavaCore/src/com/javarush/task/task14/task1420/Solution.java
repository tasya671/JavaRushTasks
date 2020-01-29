package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        int number1, number2;
        int max =1;
        int nod =1;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            number1 = Integer.parseInt(reader.readLine());
            number2 = Integer.parseInt(reader.readLine());
            reader.close();
            if (number1 <= 0 || number2 <= 0) throw new Exception();
            max = Math.min(number1, number2);
            for (int i = max; i >=1; i--) {
                if(number1%i==0 && number2%i==0){
                    nod =i;
                    System.out.println(nod);
                    break;}
            }


        }

    }
