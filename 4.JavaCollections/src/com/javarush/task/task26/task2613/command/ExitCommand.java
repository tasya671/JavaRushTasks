package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

class ExitCommand implements Command {

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH +"exit", Locale.ENGLISH);

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));
        String str = ConsoleHelper.readString();
        if(str.equalsIgnoreCase("y"))
            ConsoleHelper.writeMessage(res.getString("thank.message"));
        else if (str.equalsIgnoreCase("n"))
            return;
    }
}
