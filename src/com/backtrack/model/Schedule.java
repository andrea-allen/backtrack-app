package com.backtrack.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Schedule {

    // This class should provide an array list of items of names and times that should be printed out as a schedule
    // An instance of this class should be returned by scheduleMaker.generateSchedule
    // All user input should be put into ScheduleMaker
    // Schedule should just know about: Wake up time, all activites and build a string out of them, and ETA

    private HashMap<String, LocalTime> items;
    private ArrayList<Item> scheduleOrder;
    private LocalTime ETA;

    public Schedule() {
        this.items = new HashMap<>();
        this.scheduleOrder = new ArrayList<>();
    }

    public String listItems() {
        StringBuilder itemList = new StringBuilder();
        for (Item item : scheduleOrder) {
            String itemName = item.getItemName();
            itemList.insert(0, itemName + " - " + items.get(itemName)+'\n');
        }
        return itemList.toString();
    }

    public void setSchedule(HashMap<String,LocalTime> itemTimes, ArrayList<Item> scheduleOrder) {
        this.items = itemTimes;
        this.scheduleOrder = scheduleOrder;
    }

}
