package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream concolestream = System.out;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        System.setOut(printStream);
        testString.printSomething();
        String [] array = stream.toString().split(" ");
        int [] numb = new int[3];
        int j=0;
        String operand = "";

        for (int i = 0; i <array.length ; i++) {
            try {
                numb[j] = Integer.parseInt(array[i]);
                j++;
            }catch (NumberFormatException exp){
                if(array[i].equals("-")||array[i].equals("+")||array[i].equals("*"))
                    operand = array[i];
            }
        }
            int rezult;
            switch (operand){
                case "+":
                    rezult = numb[0] + numb[1];
                    break;
                case "-":
                    rezult = numb[0] - numb[1];
                    break;
                case "*":
                    rezult = numb[0]*numb[1];
                    break;
                    default:
                        rezult =0;

            }

            System.setOut(concolestream);
        System.out.print(stream.toString().replaceAll("\r\n","")+rezult);
        }


    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

