package com.backtrack;

public class Item {

    private String item;
    private Integer minutes;

    public Item(String item, Integer minutes) {
        this.item = item;
        this.minutes = minutes;
    }

    public String getItemName() {
        return item;
    }

    public Integer getMinutes() {
        return minutes;
    }
}
