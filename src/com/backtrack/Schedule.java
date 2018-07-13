package com.backtrack;

import java.time.LocalTime;
import java.util.ArrayList;

public class Schedule {

    // This class should provide an array list of items of names and times that should be printed out as a schedule
    // An instance of this class should be returned by scheduleMaker.generateSchedule
    // All user input should be put into ScheduleMaker
    // Schedule should just know about: Wake up time, all activites and build a string out of them, and ETA

    private ArrayList<Item> items;
    private LocalTime ETA;

    public Schedule() {
        items = new ArrayList<>();
        ETA = LocalTime.now();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public String listItems() {
        StringBuilder itemList = new StringBuilder();
        for (Item item : items) {
            itemList.append(item.getItemName()+'\n');
        }
        return itemList.toString();
    }
}
