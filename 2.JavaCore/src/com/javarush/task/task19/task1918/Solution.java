package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String test = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(test));
        String tag = args[0];

        String data = "";
        while (fileReader.ready()){
            data+=fileReader.readLine();
        }
        fileReader.close();
        Pattern pattern = Pattern.compile("<"+tag+"(.*?)>(.*?)(</"+tag+">([^"+tag+"]*?))*</"+tag+">");
        Pattern pat = Pattern.compile("(<"+tag+"([^"+tag+"]*?)){1}?>([^/"+tag+"]*?)</"+tag+">");
        Matcher matcher = pattern.matcher(data);
        while (matcher.find()){
            System.out.println(data.substring(matcher.start(),matcher.end()));
            String te =data.substring(matcher.start(),matcher.end());
            Pattern p1 = Pattern.compile(tag);
            Matcher ma = p1.matcher(te);
            int count = 0;
            while (ma.find()){count++; }
            if (count>2){
            Matcher mach = pat.matcher(te);
            while (mach.find()){
                System.out.println(te.substring(mach.start(),mach.end()));
            }}
        }



    }
}
