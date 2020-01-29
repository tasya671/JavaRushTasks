package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {

        Solution [] solutions = new Solution[2];
        Solution solutions1 = new Solution();
        solutions1.innerClasses[0] = solutions1.new InnerClass();
        solutions1.innerClasses[1]=solutions1.new InnerClass();
        Solution solutions2 = new Solution();
        solutions2.innerClasses[0]=solutions2.new InnerClass();
        solutions2.innerClasses[1]=solutions2. new InnerClass();
        solutions[0] = solutions1;
        solutions[1] = solutions2;

        return solutions;
    }

    public static void main(String[] args) {

    }
}
