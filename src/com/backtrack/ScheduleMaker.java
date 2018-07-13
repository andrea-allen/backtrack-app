package com.backtrack;

import java.time.LocalTime;
import java.util.HashMap;

public class ScheduleMaker {

    private HashMap<String, Integer> itemMinutes;
    private HashMap<String, LocalTime> itemTime;
    private Schedule schedule;

    public ScheduleMaker() {
        itemMinutes = new HashMap<>();
        itemTime = new HashMap<>();
        schedule = new Schedule();
    }

    public ScheduleMaker(Schedule schedule) {
        this();
        this.schedule = schedule;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void addItemMinutes(String item, Integer minutes) {
        itemMinutes.put(item, minutes);
    }

    public void addItemTime(String item, LocalTime time) {
        itemTime.put(item, time);
    }

    public void addAll(String item, Integer minutes) {
        addItemMinutes(item, minutes);
        LocalTime startTime = computeStartTime(itemMinutes.get(item));
        System.out.println("Computed Start Time");
        System.out.println(startTime.toString());
        addItemTime(item, startTime);
    }

    private LocalTime computeStartTime(Integer minutes) {
        System.out.println(schedule.getETA());
        return schedule.getETA().minusMinutes(minutes);
    }

    public HashMap<String, Integer> getItemMinutes() {
        return itemMinutes;
    }

    public HashMap<String, LocalTime> getItemTime() {
        return itemTime;
    }
}
