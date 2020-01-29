package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а','б','в','г','д','е','ё','ж',
                'з','и','й','к','л','м','н','о',
                'п','р','с','т','у','ф','х','ц',
                'ч','ш','щ','ъ','ы','ь','э','ю','я');

        Map <Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i <alphabet.size() ; i++) {
            map.put(alphabet.get(i),0); }

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        reader.close();

        for (int i = 0; i <list.size() ; i++) {
            String text = list.get(i).toLowerCase();
            char [] array = text.toCharArray();
            for (int j = 0; j <array.length; j++) {
                int index = alphabet.indexOf(array[j]);
                if (index>=0) {
                map.put(alphabet.get(index), map.get(alphabet.get(index))+1);
                }
            }
        }
        for (Map.Entry<Character, Integer> entry:map.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

    }
}
