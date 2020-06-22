package com.javarush.task.task34.task3413;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache {
    private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();

    public AnyObject get(Long key) {
        if (cacheMap.containsKey(key) & cacheMap.get(key)!= null){
        SoftReference<AnyObject> softReference = cacheMap.get(key);
        AnyObject object = softReference.get();
        softReference.clear();
        return object;
        }
        return null;
    }

    public AnyObject put(Long key, AnyObject value) {
        if (cacheMap.containsKey(key) & cacheMap.get(key)!= null){
            SoftReference<AnyObject> softReference = cacheMap.get(key);
            AnyObject object = softReference.get();
            softReference.clear();
            cacheMap.put(key, new SoftReference<>(value));
            return object;
        } else {
            cacheMap.put(key, new SoftReference<>(value));
            return null; }
    }

    public AnyObject remove(Long key) {

        if (cacheMap.containsKey(key) & cacheMap.get(key)!= null){
            SoftReference<AnyObject> softReference = cacheMap.get(key);
            AnyObject object = softReference.get();
            softReference.clear();
            cacheMap.remove(key);
            return object;
        }  else {
            return null;
        }
    }
}