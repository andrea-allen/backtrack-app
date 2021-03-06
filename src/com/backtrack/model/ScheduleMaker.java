package com.backtrack.model;

import java.time.LocalTime;
import java.util.*;

public class ScheduleMaker {
    private static final long SNOOZE_TIME = 10;

    private HashMap<String, LocalTime> itemTime;
    private LinkedList<Item> itemOrder;
    private Schedule schedule;
    private LocalTime ETA;
    private LocalTime wake_up_time;
    private String destination;
    private ArrayList<Item> scheduleOrder;

    public ScheduleMaker() {
        itemTime = new HashMap<>();
        itemOrder = new LinkedList<>(); //Should start out backwards, after users put in their items in chronlogical order
        scheduleOrder = new ArrayList<>();
        schedule = new Schedule();
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setETA(LocalTime ETA, String destination) {
        this.ETA = ETA;
        this.destination = destination;
        itemTime.put(destination, this.ETA);
    }

    public LocalTime getETA() {
        return this.ETA;
    }

    public void add(Item item) {
        itemOrder.add(item);
    }

    public void updateItemTimes(){
        LocalTime endTime = this.ETA;

        scheduleOrder.add(new Item(destination, 0));

        while (!itemOrder.isEmpty()) {
            Item item = itemOrder.pop();
            item.setStartTime(endTime);
            itemTime.put(item.getItemName(), item.getStartTime());
            endTime = item.getStartTime();
            scheduleOrder.add(item);
        }

        scheduleOrder.add(new Item("Wake Up", ((int) SNOOZE_TIME)));
    }

    public HashMap<String, LocalTime> getItemTime() {
        return itemTime;
    }

    public LocalTime getWakeUpTime() {
        return wake_up_time;
    }

    public void setWake_up_time() {
        wake_up_time = getEarliestTime().minusMinutes(SNOOZE_TIME);
        itemTime.put("Wake Up", wake_up_time);
    }

    public LocalTime getEarliestTime() {
        LocalTime minTime = this.ETA;
        for (LocalTime time : itemTime.values()) {
            if (time.isBefore(minTime)) {
                minTime = time;
            }
        }
        return minTime;
    }

    public void generateSchedule() {
        schedule.setSchedule(itemTime, scheduleOrder);
    }

    public void clear() {
        this.itemTime.clear();
        this.itemOrder.clear();
        this.scheduleOrder.clear();
        this.schedule.clear();
    }
}
