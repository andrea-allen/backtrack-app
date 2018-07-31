package ui;

import com.backtrack.model.Item;
import com.backtrack.model.Schedule;
import com.backtrack.model.ScheduleMaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

public class BackTrackRunner extends JPanel {

    public static final int BOX_WIDTH = 1200;
    public static final int BOX_HEIGHT = 400;
    private Font inputTextFont = new Font("Helvetica Neue", Font.ITALIC, 16);
    private Font buttonFont = new Font("Helvetica Neue", Font.BOLD, 16);


    public static JButton addActivity = new JButton("Add to your schedule");

    public static JButton addETA = new JButton("Set ETA");

    public static JButton clickToFinish = new JButton("Finished? \n Generate your schedule");

    public static JButton startOver = new JButton("Start over");

    public static JTextArea ETAInput = new JTextArea("Enter your ETA");

    public static JTextArea activityDuration = new JTextArea("Duration (in minutes)");

    public static JTextArea destination = new JTextArea("Your ultimate destination (Ex. Work)");

    public static JTextArea activityName = new JTextArea("Type an activity");

    public static JTextArea displaySchedule = new JTextArea();

    public static JTextArea Instructions = new JTextArea("Enter your activities in backwards order, starting with leaving for your destination and the time that will take.");

    public static JTextArea MiniSchedule = new JTextArea("Mini Schedule");

    private static ScheduleMaker scheduleMaker;
    private Schedule schedule;
    private InputValidator inputValidator;

    //TODO: Get the text input to feed scheduleMaker, print a blank schedule to the JPane
    //TODO: Have two fields, hour field and minute field, that reset after each input (name field too)
    //and enable repeated input for the next activity

    public BackTrackRunner(ScheduleMaker scheduleMaker) {

        this.scheduleMaker = scheduleMaker;
        this.inputValidator = new InputValidator();
        this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));
        this.setLayout(new GridLayout(3, 4, 3, 3));

        activityName.setBackground(Color.PINK);
        activityName.setForeground(Color.WHITE);

        Instructions.setLineWrap(true);
        Instructions.setFont(inputTextFont);
        this.add(Instructions);
        destination.setFont(inputTextFont);
        destination.setLineWrap(true);
        this.add(destination);
        activityName.setFont(inputTextFont);
        this.add(activityName);
        displaySchedule.setFont(inputTextFont);
        displaySchedule.setLineWrap(true);
        this.add(displaySchedule);
        startOver.setFont(buttonFont);
        this.add(startOver);
        ETAInput.setFont(inputTextFont);
        this.add(ETAInput);
        activityDuration.setFont(inputTextFont);
        this.add(activityDuration);
        MiniSchedule.setFont(inputTextFont);
        this.add(MiniSchedule);
        clickToFinish.setFont(buttonFont);
        this.add(clickToFinish);
        addETA.setFont(buttonFont);
        this.add(addETA);
        addActivity.setFont(buttonFont);
        this.add(addActivity);


        displaySchedule.setEditable(false);
        displaySchedule.setText("Your schedule will display here.");
        Instructions.setEditable(false);


        this.addActivity.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String activity = activityName.getText();

                String duration = activityDuration.getText();

                boolean durationIsValid = InputValidator.DurationIsValid(duration);

                if (durationIsValid) {
                    scheduleMaker.add(new Item(activity, Integer.parseInt(duration)));
                }

                else {
                    activityDuration.setBackground(Color.RED);
                    activityDuration.setForeground(Color.WHITE);
                    activityDuration.setText("Please enter the duration in minutes ('5', '45', etc.)");
                }

            }
        });

        this.addETA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ETA_string = ETAInput.getText();

                if (ETAInput.getText().length()<5) {
                    ETA_string = "0".concat(ETA_string);
                    System.out.println(ETA_string);
                }

                String finalDestination = destination.getText();

                if (InputValidator.ETAIsValid(ETA_string)) {
                    scheduleMaker.setETA(LocalTime.parse(ETA_string), finalDestination);
                    addETA.setText("Change ETA");
                }

                else {
                    ETAInput.setForeground(Color.WHITE);
                    ETAInput.setBackground(Color.RED);
                    ETAInput.setText("ETA format must be '9:00' or '09:00'");
                }
            }
        });

        this.clickToFinish.addActionListener(new ActionListener() {
            //TODO Add a finish validator
            @Override
            public void actionPerformed(ActionEvent e) {
                scheduleMaker.updateItemTimes();
                scheduleMaker.setWake_up_time();
                scheduleMaker.generateSchedule();
                schedule = scheduleMaker.getSchedule();
                System.out.println(schedule.listItems());
                displaySchedule.setBackground(Color.PINK);
                displaySchedule.setText(schedule.listItems());
                displaySchedule.setVisible(true);
            }
        });

        this.startOver.addActionListener(new ActionListener() {
            //TODO Fix more with start over
            @Override
            public void actionPerformed(ActionEvent e) {
                scheduleMaker.clear();
                addETA.setText("Set ETA");
            }
        });

    }


}
