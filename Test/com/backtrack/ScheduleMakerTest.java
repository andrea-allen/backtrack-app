package com.backtrack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScheduleMakerTest {

    Schedule schedule;
    Item get_to_work;
    ScheduleMaker scheduleMaker;

    @BeforeEach
    public void setUp() {
        schedule = new Schedule();
        get_to_work = new Item("Get to work", 45);
        schedule.addItem(get_to_work);
        scheduleMaker = new ScheduleMaker();
    }

    @Test
    public void shouldProvideCorrectLeaveTime() {
        LocalTime ETA = LocalTime.of(9,30);
        int travelTime = 48;
        assertEquals("08:42",ETA.minusMinutes(travelTime).toString());
    }

    @Test
    public void shouldComputeStartTimeWhenETAIsSet(){
        schedule.setETA(LocalTime.of(9,30));
        assertEquals(LocalTime.of(9,30), schedule.getETA());
        scheduleMaker = new ScheduleMaker(schedule);
        scheduleMaker.addAll(get_to_work.getItemName(), get_to_work.getMinutes());
        assertEquals(schedule.getETA().minusMinutes(get_to_work.getMinutes()), scheduleMaker.getItemTime().get(get_to_work.getItemName()));
    }




}
