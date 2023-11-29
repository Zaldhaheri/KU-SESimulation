import javax.swing.*;
import javax.swing.border.Border;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.event.*;

public class gasStationSim extends JFrame {
    // private variables to use in this class
    private JPanel panel1, panel2, panel3;
    private JTabbedPane tabbedPane;
    private JTextArea carCountDisplay, estimatedTimeDisplay;
    private JButton carInButton, carOutButton, pump1Button, pump2Button, pump3Button, pump4Button, pump5Button,
            pump6Button, pump7Button, pump8Button;
    private int carCount = 0;
    private Color[] sharedColors = { Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN,
            Color.GREEN, Color.GREEN };
    private JPanel[] colorPanels;
    private int activePumpCount = 0; // Track the number of active pumps

    // gui main content
    public gasStationSim() {
        super("GUI GSS"); // name of the gui window
        tabbedPane = new JTabbedPane(); // create tabbed pane for the main JFrame

        panel1 = new JPanel(); // panel 1 containing the buttons
        panel1.setLayout(new GridLayout(8, 6)); // first panel is a grid layout
        panel1.setBackground(Color.GRAY);
        tabbedPane.addTab("Tab 1", panel1);

        panel2 = new JPanel(); // panel 2 containing the screen shown to customers for availability of pumps
        tabbedPane.addTab("Tab 2", panel2);

        panel3 = new JPanel(); // panel 3 shows the estimated time monitor
        panel3.add(new JLabel("Estimated Waiting Time Monitor"));
        tabbedPane.addTab("Tab 3", panel3);

        class RoundedBorder extends AbstractBorder { // Display monitor customization class
            private final Color color;
            private final int thickness;
            private final int radius;

            public RoundedBorder(Color color, int thickness, int radius) {
                this.color = color;
                this.thickness = thickness;
                this.radius = radius;
            }

            @Override
            public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
                super.paintBorder(c, g, x, y, width, height);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(color);
                g2d.setStroke(new BasicStroke(thickness));
                g2d.draw(new RoundRectangle2D.Double(x, y, width - 1, height - 1, radius, radius));
            }
        }

        // TAB 1 CONTENT//

        ButtonHandler BH = new ButtonHandler(); // button handler for normal buttons
        PumpHandler PH = new PumpHandler(); // same but for pump buttons

        carCountDisplay = new JTextArea(); // to display text area
        estimatedTimeDisplay = new JTextArea(); // to display estimated time
        carCountDisplay.setEditable(false); // can't be edited by the user
        estimatedTimeDisplay.setEditable(false);
        carCountDisplay.setText("Car Count: " + carCount); // default text on textarea
        estimatedTimeDisplay.setText("EST.: 0.0 mins");

        JLabel lane1 = new JLabel("Lane 1"); // labels to add later in the panel
        JLabel lane2 = new JLabel("Lane 2");
        JLabel lane3 = new JLabel("Lane 3");
        JLabel lane4 = new JLabel("Lane 4");
        lane1.setHorizontalAlignment(SwingConstants.CENTER); // set the labels to the center of their grid
        lane2.setHorizontalAlignment(SwingConstants.CENTER);
        lane3.setHorizontalAlignment(SwingConstants.CENTER);
        lane4.setHorizontalAlignment(SwingConstants.CENTER);

        carInButton = new JButton("Car In"); // initializing all buttons
        carOutButton = new JButton("Car Out");
        pump1Button = new JButton("Pump 1");
        pump2Button = new JButton("Pump 2");
        pump3Button = new JButton("Pump 3");
        pump4Button = new JButton("Pump 4");
        pump5Button = new JButton("Pump 5");
        pump6Button = new JButton("Pump 6");
        pump7Button = new JButton("Pump 7");
        pump8Button = new JButton("Pump 8");

        pump1Button.setBackground(Color.GREEN); // default color set for the pump buttons
        pump2Button.setBackground(Color.GREEN);
        pump3Button.setBackground(Color.GREEN);
        pump4Button.setBackground(Color.GREEN);
        pump5Button.setBackground(Color.GREEN);
        pump6Button.setBackground(Color.GREEN);
        pump7Button.setBackground(Color.GREEN);
        pump8Button.setBackground(Color.GREEN);

        carInButton.addActionListener(BH); // button handlers for when clicked
        carOutButton.addActionListener(BH);

        pump1Button.addActionListener(PH); // pump handlers for when clicked
        pump2Button.addActionListener(PH);
        pump3Button.addActionListener(PH);
        pump4Button.addActionListener(PH);
        pump5Button.addActionListener(PH);
        pump6Button.addActionListener(PH);
        pump7Button.addActionListener(PH);
        pump8Button.addActionListener(PH);

        // seperated into rows and coloumns, adding content to the panel itself
        panel1.add(new JLabel("")); // first row
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(estimatedTimeDisplay);
        panel1.add(carCountDisplay);

