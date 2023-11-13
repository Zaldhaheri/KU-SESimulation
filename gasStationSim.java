import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleJFrameWithTabs extends JFrame {

    public SimpleJFrameWithTabs() {
        // Set the title of the JFrame
        super("Simple JFrame with Tabs");

        // Create a JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Create the first tab and add a panel with some text and a button
        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("Gas Station Simulation"));
        JButton carInButton = new JButton("Car In");
        panel1.add(carInButton);
        tabbedPane.addTab("Tab 1", panel1);

        // Create the second tab and add a panel with some text
        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("Availability Monitor"));
        tabbedPane.addTab("Tab 2", panel2);

        // Create the third tab and add a panel with some text
        JPanel panel3 = new JPanel();
        panel3.add(new JLabel("Estimated Waiting Time Monitor"));
        tabbedPane.addTab("Tab 3", panel3);

        // Set default close operation and size of the JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        // Add the tabbedPane to the JFrame
        getContentPane().add(tabbedPane);

        // Set the JFrame to be visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> new SimpleJFrameWithTabs());
    }
}
