package com.javarush.task.task26.task2601;

import java.util.*;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
//        Integer[]array = {13, 8, 15, 5, 17};
   //   Integer[]arrays = {2, 8, 7, 1, 3, 5, 6, 4};
   //    System.out.println(Arrays.toString(sort(arrays)));
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        int median;
        if (array.length%2==1){
            int numberMedian = array.length/2;
            median = medianFind(array, 0,array.length-1, numberMedian);
        }
        else{
            int numberMedianlow =array.length/2-1;
            int numberMedianhei = array.length/2;
            int median1 = medianFind(array, 0,array.length-1, numberMedianlow);
            int median2 =medianFind(array, 0,array.length-1, numberMedianhei);
            median = (median1+median2)/2;
        }

        List<Integer> list = Arrays.asList(array);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int a = Math.abs(median -o1);
                int b = Math.abs(median -o2);
                if (a!=b)
                    return a-b;
                else
                   return o1-o2;
            }
        });
        return (Integer[]) list.toArray();
    }

    public static int partition(Integer[] array, int begin, int end){
        int x = array[end];
        int i = begin-1;
        for (int j = begin; j<= end-1; j++) {
            if(array[j]<x){
                i++;
                int a = array[j];
                array[j]=array[i];
                array[i]=a;
            }
        }
        x = array[end];
        array[end]=array[i+1];
        array[i+1]=x;
        return i+1;
    }

    public static int medianFind(Integer[] array, int begin, int end, int n){
        if(begin==end)
            return array[begin];
        int q = partition(array, begin, end);
        int k = q-begin;
        if(n==k)
            return array[q];
        else if (n<k)
            return medianFind(array,begin,q-1,n);
        else
            return medianFind(array,q+1,end,n-k-1);
    }
}
