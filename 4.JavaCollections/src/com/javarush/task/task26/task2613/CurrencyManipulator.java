package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.*;
import java.util.stream.Collectors;

public class CurrencyManipulator {

    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        if (denominations.containsKey(denomination)) {
            denominations.put(denomination, (denominations.get(denomination) + count));
        } else
            denominations.put(denomination, count);
    }

    public int getTotalAmount() {
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {
            sum += entry.getKey() * entry.getValue();
        }
        return sum;
    }

    public boolean hasMoney() {
        return getTotalAmount() == 0 ? false : true;
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return getTotalAmount() >= expectedAmount ? true : false;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        Map<Integer, Integer> result = new TreeMap<>((e1, e2) -> e2.compareTo(e1));
        if (denominations.containsKey(expectedAmount) &&
                denominations.get(expectedAmount) > 0) {
            denominations.put(expectedAmount, denominations.get(expectedAmount) - 1);
            denominations.keySet().removeIf(e -> denominations.get(e) == 0);
            result.put(expectedAmount, 1);
            return result;
        }
        int amount = expectedAmount;
        Map<Integer, Integer> current = new TreeMap<>(denominations);
        List<Integer> keys = current.keySet().stream().filter(e -> denominations.get(e) > 0).sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        int begin = 0;
        while (begin != keys.size()) {
            for (int i = begin; i < keys.size(); i++) {
                int demonination = keys.get(i);
                while (amount >= demonination && current.get(demonination) > 0) {
                    amount -= demonination;
                    current.put(demonination, current.get(demonination) - 1);
                    if (result.containsKey(demonination))
                        result.put(demonination, result.get(demonination) + 1);
                    else
                        result.put(demonination, 1);
                }
                if (amount == 0)
                    break;
            }
            if(amount == 0){
                break;
            } else {
                begin++;
                current =  new HashMap<>(denominations);
                result.clear();
                amount = expectedAmount;
            }
        }
       if(amount == 0) {
           this.denominations = current;
           denominations.keySet().removeIf(e -> denominations.get(e) == 0);
           return result;
       } else
           throw new NotEnoughMoneyException();
    }

}


