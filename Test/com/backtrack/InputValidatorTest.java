package com.backtrack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.InputValidator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputValidatorTest {

    //Text areas:
//    public static JTextArea ETAInput = new JTextArea("Enter your ETA");
//
//    public static JTextArea activityDuration = new JTextArea("Duration (in minutes)");
//
//    public static JTextArea destination = new JTextArea("Your ultimate destination (Ex. Work)");
//
//    public static JTextArea activityName = new JTextArea("Activity");

    private InputValidator inputValidator;

    @BeforeEach
    public void SetUp() {
        inputValidator = new InputValidator();
    }

    @Test
    public void validateGoodETA(){
        String ETAInput = "12:00";
        assertTrue(inputValidator.ETAIsValid(ETAInput));
    }


    @Test
    public void validateBadETA() {
        String ETAInput = "9";
        assertFalse(inputValidator.ETAIsValid(ETAInput));
    }

    @Test
    public void validateGoodDuration() {
        String duration = "foo";
        assertFalse(inputValidator.DurationIsValid(duration));
    }



}
