package com.javarush.task.task39.task3908;

import java.util.Arrays;

/*
Возможен ли палиндром?
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("топот"));
    }

    public static boolean isPalindromePermutation(String s) {
        if (s == null || s.equals("")) return false;
        String revers = new StringBuilder(s).reverse().toString();
        if (s.equalsIgnoreCase(revers)) return true;
        int[] array = new int[s.length()];
        for (int i = 0; i < s.length() ; i++) {
            array[i] = s.charAt(i);
        }
        Arrays.sort(array);
        int [] permutation;
        while ((permutation = nextPermutation(array))!=null){
            StringBuilder res = new StringBuilder();
            for (int i = 0; i <permutation.length ; i++) {
            res.append((char) permutation[i]);
            }
            if(res.toString().equalsIgnoreCase(res.reverse().toString()))
            return true;
        }
        return false;
    }

    private static int[] nextPermutation(int [] array){
        int count = array.length-1;
        while (--count >= 0 && array[count] >= array[count+1]) { }
        if (count == -1)
            return null;
        for (int j = count+1, k = array.length -1; j < k; j++, k--) {
            int temp = array[j];
            array[j] = array[k];
            array[k] = temp;
        }
        int j = count+1;
        while (array[j]<=array[count])
            j++;
        int temp = array[count];
        array[count] = array[j];
        array[j] = temp;
        return array;
    }
}
