package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String number = bufferedReader.readLine();
        int [] mas = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            mas[i]=Character.getNumericValue(number.charAt(i));
            if(mas[i]%2==0)
                even++;
            else odd++;
        }
        System.out.println("Even: "+ even + " Odd: " + odd);

        bufferedReader.close();
    }
}
