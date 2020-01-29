package com.javarush.task.task31.task3109;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {

        Properties properties = new Properties();
        Path file = Paths.get(fileName);
        String name = file.getFileName().toString();

        try(InputStream stream = Files.newInputStream(file)){
            if (name.endsWith("xml"))
                properties.loadFromXML(stream);
            else
                properties.load(stream);
        } catch (IOException e) {
           return properties;
        }


        return properties;
    }
}
