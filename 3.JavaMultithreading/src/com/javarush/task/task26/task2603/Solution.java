package com.javarush.task.task26.task2603;

import java.util.Comparator;

/*
Убежденному убеждать других не трудно
*/
public class Solution {

    public static void main(String[] args) {

    }

        public static class CustomizedComparator<T> implements Comparator<T>{
            private Comparator<T>[] comparators;

            public CustomizedComparator(Comparator<T>...comparators) {
                this.comparators = comparators; }

            @Override
            public int compare(T o1, T o2) {
                if(comparators.length == 0 || comparators == null) return 0;
                int rez =0;
                for (Comparator<T> comp:comparators) {
                    rez =comp.compare(o1,o2);
                    if(rez!= 0)
                        break;
                }
                return rez;
            }

        }


}
