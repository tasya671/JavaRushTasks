package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;
import java.util.stream.Collectors;

public class AdvertisementManager {

    private final AdvertisementStorage  storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos(){
        List<Advertisement> list = storage.list().stream().filter(v -> v.getHits() > 0).collect(Collectors.toList());
        list.sort(new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o2.getDuration()-o1.getDuration();
            }
        });

        if(list.size()==0)
            throw new NoVideoAvailableException();

        int line = list.size();
        int column = timeSeconds;
        long [][] matrix = new long[line+1][column+1];

        for (int i = 0; i <=line; i++) {
            for (int j = 0; j <=column; j++) {
                if(i==0 || j==0)
                    matrix[i][j] =0;
                else if (list.get(i-1).getDuration()<= j){
                    Advertisement current = list.get(i-1);
                    matrix[i][j]= Math.max(matrix[i-1][j], matrix[i-1][j-current.getDuration()]+current.getAmountPerOneDisplaying());
                } else
                    matrix[i][j]= matrix[i-1][j];
            }
        }

        List<Advertisement> result = findOptimal(list, matrix, line, column);
        Collections.sort(result, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                int comp = Long.compare(o2.getAmountPerOneDisplaying(), o1.getAmountPerOneDisplaying());
                    if (comp == 0){
                        comp = Float.compare((o1.getAmountPerOneDisplaying()*1f/o1.getDuration()),
                                (o2.getAmountPerOneDisplaying()* 1f/o2.getDuration()));
                    }
                return comp;
            }
        });
        result.stream().forEach(advertisement -> {
            ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %3d",
                            advertisement.getName(), advertisement.getAmountPerOneDisplaying(), advertisement.getAmountPerOneDisplaying()*1000/advertisement.getDuration()));
                            advertisement.revalidate();
        });
        StatisticManager.getInstance().register(new VideoSelectedEventDataRow(result, totalAmount(result), totalDuration(result)));

    }


    private List<Advertisement> findOptimal(List<Advertisement> plain, long[][] matrix, int k, int s){
        List<Advertisement> result = new ArrayList<>();
        List<Advertisement> current;
        if(matrix[k][s]==0 || k<=0 || s<=0)
                return result;
        if(matrix[k-1][s]==matrix[k][s]){
           current = findOptimal(plain, matrix, k-1, s);}
        else {
            current = findOptimal(plain, matrix, k-1, (int) ((long) s-plain.get(k-1).getDuration()));
            result.add(plain.get(k-1));
        }
        if (!current.isEmpty())
            result.addAll(current);
        return result;
    }

    private int totalDuration(List<Advertisement> advertisementList){
        int duration = 0;
        for (int i = 0; i < advertisementList.size(); i++) {
            duration+=advertisementList.get(i).getDuration();
        }
        return duration;
    }

    private long totalAmount(List<Advertisement> advertisementList){
        long amount = 0;
        for (int i = 0; i < advertisementList.size(); i++) {
            amount+=advertisementList.get(i).getAmountPerOneDisplaying();
        }
        return amount;
    }

}
