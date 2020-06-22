package com.javarush.task.task39.task3913;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Solution {
    public static void main(String[] args) {
        Path pathDir = Paths.get((com.javarush.task.task39.task3913.Solution.class.getProtectionDomain().
                getCodeSource().getLocation().getPath() + "com/javarush/task/task39/task3913/logs").substring(1));
        LogParser log = new LogParser(pathDir);
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        try {
            Date date1 = format.parse("30.08.2012 16:08:13");
            Date date2 = format.parse("14.11.2015 16:08:13");
            System.out.println("Get number of unique IPs:");
            System.out.println(log.getNumberOfUniqueIPs(null, null));
            System.out.println("Get unique IPs:");
            log.getUniqueIPs(date1, date2).stream().forEach(e -> System.out.println(e));
            System.out.println("Get IPs for user:");
            log.getIPsForUser("Vasya Pupkin", null, null).stream().forEach(e -> System.out.println(e));
            System.out.println("Get IPs for event:");
            log.getIPsForEvent(Event.LOGIN, null, null).stream().forEach(e -> System.out.println(e));
            System.out.println("Get IPs for status:");
            log.getIPsForStatus(Status.ERROR, null, null).stream().forEach(e -> System.out.println(e));
            System.out.println("Get all users:");
            log.getAllUsers().stream().forEach(e -> System.out.println(e));
            System.out.println("Get number of users");
            System.out.println(log.getNumberOfUsers(null, null));
            System.out.println("Get number of user events");
            System.out.println(log.getNumberOfUserEvents("Eduard Petrovich Morozko",null, null));
            System.out.println("Get date when user done task");
            System.out.println(log.getDateWhenUserDoneTask("Vasya Pupkin", 15, null, null));
            System.out.println(log.execute("get event for date = \"30.01.2014 12:56:22\""));
            System.out.println(log.execute("get ip for status = \"[any_status]\""));
            System.out.println(log.execute("get user"));
            System.out.println(log.execute("get user for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\""));
            System.out.println(log.execute("get ip for event = \"WRITE_MESSAGE\" and date between \"11.12.2013 10:11:12\" and \"21.10.2030 00:00:00\""));
            System.out.println(log.execute("get status for event = \"DONE_TASK\" and date between \"30.08.2012 16:08:40\" and \"01.01.2025 00:00:00\""));
            System.out.println(log.execute("get status for user = \"Eduard Petrovich Morozkov aaaaaaaaaaaa aaaaaa bbbbbbbbb\" and date between \"13.09.2013 5:04:50\" and \"12.12.2013 21:56:30\""));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}