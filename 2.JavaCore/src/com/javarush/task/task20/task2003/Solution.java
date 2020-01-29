package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.*;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        FileInputStream inputStream = new FileInputStream(name);
        this.load(inputStream);
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
       // PrintStream stream = new PrintStream(outputStream);
        Properties pros = new Properties();
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            pros.setProperty(entry.getKey(), entry.getValue());
        }
        pros.store(outputStream, null);
        outputStream.flush();
      //  pros.list(stream);
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        Properties pro = new Properties();
        pro.load(reader);

        @SuppressWarnings("unchecked")
        Enumeration<String> enums = (Enumeration<String>) pro.propertyNames();
        while (enums.hasMoreElements()){
            String key = enums.nextElement();
            properties.put(key, pro.getProperty(key));
        }
        reader.close();
    }

    public static void main(String[] args) throws Exception {

        Solution solution = new Solution();
        solution.fillInPropertiesMap();
        System.out.println(properties);
        solution.save(new FileOutputStream("D://exemle.txt"));

    }
}
