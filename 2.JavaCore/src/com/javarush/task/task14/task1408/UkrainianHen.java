package com.javarush.task.task14.task1408;

import java.util.Formatter;

public class UkrainianHen extends Hen {

    private String country = Country.UKRAINE;

    @Override
    public int getCountOfEggsPerMonth() {
        return 70;
    }

    @Override
    public String getDescription() {
        return super.getDescription()+ new Formatter().format(" Моя страна - %s. Я несу %d яиц в месяц.", country, getCountOfEggsPerMonth());
    }
}
