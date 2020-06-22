package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever {

    private OriginalRetriever retriever;
    private LRUCache<Long, Object> cache;

    public CachingProxyRetriever(Storage storage) {
        this.retriever = new OriginalRetriever(storage);
        this.cache = new LRUCache<>(16);
    }

    @Override
    public Object retrieve(long id) {
        Object object = cache.find(id);
        if(object == null){
            object = retriever.retrieve(id);
            cache.set(id, object);
        }
        return object;
    }
}
