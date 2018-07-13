package com.backtrack;

import java.time.LocalTime;
import java.util.*;

public class ScheduleMaker {
    private static final long SNOOZE_TIME = 10;

    // ScheduleMaker should get input from JS fields from the user (see TWU project) through a controller of some kind maybe
    // ScheduleMaker should know about the ETA
    // Should just have methods to add items to its tables and then generate a schedule from it
    // Should own a schedule object that it can edit and create
    // Should be responsible for ETA and Wake up time

    private HashMap<String, LocalTime> itemTime;
    private LinkedList<Item> itemOrder;
    private Schedule schedule;
    private LocalTime ETA;
    private LocalTime wake_up_time;
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

    public void setETA(LocalTime ETA) {
        this.ETA = ETA;
        itemTime.put("Get there", this.ETA);
    }

    public LocalTime getETA() {
        return this.ETA;
    }

    public void add(Item item) {
        itemOrder.add(item);
    }

    public void updateItemTimes(){
        LocalTime endTime = this.ETA;

        scheduleOrder.add(new Item("Get there", 0));

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
}
