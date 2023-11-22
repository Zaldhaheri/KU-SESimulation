import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class gasStationSim extends JFrame {

    //create private variables to use in different parts of the system
    private JPanel panel1, panel2, panel3;
    private JTabbedPane tabbedPane;
    private JTextArea carCountDisplay, estimatedTimeDisplay;
    private JButton carInButton, carOutButton, pump1Button, pump2Button, pump3Button, pump4Button, pump5Button, pump6Button, pump7Button, pump8Button;
    private int carCount = 0;


    public gasStationSim() {
        super("GUI GSS");

        tabbedPane = new JTabbedPane();

        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(8, 6));
        panel1.setBackground(Color.WHITE);
        tabbedPane.addTab("Tab 1", panel1);
        ButtonHandler BH = new ButtonHandler();

        carCountDisplay = new JTextArea();
        estimatedTimeDisplay = new JTextArea();
        carCountDisplay.setEditable(false);
        estimatedTimeDisplay.setEditable(false);
        carCountDisplay.setText("Car Count: " + carCount);
        estimatedTimeDisplay.setText("ET: 0.0 mins");

        JLabel lane1 = new JLabel("Lane 1");
        JLabel lane2 = new JLabel("Lane 2");
        JLabel lane3 = new JLabel("Lane 3");
        JLabel lane4 = new JLabel("Lane 4");
        lane1.setHorizontalAlignment(SwingConstants.CENTER);
        lane2.setHorizontalAlignment(SwingConstants.CENTER);
        lane3.setHorizontalAlignment(SwingConstants.CENTER);
        lane4.setHorizontalAlignment(SwingConstants.CENTER);

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

        pump1Button.setBackground(Color.GREEN);
        pump2Button.setBackground(Color.GREEN);
        pump3Button.setBackground(Color.GREEN);
        pump4Button.setBackground(Color.GREEN);
        pump5Button.setBackground(Color.GREEN);
        pump6Button.setBackground(Color.GREEN);
        pump7Button.setBackground(Color.GREEN);
        pump8Button.setBackground(Color.GREEN);

        carInButton.addActionListener(BH);
        carOutButton.addActionListener(BH);

        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(estimatedTimeDisplay);
        panel1.add(carCountDisplay);

        panel1.add(carOutButton);
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));

        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(lane1);
        panel1.add(lane2);
        panel1.add(lane3);
        panel1.add(lane4);

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

        panel1.add(new JLabel(""));
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

    class ButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getActionCommand().equals("Car In"))
                carCount++;
            if (e.getActionCommand().equals("Car Out")){
                if (carCount == 0)
                    System.out.println("No cars in the station");
                else
                    carCount--;
            }
            System.out.println("carCount: " + carCount);
            carCountDisplay.setText("Car Count: " + carCount);
            if((carCount - 8) > 0)
                estimatedTimeDisplay.setText("ET: " + (carCount - 8) * 0.5 + " mins");
            else
                estimatedTimeDisplay.setText("ET: 0.0 mins");

        }
    }

    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> new gasStationSim());
    }
}
