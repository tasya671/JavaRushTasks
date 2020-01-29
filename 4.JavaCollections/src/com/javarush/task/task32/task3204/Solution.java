package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;

/* 
Генератор паролей
*/
public class Solution {
    static Map<Integer, String> map= new HashMap();

    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
        System.out.println(getPassword().toString());
        System.out.println(getPassword().toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        String password;
        Random random = new Random();
        do{
        int countLat = 1+random.nextInt(6);
        int countNum = 1+random.nextInt(7-countLat);
        int countP = 8 - countLat - countNum;

        List<Character> list = new ArrayList<>();
        for (int i = 0; i <countLat ; i++) {
            list.add((char) (97+random.nextInt(26)));
        }
        for (int i = 0; i <countNum ; i++) {
            list.add((char) (48+random.nextInt(10)));
        }
        for (int i = 0; i < countP; i++) {
            list.add((char) (65+random.nextInt(26)));
        }

        Collections.shuffle(list);
        Object[] array =  list.toArray();
        char [] res = new char[array.length];
        for (int i = 0; i <array.length ; i++) {
            res[i]=(char)array[i];
        }
        password = new String(res);
        }
        while (map.containsKey(password.hashCode()));
        map.put(password.hashCode(), password);
        outputStream.write(password.getBytes());

        return outputStream;
    }
}