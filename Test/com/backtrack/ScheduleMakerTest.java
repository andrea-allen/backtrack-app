package com.backtrack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScheduleMakerTest {

    Schedule schedule;
    Item get_to_work;
    Item eat_breakfast;
    ScheduleMaker scheduleMaker;

    @BeforeEach
    public void setUp() {
        schedule = new Schedule();
        get_to_work = new Item("Get to work", 45);
        eat_breakfast = new Item("Eat Breakfast", 15);
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
        scheduleMaker.setETA(LocalTime.of(9,30));
        assertEquals(LocalTime.of(9,30), scheduleMaker.getETA());
        scheduleMaker.add(get_to_work);
        scheduleMaker.updateItemTimes();
        assertEquals(scheduleMaker.getETA().minusMinutes(get_to_work.getMinutes()), scheduleMaker.getItemTime().get(get_to_work.getItemName()));
    }

    @Test
    public void shouldProvideCorrectStartTimeWhenThereAreTwoItems() {
        scheduleMaker.setETA(LocalTime.of(9,30));
        scheduleMaker.add(get_to_work);
        scheduleMaker.add(eat_breakfast);
        scheduleMaker.updateItemTimes();
        assertEquals(scheduleMaker.getETA().minusMinutes(get_to_work.getMinutes()).minusMinutes(eat_breakfast.getMinutes()), scheduleMaker.getItemTime().get(eat_breakfast.getItemName()));
    }

    @Test
    public void shouldUpdateItemTimes() {
        scheduleMaker.setETA(LocalTime.of(9,30));
        scheduleMaker.add(get_to_work);
        scheduleMaker.add(eat_breakfast);
        HashMap<String, LocalTime> itemTimes = scheduleMaker.getItemTime();
        scheduleMaker.updateItemTimes();
        assertEquals(LocalTime.of(8,45), itemTimes.get(get_to_work.getItemName()));
        assertEquals(LocalTime.of(8,30), itemTimes.get(eat_breakfast.getItemName()));
    }

    @Test
    public void shouldYieldCorrectWakeUpTime() {
        scheduleMaker.setETA(LocalTime.of(9,30));
        scheduleMaker.add(get_to_work);
        scheduleMaker.add(eat_breakfast);
        scheduleMaker.updateItemTimes();
        scheduleMaker.setWake_up_time();
        assertEquals(LocalTime.of(8,20), scheduleMaker.getWakeUpTime());
    }




}
