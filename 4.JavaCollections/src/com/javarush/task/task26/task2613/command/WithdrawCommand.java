package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

class WithdrawCommand implements Command{

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH +"withdraw", Locale.ENGLISH);

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currency = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currency);
        ConsoleHelper.writeMessage(res.getString("specify.amount"));
        while (true){
            String sum = ConsoleHelper.readString();
            if (sum.matches("(\\+)?\\d+")){
                int count = Integer.parseInt(sum);
                if(count> 0 & manipulator.isAmountAvailable(count)){
                    try {
                        Map<Integer, Integer> map = manipulator.withdrawAmount(count);
                        map.keySet().stream().forEach(e -> System.out.println("\t"+ e +" - " + map.get(e)));
                        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), count, currency));
                        break;
                    } catch (NotEnoughMoneyException e) {
                        ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                        ConsoleHelper.writeMessage(res.getString("specify.amount"));
                    }
                } else {
                    ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                    ConsoleHelper.writeMessage(res.getString("specify.amount"));
                }
            } else {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
            }
        }
    }
}
