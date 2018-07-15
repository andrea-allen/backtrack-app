package ui;

import com.backtrack.model.ScheduleMaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackTrackRunner extends JPanel {

    public static final int BOX_WIDTH = 640;
    public static final int BOX_HEIGHT = 480;

    public static JButton inputButton = new JButton("Send");

    public static JTextArea editTextArea = new JTextArea("Type Here!");

    private ScheduleMaker scheduleMaker;

    public BackTrackRunner(ScheduleMaker scheduleMaker) {
        this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));

        editTextArea.setBackground(Color.BLUE);
        editTextArea.setForeground(Color.WHITE);

        this.scheduleMaker = scheduleMaker;
        this.add(inputButton, BorderLayout.WEST);
        this.add(editTextArea, BorderLayout.SOUTH);

        this.inputButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // MA - Using the class field hourString to receive text from text area

                String hourString = editTextArea.getText();

                editTextArea.setText("");

                System.out.println(hourString);

                int hour = Integer.parseInt(hourString);

                System.out.println("hour " + hour);

            }
        });

        Thread displayThread = new Thread() {
            public void run() {

            }
        };
        displayThread.start();
    }

    //Should take a schedule factory as an argument and make an interactive controller that processes from the UI
    //Should have a run method that updates the schedule and moves the process along
}
