package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public void printAdvertisementProfit() {
        ConsoleHelper.writeMessage("Advertisement Profit:");
        double total = 0;
        for (Map.Entry<Date, Double> entry : StatisticManager.getInstance().getAllVideoEventDataRow().entrySet()) {

            double e = entry.getValue();
            ConsoleHelper.writeMessage(String.format("%s - %.2f", simpleDateFormat.format(entry.getKey()), e));
            total += e;
        }
        if (total > 0) ConsoleHelper.writeMessage(String.format("Total - %.2f",total));
    }
    public void printCookWorkloading() {
        ConsoleHelper.writeMessage("Cook work loading:");
        for (Map.Entry<Date, Map<String, Integer>> pair : StatisticManager.getInstance().getCookInfo().entrySet()) {
            ConsoleHelper.writeMessage(simpleDateFormat.format(pair.getKey()));
            for (Map.Entry<String, Integer> pair2 : pair.getValue().entrySet()) {
                if (pair2.getValue() > 0) {
                    ConsoleHelper.writeMessage(String.format("%s - %d min", pair2.getKey(), pair2.getValue()));
                }
            }
        }
    }
    public void printActiveVideoSet(){
        ConsoleHelper.writeMessage("Active video set:");
        List <Advertisement> active = StatisticAdvertisementManager.getInstance().getActiveVideo();
        active.stream().sorted(new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        }).forEach(v ->{ ConsoleHelper.writeMessage(v.getName()+" - "+v.getHits()); });
    }

    public void printArchivedVideoSet() {
        ConsoleHelper.writeMessage("Archived video set:");
        List<Advertisement> archived = StatisticAdvertisementManager.getInstance().getNoActiveVideo();
        archived.stream().sorted(new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        }).forEach(v -> {ConsoleHelper.writeMessage(v.getName()); });
    }

}
