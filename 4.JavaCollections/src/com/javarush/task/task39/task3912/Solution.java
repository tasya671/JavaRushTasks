package com.javarush.task.task39.task3912;

/* 
Максимальная площадь
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static int maxSquare(int[][] matrix) {
        int side = 0;
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j*i == 0) continue;
                if (matrix[i][j] == 1)
                    matrix[i][j]= Math.min(Math.min(matrix[i-1][j-1], matrix[i][j-1]), matrix[i-1][j]) + 1;
                if (matrix[i][j] > side) side = matrix[i][j];
                }
            }
        return side*side;
    }
}

