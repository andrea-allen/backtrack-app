package com.backtrack;

import java.time.LocalTime;
import java.util.ArrayList;

public class Schedule {

    private ArrayList<Item> items;
    private LocalTime ETA;

    public Schedule() {
        items = new ArrayList<>();
        ETA = LocalTime.now();
    }

    //ETA should maybe first belong to scheduleMaker?
    public void setETA(LocalTime ETA) {
        this.ETA = ETA;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public LocalTime getETA() {
        return ETA;
    }

    public String listItems() {
        StringBuilder itemList = new StringBuilder();
        for (Item item : items) {
            itemList.append(item.getItemName()+'\n');
        }
        return itemList.toString();
    }
}
