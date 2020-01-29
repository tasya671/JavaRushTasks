package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


    public static void writeMessage(String message){
        System.out.println(message);
    }


    public static String readString(){
        String str;
        while (true){
            try {
                if ((str = bufferedReader.readLine()) != null)
                    break;
            }catch (IOException exp){ System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз."); }
        }
        return str;
    }


    public static int readInt(){
        int number;
        while (true){
            try {
                number = Integer.parseInt(readString());
                break;
            } catch (NumberFormatException exp){ System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз."); }
        }
        return number;
    }
}
