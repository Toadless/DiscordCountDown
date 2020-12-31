package uk.toadl3ss.NewYearRPC;

import javax.swing.*;
import java.awt.*;

public class GUI {
    public static void openGUI() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder());
        panel.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));
        panel.setLayout(new GridLayout(0 ,1));
        JLabel title = new JLabel("Discord New Year Countdown");
        title.setFont(new Font("Courier", Font.BOLD,25));
        panel.add(title);
        JLabel title1 = new JLabel("Counter Started! Check your discord profile!");
        panel.add(title1);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Discord RPC");
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
