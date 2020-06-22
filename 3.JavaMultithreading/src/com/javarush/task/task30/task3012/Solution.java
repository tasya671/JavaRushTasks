package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        //напишите тут ваш код
        if (number>=1 & number<=3000){
        StringBuilder builder = new StringBuilder();
        builder.append(number+" =");

        ArrayList<Integer> view = new ArrayList<>();
        while (number>0){
            int q = number/3;
            int r = number%3;
            if(r<=1){
                view.add(r);
            } else {
                r = 3 - r;
                view.add(-r);
                q++;
            }
            number=q;
        }
        Collections.reverse(view);

        List<Integer> list = new ArrayList<>();
        int k = 0;
        for (int i = view.size()-1; i>=0 ; i--) {
                list.add((view.get(i)*(int) Math.pow(3, k++)));
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                    o1 = Math.abs(o1);
                return o1.compareTo(Math.abs(o2));
            }
        });
        list.stream().forEach(v ->{
            if(v == 0){ }
            else if(v>0)
                builder.append(" + "+v);
            else
                builder.append(" - "+ Math.abs(v));
        });
        System.out.println(builder.toString());
        }
    }
}