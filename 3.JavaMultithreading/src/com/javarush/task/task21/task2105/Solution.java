package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Solution) || (o == null))
            return false;
        if (this == o)return true;
        Solution n = (Solution) o;

        if (this.first != null ? !this.first.equals(n.first) : n.first != null) return false;
        if (this.last != null ? !this.last.equals(n.last) : n.last != null) return false;

        return true;
    }

    @Override
    public int hashCode() {

        return Objects.hash(first, last);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
