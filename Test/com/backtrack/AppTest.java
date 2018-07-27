package com.backtrack;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AppTest {

//TODO Add a test for bad order in action buttons, also for time edge cases (noon and midnight)

    @Test
    public void LocalTimeTest(){
        assertEquals(LocalTime.of(9,30), LocalTime.parse("09:30"));
        }


}
