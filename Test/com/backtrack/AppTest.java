package com.backtrack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AppTest {

    @Test
    public void shouldAddItem() {
        //SETUP
        Schedule testSchedule = new Schedule();

        //ACT
        testSchedule.addItem(new Item("Get to Work",45));

        //ASSERT
        assertEquals("Get to Work", testSchedule.getItems().get(0).getItemName());
    }

    @Test
    public void shouldListItems() {
        //SETUP
        Schedule testSchedule = new Schedule();

        //ACT
        testSchedule.addItem(new Item("Get to Work", 45));

        //ASSERT
        assertEquals("Get to Work"+'\n', testSchedule.listItems());
    }

}
