package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        String[] words = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8).split(" ");
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {

        StringBuilder builder = new StringBuilder();
        if (words.length == 0 || words == null) return builder;
        String[] word = words.clone();
        List<String> list = Arrays.asList(word);
        Stack<String> strings = new Stack<>();
        int number = 0;
        int[][] adjMat = new int[words.length][words.length];
        for (int i = 0; i < words.length; i++) {
            char c = list.get(i).toLowerCase().charAt(list.get(i).length() - 1);
            for (int j = 0; j < words.length; j++) {
                if (i != j && c == list.get(j).toLowerCase().charAt(0))
                    adjMat[i][j] = 1;
                else
                    adjMat[i][j] = 0;
            }
        }

        int last = 0;
        while (true){
            String current = list.get(last);
            number = last;
            strings.push(current);
            int k = -1;
            int previous = 0;

        while (!strings.empty() && strings.size() !=words.length) {
            for (int j=previous; j < adjMat.length; j++) {
                if (adjMat[number][j] == 1 && !(strings.contains(list.get(j)))) {
                    strings.push(list.get(j));
                    number =j;
                    k = j;
                    break;
                }
            }
            if (k==-1){
                previous=list.indexOf(strings.peek())+1;
                strings.pop();
                if (!strings.isEmpty()){
                number = list.indexOf(strings.peek());}
            }
            else {previous =0;}
            k=-1; }

            if(strings.size() == words.length){
                while (!strings.isEmpty()){
                    builder.insert(0, " "+strings.pop()); }
                    builder.deleteCharAt(0);
                return builder; }
                else if (last >= words.length) {return builder;}
                else last++; }
                }
}




