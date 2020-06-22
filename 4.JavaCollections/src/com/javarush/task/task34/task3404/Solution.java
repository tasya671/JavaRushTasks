package com.javarush.task.task34.task3404;

import javax.sound.midi.Soundbank;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Рекурсия для мат. выражения
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recurse("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
    }

    public void recurse(final String expression, int countOperation) {
        //implement
        Pattern p = Pattern.compile("\\([^\\(\\)]*\\)");
        Matcher matcher = p.matcher(expression);
        if (matcher.find()) {
            String res = expression.substring(matcher.start(), matcher.end());
            System.out.println(res);
            Stack<String> ops = new Stack<>();
            Stack<Double> vals = new Stack<>();
            Pattern p1 = Pattern.compile("(-)?[0-9//.]+?");
            Matcher matcher1 = p1.matcher(res);
            if (matcher1.find()) {
                String res1 = res.substring(matcher1.start(), matcher1.end());
                System.out.println(res1);


//            double result;
//            DecimalFormat dF = new DecimalFormat("#.##");
//            dF.setRoundingMode(RoundingMode.UP);
//            System.out.println(dF.format(result) + " " + countOperation);
            }
        }
    }

    public Solution() {
        //don't delete
    }
}
