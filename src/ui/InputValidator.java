package ui;

import javax.swing.*;
import java.time.LocalTime;

public class InputValidator {

    //Validates for each input that the button has taken the correct form of text input

    //On click of a button, this class should be called on a specific input text area

    //Text areas:

    //    public static JTextArea activityName = new JTextArea("Activity");

    //TODO throw exception if LocalTime can't parse something
//
//    public static JTextArea destination = new JTextArea("Your ultimate destination (Ex. Work)");
//
//    public static JTextArea activityDuration = new JTextArea("Duration (in minutes)");
//
//    public static JTextArea ETAInput = new JTextArea("Enter your ETA");

    public static boolean ETAIsValid(String etaInput) throws java.time.format.DateTimeParseException{

        try {
            LocalTime.parse(etaInput);
            return true;
        }

        catch (java.time.format.DateTimeParseException e) {
            return false;
        } //TODO If etavalid is false, then you can set the button text

    }

    public static boolean DurationIsValid(String duration) throws java.lang.NumberFormatException {

        try {
            Integer.parseInt(duration);
            return true;
        }

        catch (java.lang.NumberFormatException e) {
            return false;
        }
    }
}
