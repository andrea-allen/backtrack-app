import javax.swing.*;
import java.io.IOException;

public class BackTrackApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new ClassFrameEx("BackTrack App");
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                //Put Content Pane here once ui has a class in it
                frame.pack();
                frame.setVisible(true);
                try {
                    com.backtrack.Main.main();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
