package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;

public class FunctionalTest {

    public void testStorage(Shortener shortener){
        String str1 = Helper.generateRandomString();
        String str2 = Helper.generateRandomString();
        String str3 = str1;

        Long id1 = shortener.getId(str1);
        Long id2 = shortener.getId(str2);
        Long id3 = shortener.getId(str3);

        Assert.assertNotEquals(id1, id2);
        Assert.assertEquals(id1, id3);

        String resStr1 = shortener.getString(id1);
        String resStr2 = shortener.getString(id2);
        String resStr3 = shortener.getString(id3);

        Assert.assertEquals(str1, resStr1);
        Assert.assertEquals(str2, resStr2);
        Assert.assertEquals(str3, resStr3);
    }

    @Test
    public void testHashMapStorageStrategy(){
        StorageStrategy strategy = new HashMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }
    @Test
    public void testOurHashMapStorageStrategy(){
        StorageStrategy strategy = new OurHashMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
     }
     @Test
    public void testFileStorageStrategy(){
         StorageStrategy strategy = new FileStorageStrategy();
         Shortener shortener = new Shortener(strategy);
         testStorage(shortener);
    }
    @Test
    public void testHashBiMapStorageStrategy(){
        StorageStrategy strategy = new HashBiMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }
    @Test
    public void testDualHashBidiMapStorageStrategy(){
        StorageStrategy strategy = new DualHashBidiMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }
    @Test
    public void testOurHashBiMapStorageStrategy(){
        StorageStrategy strategy = new OurHashBiMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }


}
