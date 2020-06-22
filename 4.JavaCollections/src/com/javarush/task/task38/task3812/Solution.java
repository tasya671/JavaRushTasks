package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
        if(c.isAnnotationPresent(PrepareMyTest.class)){
            PrepareMyTest test = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            String [] elements = test.fullyQualifiedNames();
            for (int i = 0; i < elements.length; i++) {
                System.out.println(elements[i]);
            }
            return true;
        }
        return false;
    }

    public static boolean printValues(Class c) {
        if(c.isAnnotationPresent(PrepareMyTest.class)){
            PrepareMyTest test = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            Class<?> [] values = test.value();
            for (int i = 0; i < values.length; i++) {
                System.out.println(values[i].getSimpleName());
            }
            return true;
        }
        return false;
    }
}
