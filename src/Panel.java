import javax.swing.*;

public class Panel {
    public Panel() {
        JFrame frame = new JFrame("Adventure");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(928, 793); // 540 height of image + 40 for window menu bar
        frame.setLocationRelativeTo(null);
        GraphicsPanel panel = new GraphicsPanel();
        frame.add(panel);
        frame.setVisible(true);
    }
}
