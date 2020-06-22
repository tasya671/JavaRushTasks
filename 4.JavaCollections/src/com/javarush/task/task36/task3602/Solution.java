package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Найти класс по описанию
*/

public class Solution {
    public static void main(String[] args) throws ClassNotFoundException {
            System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() throws ClassNotFoundException {
           List<Class> list = Arrays.asList(Class.forName("java.util.Collections").getDeclaredClasses());
           List<Class> target = list.stream().filter(k ->(
                   Modifier.isPrivate(k.getModifiers()) && Modifier.isStatic(k.getModifiers()) && List.class.isAssignableFrom(k)))
                   .collect(Collectors.toList());
        for (Class clazz : target) {
            try {
                Constructor constructor = clazz.getDeclaredConstructor();
                constructor.setAccessible(true);
                List list1 = (List) constructor.newInstance();
                Method method = clazz.getDeclaredMethod("get", int.class);
                method.setAccessible(true);
                method.invoke(list1, 0);
            } catch (InvocationTargetException exp) {
                if (exp.getCause().getClass().getSimpleName().equals("IndexOutOfBoundsException")) {
                    return clazz; }
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException ex) { }
        }
        return null;
    }
}
