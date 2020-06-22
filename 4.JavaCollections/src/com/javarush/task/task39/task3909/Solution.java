package com.javarush.task.task39.task3909;

/* 
Одно изменение
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isOneEditAway("свода", "вода"));
    }

    public static boolean isOneEditAway(String first, String second) {
        if (first.equals(second)) return true;
        int [] firstArray = new int[first.length()];
        int [] secondArray = new int[second.length()];
        for (int i = 0; i < first.length(); i++) {
            firstArray[i] = first.charAt(i);
        }
        for (int i = 0; i < second.length(); i++) {
            secondArray[i] = second.charAt(i);
        }
        int count =0;
        if(first.length()==second.length()){
            for (int i = 0; i < first.length(); i++) {
                if (count > 1) return false;
                if(firstArray[i] != secondArray[i]) count++;
            }
        } else if (Math.abs(first.length()-second.length())==1){
            if(first.length() < second.length()){
                int [] temp = secondArray;
                secondArray = firstArray;
                firstArray = temp;
            }
            for (int i = 0, k=0; i <firstArray.length & k<secondArray.length ; i++) {
                if (count > 1) return false;
                if (firstArray[i]!=secondArray[k]){
                    count++;
                } else
                    k++;
            }
        } else { return false;}
        return (count>1)? false: true;
    }
}
