package com.backtrack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScheduleTest {

    Schedule schedule;
    Item get_to_work;
    Item eat_breakfast;
    ScheduleMaker scheduleMaker;
    private Item shower;

    @BeforeEach
    public void setUp() {
        schedule = new Schedule();
        get_to_work = new Item("Go to work", 45);
        eat_breakfast = new Item("Eat Breakfast", 15);
        shower = new Item("Shower", 25);
        scheduleMaker = new ScheduleMaker();
    }

    @Test
    public void shouldPrintScheduleWhenThereIsOneItem() {
        scheduleMaker.setETA(LocalTime.of(9,30));
        scheduleMaker.add(get_to_work);
        scheduleMaker.add(eat_breakfast);
        scheduleMaker.add(shower);
        scheduleMaker.updateItemTimes();
        scheduleMaker.setWake_up_time();
        scheduleMaker.generateSchedule();
        schedule = scheduleMaker.getSchedule();
        System.out.println(schedule.listItems());
        assertTrue(schedule.listItems().contains("Go to work"));
        assertTrue(schedule.listItems().contains("Eat Breakfast"));
        assertTrue(schedule.listItems().contains("Wake Up"));

    }
}
