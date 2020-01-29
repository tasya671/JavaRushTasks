package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object n) {

        if (n == null) return false;
        if (this == n) return  true;
        if (!(n instanceof Solution)) return false;
        Solution other = (Solution)n;

        return Objects.equals(this.first, other.first) && Objects.equals(this.last, other.last);

    }


    @Override
    public int hashCode() {

        return Objects.hash(first, last);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
        System.out.println(new  Solution(null,null).equals(new Solution(null, null)));
    }
}
