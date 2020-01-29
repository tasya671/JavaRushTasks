package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();
        reader.close();
        if (args.length != 0) {

            if (args[0].equals("-c")) {
                List<String> product = new ArrayList<>();
                BufferedReader reader1 = new BufferedReader(new FileReader(nameFile));
                String line;
                while ((line = reader1.readLine()) != null) {
                    product.add(line);
                }
                reader1.close();
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < product.size(); i++) {
                    String last = ((product.get(i)).substring(0, 8)).replaceAll("\\D+","");
                    list.add(Integer.parseInt(last));
                }
                Collections.sort(list);
                int idLast = list.get(list.size() - 1);
                BufferedWriter outputStream = new BufferedWriter(new FileWriter(nameFile, true));
                String news = String.format("%-8d%-30s%-8s%-4s", ++idLast, args[1].replaceAll("_", " "), args[2], args[3]);
                System.out.println(news);


                outputStream.write("\n"+news);
                outputStream.flush();
                outputStream.close();


            }
        }
    }
}
