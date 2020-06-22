package com.javarush.task.task35.task3512;

public class Generator<T> {

    private Class<T> clazz;

    public Generator(Class<T> eventClass) {
        this.clazz = eventClass;
    }

    T newInstance() {
        try {
            return (T) clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
