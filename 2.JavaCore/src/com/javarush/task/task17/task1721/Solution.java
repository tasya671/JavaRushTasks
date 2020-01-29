package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public void joinData() throws CorruptedDataException {
        if(allLines.containsAll(forRemoveLines)){
                allLines.removeAll(forRemoveLines);}
                else {
                    allLines.clear();
                    throw new CorruptedDataException();}
        }

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileone = reader.readLine();
            String filetwo = reader.readLine();
            reader.close();

            BufferedReader reader1 = new BufferedReader(new FileReader(new File(fileone)));
            BufferedReader reader2 = new BufferedReader(new FileReader(new File(filetwo)));

            String text1;
            while ((text1=reader1.readLine())!=null){
                allLines.add(text1);
            }

            reader1.close();


            while ((text1=reader2.readLine())!=null){
                forRemoveLines.add(text1);
            }

            reader2.close();

            new Solution().joinData();

        } catch (CorruptedDataException exp){ exp.printStackTrace();
        } catch (IOException exp){exp.printStackTrace();}



    }


}
