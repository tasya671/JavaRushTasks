package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class StatisticManager {

    public static StatisticManager instance;
    private StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticManager() {
    }

    public static synchronized StatisticManager getInstance() {
        if (instance == null) {
            instance = new StatisticManager();
        }
        return instance;
    }

    public void register(EventDataRow data){
        statisticStorage.put(data);
    }

    public Map<Date, Double> getAllVideoEventDataRow(){
        List<EventDataRow> videosEvent = statisticStorage.getStorage().get(EventType.SELECTED_VIDEOS);
        Map<Date, Double> data = new TreeMap<>(Collections.<Date>reverseOrder());
        for (int i = 0; i <videosEvent.size() ; i++) {
            Date current = getDateWithHours(videosEvent.get(i).getDate());
            VideoSelectedEventDataRow selectedEventDataRow = (VideoSelectedEventDataRow) videosEvent.get(i);
            if(data.containsKey(current)){
                data.put(current, data.get(current)+ 0.01d*selectedEventDataRow.getAmount());
            }
            else
                data.put(current, 0.01d*selectedEventDataRow.getAmount());
        }
        return data;
    }


    public Map<Date, Map<String, Integer>> getCookInfo(){
        List<EventDataRow> cookedOrder = statisticStorage.getStorage().get(EventType.COOKED_ORDER);
        Map<Date, Map<String, Integer>> cookInfo = new TreeMap<>(Collections.<Date>reverseOrder());
        Map<String, Integer> currentOrderInfo;
        for (int i = 0; i <cookedOrder.size() ; i++) {
            CookedOrderEventDataRow cookedOrderEventDataRow = (CookedOrderEventDataRow) cookedOrder.get(i);
            Date current = getDateWithHours(cookedOrder.get(i).getDate());
            String cookName = cookedOrderEventDataRow.getCookName();
            if (cookInfo.containsKey(current)){
                  currentOrderInfo = cookInfo.get(current);
                if(currentOrderInfo.containsKey(cookName)){
                    currentOrderInfo.put(cookName, currentOrderInfo.get(cookName)+ Math.round(cookedOrder.get(i).getTime()/60));
                } else
                    currentOrderInfo.put(cookName, Math.round(cookedOrder.get(i).getTime()/60));
            } else {
                currentOrderInfo = new TreeMap<>();
                currentOrderInfo.put(cookName, Math.round(cookedOrder.get(i).getTime()/60));
            }
            cookInfo.put(current, currentOrderInfo);
        }
        return cookInfo;
    }

    private Date getDateWithHours(Date date){
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setGregorianChange(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    public StatisticStorage getStatisticStorage() {
        return statisticStorage;
    }

    private static class StatisticStorage {

        private Map<EventType, List<EventDataRow>> storage;

        public StatisticStorage() {
            storage = new HashMap<>();
            EventType [] eventType = EventType.values();
            for (int i = 0; i <eventType.length ; i++) {
                storage.put(eventType[i], new ArrayList<>());
            }
        }

        private void put(EventDataRow data){
            storage.get(data.getType()).add(data);
        }

        public Map<EventType, List<EventDataRow>> getStorage() {
            return storage;
        }
    }
}

