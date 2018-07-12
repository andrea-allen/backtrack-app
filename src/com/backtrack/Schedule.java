package com.backtrack;

import java.util.ArrayList;

public class Schedule {

    private ArrayList<String> items;

    public Schedule() {
        items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public String listItems() {
        return items.toString();
    }
}
