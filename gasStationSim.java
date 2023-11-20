import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class gasStationSim extends JFrame {

    //create private variables to use in different parts of the system
    private JPanel panel1, panel2, panel3;
    private JTabbedPane tabbedPane;
    private JButton carInButton, carOutButton, pump1Button, pump2Button, pump3Button, pump4Button, pump5Button, pump6Button, pump7Button, pump8Button;

    public gasStationSim() {
        // Set the title of the JFrame
        super("GUI GSS");

        // Create a JTabbedPane
        tabbedPane = new JTabbedPane();

        // Create the first tab and add a panel with some text and a button
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(7, 6));
        //panel1.add(new JLabel("Gas Station Simulation"));
        tabbedPane.addTab("Tab 1", panel1);

        carInButton = new JButton("Car In");
        carOutButton = new JButton("Car Out");
        pump1Button = new JButton("Pump 1");
        pump2Button = new JButton("Pump 2");
        pump3Button = new JButton("Pump 3");
        pump4Button = new JButton("Pump 4");
        pump5Button = new JButton("Pump 5");
        pump6Button = new JButton("Pump 6");
        pump7Button = new JButton("Pump 7");
        pump8Button = new JButton("Pump 8");

        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));

        panel1.add(carOutButton);
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));

        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel("   Lane 1"));
        panel1.add(new JLabel("   Lane 2"));
        panel1.add(new JLabel("   Lane 3"));
        panel1.add(new JLabel("   Lane 4"));

        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(pump1Button);
        panel1.add(pump3Button);
        panel1.add(pump5Button);
        panel1.add(pump7Button);
        
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(pump2Button);
        panel1.add(pump4Button);
        panel1.add(pump6Button);
        panel1.add(pump8Button);

        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));

        panel1.add(carInButton);
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));

        // Create the second tab and add a panel with some text
        panel2 = new JPanel();
        panel2.add(new JLabel("Availability Monitor"));
        tabbedPane.addTab("Tab 2", panel2);

        // Create the third tab and add a panel with some text
        panel3 = new JPanel();
        panel3.add(new JLabel("Estimated Waiting Time Monitor"));
        tabbedPane.addTab("Tab 3", panel3);

        // Set default close operation and size of the JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);

        // Add the tabbedPane to the JFrame
        getContentPane().add(tabbedPane);

        // Set the JFrame to be visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> new gasStationSim());
    }
}
