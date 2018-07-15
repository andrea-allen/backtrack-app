
import com.backtrack.model.ScheduleMaker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class ClassFrameEx extends JFrame {

    private static final long serialVersionUID = 2451829341034438685L;

    public static JButton inputButton = new JButton("Send");
    public static JTextArea editTextArea = new JTextArea("Type Here!");
    public static JTextArea uneditTextArea = new JTextArea();
    public static JTextArea anotherTextArea = new JTextArea("Minute here!");
    private String hourString;
    private ScheduleMaker scheduleMaker;
    private String minuteString;

    public ClassFrameEx(String title) {

        //SET LAYOUT MANAGER (How it arranges components)
        setLayout(new BorderLayout());
        //////CREATE SWING COMPONENTS////////////
        //OUTPUT TEXT AREA
        uneditTextArea.setEditable(false);

        //INPUT TEXT AREA
        editTextArea.setBackground(Color.BLUE);
        editTextArea.setForeground(Color.WHITE);

        anotherTextArea.setBackground(Color.GREEN);
        anotherTextArea.setForeground(Color.WHITE);
        //SET CONTENT PANE
        Container c = getContentPane();

        //ADD COMPONENTS TO CONTENT PANE
        c.add(uneditTextArea, BorderLayout.CENTER);
        c.add(editTextArea, BorderLayout.CENTER);
        c.add(anotherTextArea, BorderLayout.SOUTH);
        c.add(inputButton, BorderLayout.WEST);

        ClassFrameEx.inputButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // MA - Using the class field hourString to receive text from text area

                hourString = editTextArea.getText();

                minuteString = anotherTextArea.getText();

                editTextArea.setText("");

                System.out.println(hourString);

                int hour = Integer.parseInt(hourString);

                System.out.println("hour " + hour);

                int minute = Integer.parseInt(minuteString);

                System.out.println("minute: " + minute);
            }
        });
    }
}
