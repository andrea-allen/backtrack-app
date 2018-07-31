import com.backtrack.model.ScheduleFactory;
import ui.BackTrackRunner;

import javax.swing.*;

public class BackTrackApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("BackTrack App");
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setContentPane(
                        new BackTrackRunner(ScheduleFactory.createScheduleMaker())
                );
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
