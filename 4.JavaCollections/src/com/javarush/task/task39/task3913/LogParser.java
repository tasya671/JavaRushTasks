package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {

    private Path logDir;
    private SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public LogParser(Path logDir) {
        this.logDir = logDir;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        List<LogEntry> data = getDataForDates(after, before);
        return data.stream().map(e -> e.ip).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        List<LogEntry> data = getDataForDates(after, before);
        return  data.stream().filter(e-> (e.userName.equals(user))).map(e -> e.ip).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        List<LogEntry> data = getDataForDates(after, before);
        return data.stream().filter(e-> (e.event.equals(event))).map(e -> e.ip).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        List<LogEntry> data = getDataForDates(after, before);
        return  data.stream().filter(e-> (e.status.equals(status))).map(e -> e.ip).collect(Collectors.toSet());
    }

     private List<LogEntry> getAllData() {
        List<String> data = new ArrayList<>();
        File[] files = logDir.toFile().listFiles();
        for (File file : files) {
            if(file.getName().endsWith(".log")){
                List<String> contents = null;
                try {
                    contents = Arrays.asList((new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8)).split("\\r?\\n"));
                } catch (IOException e) {}
                data.addAll(contents);
            }
        }
        List<LogEntry> entries = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+");
         for (String entry : data) {
             String[] elements = entry.split("\\t");
             String ip = elements[0].trim();
             String name = elements[1].trim();
             Date date = getDate(entry);
             Event event;
             int numberTask;
             Matcher matcher = pattern.matcher(elements[3]);
             if(matcher.find()){
                 String[] tasks = elements[3].split(" ");
                 event = Event.valueOf(tasks[0].trim());
                 numberTask = Integer.parseInt(tasks[1].trim());
             } else {
                 event = Event.valueOf(elements[3].trim());
                 numberTask =0;
             }
             Status status = Status.valueOf(elements[4].trim());
             LogEntry logEntry = new LogEntry(ip, name, date, event, numberTask, status);
             entries.add(logEntry);
         }
        return entries;
    }

    private Date getDate(String str){
        if(str == null)
            return null;
        Pattern pattern = Pattern.compile("\\d{1,2}\\.\\d{1,2}\\.\\d{4,}\\s\\d{1,2}\\:\\d{1,2}\\:\\d{1,2}");
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()){
            String templateDate = str.substring(matcher.start(), matcher.end());
            Date date = null;
            try {
                date = format.parse(templateDate);
            } catch (ParseException e) {    }
            return date;
        }
        return null;
    }

    private List<LogEntry> getDataForDates(Date after, Date before){
        List<LogEntry> data = getAllData();
        List<LogEntry> contentOnDate = new ArrayList<>();
            if(after!= null && before != null){
                contentOnDate = data.stream().filter(e -> ((e.date.before(before) && e.date.after(after) ||
                        (e.date.equals(before) || e.date.equals(after))))).collect(Collectors.toList());
            } else if(after == null && before!=null){
                contentOnDate = data.stream().filter(e -> (e.date.before(before) || e.date.equals(before))).
                        collect(Collectors.toList());
            } else if (after!= null && before==null){
                contentOnDate = data.stream().filter(e -> (e.date.after(after) || e.date.equals(after))).
                        collect(Collectors.toList());
            } else if (after == null && before == null){
                contentOnDate.addAll(data);
            }
        return contentOnDate;
    }

    private List<LogEntry> getDataForDatesWithoutMatch(Date after, Date before){
        List<LogEntry> data = getAllData();
        List<LogEntry> contentOnDate = new ArrayList<>();
        if(after!= null && before != null){
            contentOnDate = data.stream().filter(e -> ((e.date.before(before) && e.date.after(after)))).collect(Collectors.toList());
        } else if(after == null && before!=null){
            contentOnDate = data.stream().filter(e -> (e.date.before(before))).collect(Collectors.toList());
        } else if (after!= null && before==null){
            contentOnDate = data.stream().filter(e -> (e.date.after(after))).collect(Collectors.toList());
        } else if (after == null && before == null){
            contentOnDate.addAll(data);
        }
        return contentOnDate;
    }

    @Override
    public Set<String> getAllUsers() {
        return getAllData().stream().map(e -> e.userName).collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        return getDataForDates(after, before).stream().map(e -> e.userName).collect(Collectors.toSet()).size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {

       return getDataForDates(after, before).stream().filter(e -> e.userName.equals(user)).map(e -> e.event).collect(Collectors.toSet()).size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        return getDataForDates(after, before).stream().filter(e -> e.ip.equals(ip)).map(e -> e.userName).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        return getDataForDates(after, before).stream().filter(e -> e.event.equals(Event.LOGIN)).map(e -> e.userName).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        return getDataForDates(after, before).stream().filter(e -> e.event.equals(Event.DOWNLOAD_PLUGIN)).map(e -> e.userName).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        return getDataForDates(after, before).stream().filter(e -> e.event.equals(Event.WRITE_MESSAGE)).map(e -> e.userName).collect(Collectors.toSet());

    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        return getDataForDates(after, before).stream().filter(e -> e.event.equals(Event.SOLVE_TASK)).map(e -> e.userName).collect(Collectors.toSet());

    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        return getDataForDates(after, before).stream().filter(e -> (e.event.equals(Event.SOLVE_TASK) && e.numberTask==task)).map(e -> e.userName).collect(Collectors.toSet());

    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        return getDataForDates(after, before).stream().filter(e -> e.event.equals(Event.DONE_TASK)).map(e -> e.userName).collect(Collectors.toSet());

    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        return getDataForDates(after, before).stream().filter(e -> (e.event.equals(Event.DONE_TASK) && e.numberTask==task)).map(e -> e.userName).collect(Collectors.toSet());

    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        return getDataForDates(after, before).stream().filter(e ->(e.userName.equals(user) && e.event.equals(event))).
                map(e -> e.date).collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        return getDataForDates(after, before).stream().filter(e -> e.status.equals(Status.FAILED)).map(e -> e.date).collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        return getDataForDates(after, before).stream().filter(e -> e.status.equals(Status.ERROR)).map(e -> e.date).collect(Collectors.toSet());
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
       List<Date> dates = getDataForDates(after, before).stream().filter(e -> (e.userName.equals(user) && e.event.equals(Event.LOGIN))).
                sorted((e1, e2) -> e1.date.compareTo(e2.date)).map(e -> e.date).limit(1).collect(Collectors.toList());
       if (dates.size() == 0){
           return null;
       } else
           return dates.get(0);
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        List<Date> dates = getDataForDates(after, before).stream().filter(e -> (e.userName.equals(user) && e.event.equals(Event.SOLVE_TASK) && e.numberTask==task)).
                sorted((e1, e2) -> e1.date.compareTo(e2.date)).map(e -> e.date).limit(1).collect(Collectors.toList());
        if (dates.size() == 0){
            return null;
        } else
            return dates.get(0);
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        List<Date> dates = getDataForDates(after, before).stream().filter(e -> (e.userName.equals(user) && e.event.equals(Event.DONE_TASK) && e.numberTask==task)).
                sorted((e1, e2) -> e1.date.compareTo(e2.date)).map(e -> e.date).limit(1).collect(Collectors.toList());
        if (dates.size() == 0){
            return null;
        } else
            return dates.get(0);
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        return getDataForDates(after, before).stream().filter(e ->(e.userName.equals(user) && e.event.equals(Event.WRITE_MESSAGE))).
                map(e -> e.date).collect(Collectors.toSet());
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        return getDataForDates(after, before).stream().filter(e ->(e.userName.equals(user) && e.event.equals(Event.DOWNLOAD_PLUGIN))).
                map(e -> e.date).collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return getDataForDates(after, before).stream().map(e -> e.event).collect(Collectors.toSet()).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        return getDataForDates(after, before).stream().map(e -> e.event).collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        return getDataForDates(after, before).stream().filter(e -> e.ip.equals(ip)).map(e -> e.event).collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        return getDataForDates(after, before).stream().filter(e -> e.userName.equals(user)).map(e -> e.event).collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        return getDataForDates(after, before).stream().filter(e -> e.status.equals(Status.FAILED)).map(e -> e.event).collect(Collectors.toSet());
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        return getDataForDates(after, before).stream().filter(e -> e.status.equals(Status.ERROR)).map(e -> e.event).collect(Collectors.toSet());
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        return (int) getDataForDates(after, before).stream().filter(e -> (e.event.equals(Event.SOLVE_TASK) && e.numberTask==task && e.numberTask!=0)).
                count();
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        return (int) getDataForDates(after, before).stream().filter(e -> (e.event.equals(Event.DONE_TASK) && e.numberTask==task && e.numberTask!=0)).
                count();
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        return getDataForDates(after, before).stream().filter(e -> (e.numberTask!= 0 && e.event.equals(Event.SOLVE_TASK))).
                collect(Collectors.toMap(LogEntry::getNumberTask, e->1, Integer::sum));
    }


    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        return getDataForDates(after, before).stream().filter(e -> (e.numberTask!= 0 && e.event.equals(Event.DONE_TASK))).
                collect(Collectors.toMap(LogEntry::getNumberTask, e->1, Integer::sum));
    }

    @Override
    public Set<Object> execute(String query) {
        Set<Object> objects = new HashSet<>();
        Pattern pattern = Pattern.compile("get (?<field1>\\w+)(\\sfor\\s(?<field2>\\w+)\\s=\\s\"(?<value>.+?)\")?" +
                "(\\sand\\sdate\\sbetween\\s\"(?<after>.{1,40})\"\\sand\\s\"(?<before>.{1,40})\")?");
        Matcher matcher = pattern.matcher(query);
        String field1 = null;
        String field2 = null;
        String value = null;
        String after = null;
        String before = null;

        if (matcher.find()) {
            field1 = matcher.group("field1");
            field2 = matcher.group("field2");
            value = matcher.group("value");
            after = matcher.group("after");
            before = matcher.group("before");
        }
        try {
            Method get = LogEntry.class.getDeclaredMethod("get" + field1.substring(0, 1).toUpperCase() + field1.substring(1));
            get.setAccessible(true);
            Date dateAfter = getDate(after);
            Date dateBefore = getDate(before);
            if (field2 != null && value != null && !value.contains("any")) {
                Method fors = LogEntry.class.getDeclaredMethod(field2);
                fors.setAccessible(true);
                String param = value;
                if (!field2.equals("date")) {
                    objects.addAll(getDataForDatesWithoutMatch(dateAfter, dateBefore).stream().filter(log -> {
                        try {
                            return fors.invoke(log).equals(param);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                        return false;
                    }).
                            map(log -> {
                                try {
                                    return get.invoke(log);
                                } catch (IllegalAccessException | InvocationTargetException e) {
                                    e.printStackTrace();
                                }
                                return null;
                            }).collect(Collectors.toSet()));
                } else {
                    Date date = getDate(param);
                    objects.addAll(getDataForDatesWithoutMatch(dateAfter,dateBefore).stream().filter(log -> (log.date().equals(date)))
                            .map(log -> {
                                try {
                                    return get.invoke(log);
                                } catch (IllegalAccessException | InvocationTargetException e) {
                                    e.printStackTrace();
                                }
                                return null;
                            }).collect(Collectors.toSet()));
                }
            } else {
                objects.addAll(getDataForDatesWithoutMatch(dateAfter, dateBefore).stream().map(log -> {
                    try {
                        return get.invoke(log);
                    } catch (IllegalAccessException | InvocationTargetException e) { e.printStackTrace();}
                    return null;}).
                        collect(Collectors.toSet()));
            }
        } catch (NoSuchMethodException e) { }

        return  objects;
    }

    private class LogEntry {

        String ip;
        String userName;
        Date date;
        Event event;
        int numberTask;
        Status status;

        public LogEntry(String ip, String userName, Date date, Event event, int numberTask, Status status) {
            this.ip = ip;
            this.userName = userName;
            this.date = date;
            this.event = event;
            this.numberTask = numberTask;
            this.status = status;
        }

        public String ip() {
            return ip;
        }

        public String user() {
            return userName;
        }

        public String event() { return  event.name(); }

        public String status() { return  status.name(); }

        public Date date() { return  date; }

        public String getIp() {
            return ip;
        }

        public String getUser() {
            return userName;
        }

        public Date getDate() {
            return date;
        }

        public Event getEvent() {
            return event;
        }

        public int getNumberTask() {
            return numberTask;
        }

        public Status getStatus() {
            return status;
        }


        @Override
        public String toString() {
            return "LogEntry{" +
                    "ip='" + ip + '\'' +
                    ", userName='" + userName + '\'' +
                    ", date=" + date +
                    ", event=" + event +
                    ", numberTask='" + numberTask + '\'' +
                    ", status=" + status +
                    '}';
        }
    }
}