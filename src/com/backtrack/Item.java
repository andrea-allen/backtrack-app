package com.backtrack;

import java.time.LocalTime;

public class Item {

    //Item should know its own start time
    //Item should compute its own start time based on a given time

    private String item;
    private Integer minutes;
    private LocalTime startTime;

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

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime endTime) {
        this.startTime = endTime.minusMinutes(this.minutes);
    }
}
