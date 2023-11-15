import javax.swing.*;
import java.awt.*;

public class gasStationSim extends JFrame {

    private JPanel panel1, panel2, panel3;
    private JTabbedPane tabbedPane;
    private JButton carInButton, carOutButton, pump1Button, pump2Button, pump3Button, pump4Button, pump5Button, pump6Button, pump7Button, pump8Button;

    public gasStationSim() {
        // Set the title of the JFrame
        super("GUI GSS");

        // Create a JTabbedPane
        tabbedPane = new JTabbedPane();

        // Create the first tab and add a panel with some text and buttons
        panel1 = new JPanel(new GridBagLayout()); // Use GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();

        panel1.add(new JLabel("Gas Station Simulation"));

        // Add empty space
        //gbc.gridy = 1;
        gbc.weighty = 1.0; // Vertical weight to fill the space
        panel1.add(Box.createVerticalGlue(), gbc);

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

        gbc.gridy = 2;
        gbc.weighty = 0.0; // Reset vertical weight

        panel1.add(carInButton, gbc);

        gbc.gridx = 1;
        panel1.add(carOutButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel1.add(pump1Button, gbc);

        gbc.gridx = 1;
        panel1.add(pump2Button, gbc);

        // Add the first tab to the tabbedPane
        tabbedPane.addTab("Tab 1", panel1);

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
