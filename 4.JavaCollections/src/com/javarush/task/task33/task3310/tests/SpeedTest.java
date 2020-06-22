package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {

    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids){
        Date begin = new Date();
        strings.stream().forEach(e -> ids.add(shortener.getId(e)));
        Date end = new Date();
        return end.getTime() - begin.getTime();
    }

    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings){
        Date begin = new Date();
        ids.stream().forEach(e -> strings.add(shortener.getString(e)));
        Date end = new Date();
        return end.getTime() - begin.getTime();
    }

    @Test
    public void testHashMapStorage(){
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());
        Set<String> origStrings = new HashSet<>();
        Set<Long> origIds = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            origStrings.add(Helper.generateRandomString());
        }
        long time1 = getTimeToGetIds(shortener1, origStrings, origIds);
        long time2 = getTimeToGetIds(shortener2, origStrings, origIds);

        //Assert.assertEquals(time1, time2, 30);
        Assert.assertTrue(time1 > time2);

        time1 = getTimeToGetStrings(shortener1, origIds, origStrings);
        time2 = getTimeToGetStrings(shortener2, origIds, origStrings);

        Assert.assertEquals(time1, time2, 30);

    }


}
