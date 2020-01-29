package com.javarush.task.task14.task1408;

import java.util.Formatter;

public class RussianHen extends Hen {

    private String country = Country.RUSSIA;

    @Override
    public int getCountOfEggsPerMonth() {
        return 100;
    }

    @Override
    public String getDescription() {
        return super.getDescription()+ new Formatter().format(" Моя страна - %s. Я несу %d яиц в месяц.", country, getCountOfEggsPerMonth());
    }
}

