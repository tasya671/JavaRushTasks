package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public volatile static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name;
        while (!(name = reader.readLine()).equals("exit")){
            new ReadThread(name).start();
        }

        reader.close();

    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            super(fileName);
            //implement constructor body
        }


        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try {
                FileInputStream stream = new FileInputStream(this.getName());
                int i;
                Map <Integer,Integer> map = new HashMap<>();
                while (stream.available()>0){
                    i = stream.read();
                    if (map.containsKey(i)){
                        map.put(i, map.get(i)+1);
                    } else
                        map.put(i, 1);
                }
                int count =0;
                int rez =0;
                for (Map.Entry<Integer, Integer> etry : map.entrySet()) {
                    if(etry.getValue()>count){
                        rez = etry.getKey();
                        count = etry.getValue();
                    }
                }
                synchronized (resultMap){
                    resultMap.put(this.getName(), rez);
                }
                stream.close();


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
