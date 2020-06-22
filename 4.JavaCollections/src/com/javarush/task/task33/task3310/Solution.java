package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.*;

public class Solution {

    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> setIds = new HashSet<>();
        strings.stream().forEach(e -> setIds.add(shortener.getId(e)));
        return setIds;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> setStrings = new HashSet<>();
        keys.stream().forEach(e -> setStrings.add(shortener.getString(e)));
        return setStrings;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> testSets = new HashSet<>();
        for (int i = 0; i < elementsNumber ; i++) {
            testSets.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);

        Date begin = new Date();
        Set<Long> testIds = getIds(shortener, testSets);
        Date end = new Date();
        long time = end.getTime() - begin.getTime();
        System.out.printf("Time work method getIds(): %d ms%n", time);

        begin = new Date();
        Set<String> stringSet = getStrings(shortener, testIds);
        end = new Date();
        time = end.getTime() - begin.getTime();
        System.out.printf("Time work method getStrings(): %d ms%n", time);

        if(testSets.size()==stringSet.size() && testSets.containsAll(stringSet)){
            System.out.println("Тест пройден.");
        } else
            System.out.println("Тест не пройден.");
    }

    public static void main(String[] args) {
        StorageStrategy strategy = new HashMapStorageStrategy();
        testStrategy(strategy, 10000);
        StorageStrategy strategy1 = new OurHashMapStorageStrategy();
        testStrategy(strategy1, 10000);
        StorageStrategy strategy2 = new FileStorageStrategy();
        testStrategy(strategy2, 100);
        StorageStrategy strategy3 = new OurHashBiMapStorageStrategy();
        testStrategy(strategy3, 10000);
        StorageStrategy strategy4 = new HashBiMapStorageStrategy();
        testStrategy(strategy4, 10000);
        StorageStrategy strategy5 = new DualHashBidiMapStorageStrategy();
        testStrategy(strategy5, 10000);
    }
}
