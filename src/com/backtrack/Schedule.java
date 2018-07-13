package com.backtrack;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Schedule {

    // This class should provide an array list of items of names and times that should be printed out as a schedule
    // An instance of this class should be returned by scheduleMaker.generateSchedule
    // All user input should be put into ScheduleMaker
    // Schedule should just know about: Wake up time, all activites and build a string out of them, and ETA

    private HashMap<String, LocalTime> items;
    private LinkedList<Item> itemOrder;
    private LocalTime ETA;

    public Schedule() {
        this.items = new HashMap<>();
    }

    public HashMap<String, LocalTime> getItems() {
        return items;
    }

    public String listItems() {
        StringBuilder itemList = new StringBuilder();
        for (String item : items.keySet()) {
            itemList.append(item+" - "+ items.get(item)+'\n');
        }
        return itemList.toString();
    }

    public void setSchedule(HashMap<String,LocalTime> itemTimes) {
        this.items = itemTimes;
    }
}