        panel1.add(carOutButton); // second row
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));

        panel1.add(new JLabel(""));// third row
        panel1.add(new JLabel(""));
        panel1.add(lane1);
        panel1.add(lane2);
        panel1.add(lane3);
        panel1.add(lane4);

        panel1.add(new JLabel(""));// fourth row
        panel1.add(new JLabel(""));
        panel1.add(pump2Button);
        panel1.add(pump4Button);
        panel1.add(pump6Button);
        panel1.add(pump8Button);

        panel1.add(new JLabel(""));// fifth row
        panel1.add(new JLabel(""));
        panel1.add(pump1Button);
        panel1.add(pump3Button);
        panel1.add(pump5Button);
        panel1.add(pump7Button);

        panel1.add(new JLabel(""));// sixth row
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));

        panel1.add(carInButton); // seventh row
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));

        panel1.add(new JLabel("")); // eighth row
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));

        // TAB 2 CONTENT//

        panel2.setLayout(new GridLayout(2, 4));
        RoundedBorder roundedBorder = new RoundedBorder(Color.BLACK, 19, 40);

        colorPanels = new JPanel[sharedColors.length];
        Color[] colors = { Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN,
                Color.GREEN };
        String[] texts = { "2", "4", "6", "8", "1", "3", "5", "7" };

        for (int i = 0; i < colors.length; i++) {
            JPanel colorPanel = new JPanel();
            colorPanel.setLayout(new BorderLayout()); // Use BorderLayout for better control of label positioning
            colorPanel.setBackground(sharedColors[i]);
            colorPanel.setBorder(roundedBorder); // Set the custom rounded border

            JLabel label = new JLabel(texts[i]);
            label.setForeground(Color.BLACK); // Set the text color
            label.setHorizontalAlignment(JLabel.CENTER); // Center the text horizontally
            label.setFont(new Font("Serif", Font.BOLD, 75));
            colorPanel.add(label); // Add the label to the panel

            panel2.add(colorPanel);
            colorPanels[i] = colorPanel;
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exits the program when jframe is closed
        setSize(800, 500); // default size of the window
        getContentPane().add(tabbedPane);// adds tabbedpane to the jframe
        setVisible(true);// sets it to visible to display
    }

    class ButtonHandler implements ActionListener // button handler for buttons
    {
        public void actionPerformed(ActionEvent e) // gets the clicked button
        {
            if (e.getActionCommand().equals("Car In")) // adds to car count when clicked
                carCount++;
            if (e.getActionCommand().equals("Car Out")) { // subs to car count when clicked
                if (carCount == 0)
                    System.out.println("No cars in the station");
                else
                    carCount--;
            }
            System.out.println("carCount: " + carCount);
            carCountDisplay.setText("Car Count: " + carCount); // displays the new car count
            if ((carCount - 8) > 0) // checks if there are more than 8 cars
                estimatedTimeDisplay.setText("EST.: " + ((carCount - 4) / 4) * 0.5 + " mins"); // for every new 4 cars
                                                                                               // adds 30 seconds
            else
                estimatedTimeDisplay.setText("EST.: 0.0 mins"); // default estimated time

        }
    }

    class PumpHandler implements ActionListener// pump handler for pump buttons
    {
        public void actionPerformed(ActionEvent e) {
            JButton clickedPump = (JButton) e.getSource(); // gets which button was clicked
            int pumpIndex = -1;

            if (clickedPump == pump1Button)
                pumpIndex = 4;
            else if (clickedPump == pump2Button)
                pumpIndex = 0;
            else if (clickedPump == pump3Button)
                pumpIndex = 5;
            else if (clickedPump == pump4Button)
                pumpIndex = 1;
            else if (clickedPump == pump5Button)
                pumpIndex = 6;
            else if (clickedPump == pump6Button)
                pumpIndex = 2;
            else if (clickedPump == pump7Button)
                pumpIndex = 7;
            else if (clickedPump == pump8Button)
                pumpIndex = 3;

            if (pumpIndex != -1) {
                if (activePumpCount < carCount) {
                    final int finalPumpIndex = pumpIndex;
                    final JButton finalClickedPump = clickedPump;

                    // Change the color of the button and the corresponding panel
                    Color newColor = Color.RED;
                    finalClickedPump.setBackground(newColor);
                    colorPanels[finalPumpIndex].setBackground(newColor);

                    activePumpCount++; // Increment active pump count

                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }

                            SwingUtilities.invokeLater(new Runnable() {
                                public void run() {
                                    finalClickedPump.setBackground(Color.GREEN);
                                    colorPanels[finalPumpIndex].setBackground(Color.GREEN);

                                    activePumpCount--; // Decrement active pump count
                                    if (carCount!=0)
                                        carCount--; // Decrement car count
                                    carCountDisplay.setText("Car Count: " + carCount);
                                    if ((carCount - 8) > 0) {
                                        estimatedTimeDisplay.setText("EST.: " + ((carCount - 4) / 4) * 0.5 + " mins");
                                    } else {
                                        estimatedTimeDisplay.setText("EST.: 0.0 mins");
                                    }
                                }
                            });
                        }
                    }).start();
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(gasStationSim::new); // runs the GUI
    }
}