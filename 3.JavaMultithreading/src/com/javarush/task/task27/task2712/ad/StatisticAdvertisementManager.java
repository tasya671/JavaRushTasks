package com.javarush.task.task27.task2712.ad;

import java.util.List;
import java.util.stream.Collectors;

public class StatisticAdvertisementManager {

    public static StatisticAdvertisementManager instance;
    private AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private StatisticAdvertisementManager() {}

    public static synchronized StatisticAdvertisementManager getInstance() {
        if (instance == null) {
            instance = new StatisticAdvertisementManager();
        }
        return instance;
    }

    public List<Advertisement> getActiveVideo(){
        return  storage.list().stream().filter(v -> v.getHits()>0).collect(Collectors.toList());
    }

    public List<Advertisement> getNoActiveVideo(){
        return  storage.list().stream().filter(v -> v.getHits()<=0).collect(Collectors.toList());
    }


}
