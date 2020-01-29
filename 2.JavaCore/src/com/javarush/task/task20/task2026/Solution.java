package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };




        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {

        byte count =1;
        byte [][] key = new byte[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if(i!=0){
                    if(a[i][j]!=0 && a[i-1][j]==0 && i-1>=0 && j==0)
                        count++; }
                if(j!=0 && i!=0){
                    if(a[i][j]!=0 && a[i][j-1]==0 && j-1>=0 && a[i-1][j]==0)
                        count++; }
                if(a[i][j]!=0 && i==0){
                    if(j-1>=0){
                        if(a[i][j-1]==0)
                            for (int k = 0; k < j-1; k++) {
                                if(a[i][k]==1) {
                                    count++;
                                    break; } }
                    }
                            key[i][j]=count;}
                    else if(a[i][j]!=0 && a[i-1][j]==0 && i-1>=0)
                        key[i][j]=count;
                else if(a[i][j]!=0 && a[i-1][j]!=0 && i-1>=0)
                    key[i][j]=key[i-1][j];
                }
            }


        return count;
    }
}
