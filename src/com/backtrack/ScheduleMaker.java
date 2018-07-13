package com.backtrack;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class ScheduleMaker {

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

    public ScheduleMaker() {
        itemTime = new HashMap<>();
        itemOrder = new LinkedList<>(); //Should start out backwards, after users put in their items in chronlogical order
        schedule = new Schedule();
    }

    public ScheduleMaker(Schedule schedule) {
        this();
        this.schedule = schedule;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setETA(LocalTime ETA) {
        this.ETA = ETA;
    }

    public LocalTime getETA() {
        return this.ETA;
    }

    public void add(Item item) {
        itemOrder.add(item);
    }

    public void updateItemTimes(){
        LocalTime endTime = this.ETA;
        while (!itemOrder.isEmpty()) {
            Item item = itemOrder.pop();
            item.setStartTime(endTime);
            itemTime.put(item.getItemName(), item.getStartTime());
            endTime = item.getStartTime();

        }
    }

    public HashMap<String, LocalTime> getItemTime() {
        return itemTime;
    }
}
