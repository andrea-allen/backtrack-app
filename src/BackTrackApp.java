import com.backtrack.model.Main;
import com.backtrack.model.ScheduleFactory;
import com.backtrack.model.ScheduleMaker;
import ui.BackTrackRunner;

import javax.swing.*;
import java.io.IOException;

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
                try {
                    Main.main();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
