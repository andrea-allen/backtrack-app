package ui;

import com.backtrack.model.ScheduleMaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

public class BackTrackRunner extends JPanel {

    public static final int BOX_WIDTH = 640;
    public static final int BOX_HEIGHT = 480;

    public static JButton inputButton = new JButton("Send");

    public static JButton ETAButton = new JButton("Set ETA");

    public static JTextArea editTextArea = new JTextArea("Type Here!");

    public static JTextArea anotherTextArea = new JTextArea("Minute here!");

    public static JTextArea nameField = new JTextArea("Activity");

    private static ScheduleMaker scheduleMaker;
    //TODO: Get the text input to feed scheduleMaker, print a blank schedule to the JPane
    //TODO: Have two fields, hour field and minute field, that reset after each input (name field too)
    //and enable repeated input for the next activity

    public BackTrackRunner(ScheduleMaker scheduleMaker) {

        this.scheduleMaker = scheduleMaker;
        this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));

        editTextArea.setBackground(Color.BLUE);
        editTextArea.setForeground(Color.WHITE);

        anotherTextArea.setBackground(Color.GREEN);
        anotherTextArea.setForeground(Color.WHITE);

        nameField.setBackground(Color.PINK);
        nameField.setForeground(Color.WHITE);

        this.add(inputButton, BorderLayout.WEST);
        this.add(ETAButton, BorderLayout.SOUTH);
        this.add(editTextArea, BorderLayout.SOUTH);
        this.add(anotherTextArea, BorderLayout.EAST);
        this.add(nameField, BorderLayout.NORTH);
        //put a new button here to submit ETA separate from adding items to the schedule with different input fields


        this.inputButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                //TODO: Have some feeder form method here, that gives the whole form to a scheduleMaker controller, once it's filled out, and then returns a completed schedule from scheduleMaker and prints it to the GUI.

                String hourString = editTextArea.getText();

                editTextArea.setText("more?");
                //TODO why does the text box now disappear after I send the first message?

                System.out.println(hourString);

                int hour = Integer.parseInt(hourString);

                System.out.println("hour " + hour);

                String minuteString = anotherTextArea.getText();

                int minute = Integer.parseInt(minuteString);

                System.out.println("minute: " + minute);

                String activity = nameField.getText();

                System.out.println("Activity  " + activity);

                scheduleMaker.setETA(LocalTime.of(hour, minute));

                System.out.println(scheduleMaker.getETA());

                //TODO make an error exception / validation for no minute or hour entered


            }
        });

        this.ETAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

    }

    //Should take a schedule factory as an argument and make an interactive controller that processes from the UI
    //Should have a run method that updates the schedule and moves the process along
}
