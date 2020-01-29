package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();
        reader.close();
        if (args.length != 0) {

            Map<Integer, String> product = new LinkedHashMap<>();
            BufferedReader reader1 = new BufferedReader(new FileReader(nameFile));
            String line;
            while ((line = reader1.readLine()) != null) {
                int id = Integer.parseInt(line.substring(0,8).replaceAll("\\D+",""));
                product.put(id, line);

            }
            reader1.close();

            if(args[0].equals("-u")){

                int findId = Integer.parseInt(args[1]);
                for (Map.Entry<Integer, String> enry: product.entrySet()) {
                    int key = enry.getKey();
                    if(key==findId) {
                        String update = String.format("%-8d%-30s%-8s%-4s", key, args[2].replaceAll("_", " "), args[3], args[4]);
                        enry.setValue(update);
                        break;}
                }
            } else if (args[0].equals("-d")){
                int findId = Integer.parseInt(args[1]);
                int key =0;
                for (Map.Entry<Integer, String> enry: product.entrySet()) {
                    key = enry.getKey();
                    if(key==findId) break; }
                if(key==findId) {product.remove(key); } }

        BufferedWriter outputStream = new BufferedWriter(new FileWriter(nameFile));
            Object[] array = product.keySet().toArray();

            outputStream.write(product.get((Integer)array[0]));
            outputStream.flush();

        for (Map.Entry<Integer, String> enry: product.entrySet()) {
            if (enry.getKey()!=(Integer)array[0]){
            outputStream.write("\n"+enry.getValue());
            outputStream.flush();}
        }
            outputStream.close(); }
    }
}
