package com.javarush.task.task14.task1408;

import java.util.Formatter;

public class BelarusianHen extends Hen {

    private String country = Country.BELARUS;

    @Override
    public int getCountOfEggsPerMonth() {
        return 97;
    }

    @Override
    public String getDescription() {
        return super.getDescription()+ new Formatter().format(" Моя страна - %s. Я несу %d яиц в месяц.", country, getCountOfEggsPerMonth());
    }
}
