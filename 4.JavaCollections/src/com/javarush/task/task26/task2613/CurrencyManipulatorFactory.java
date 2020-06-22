package com.javarush.task.task26.task2613;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulatorFactory {

    private static Map<String, CurrencyManipulator> map = new HashMap<>();

    private CurrencyManipulatorFactory() { }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode){
        if(currencyCode == null || currencyCode.equals("")) return null;
        for (Map.Entry<String, CurrencyManipulator> entry: map.entrySet()) {
            if(entry.getKey().equalsIgnoreCase(currencyCode))
                return entry.getValue();
        }
        CurrencyManipulator manipulator = new CurrencyManipulator(currencyCode);
        map.put(currencyCode, manipulator);
        return manipulator;
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){
        return map.values();
    }
}



