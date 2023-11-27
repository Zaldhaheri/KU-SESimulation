import javax.swing.*;
import javax.swing.border.Border;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.event.*;

public class GasStationSim extends JFrame {
    private JTabbedPane tabbedPane;

    public GasStationSim() {
        super("GUI GSS");
        tabbedPane = new JTabbedPane();

        Tab1Panel tab1 = new Tab1Panel();
        Tab2Panel tab2 = new Tab2Panel();
        Tab3Panel tab3 = new Tab3Panel();

        tabbedPane.addTab("Tab 1", tab1);
        tabbedPane.addTab("Tab 2", tab2);
        tabbedPane.addTab("Tab 3", tab3);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        getContentPane().add(tabbedPane);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GasStationSim::new);
    }
}


public class Tab1Panel extends JPanel {
    private JTextArea carCountDisplay, estimatedTimeDisplay;
    private JButton carInButton, carOutButton, pump1Button, pump2Button, pump3Button, pump4Button, pump5Button, pump6Button, pump7Button, pump8Button;
    private int carCount = 0;
    private JPanel[] colorPanels;

    public void setColorPanels(JPanel[] colorPanels) {
        this.colorPanels = colorPanels;
    }

    public Tab1Panel() {
        setLayout(new GridLayout(8, 6));
        setBackground(Color.GRAY);

        ButtonHandler BH = new ButtonHandler(); //button handler for normal buttons
        PumpHandler PH = new PumpHandler(); //same but for pump buttons

        carCountDisplay = new JTextArea(); //to display text area
        estimatedTimeDisplay = new JTextArea(); //to display estimated time
        carCountDisplay.setEditable(false); //can't be edited by the user
        estimatedTimeDisplay.setEditable(false);
        carCountDisplay.setText("Car Count: " + carCount); //default text on textarea
        estimatedTimeDisplay.setText("EST.: 0.0 mins");

        JLabel lane1 = new JLabel("Lane 1"); //labels to add later in the panel
        JLabel lane2 = new JLabel("Lane 2");
        JLabel lane3 = new JLabel("Lane 3");
        JLabel lane4 = new JLabel("Lane 4");
        lane1.setHorizontalAlignment(SwingConstants.CENTER); //set the labels to the center of their grid
        lane2.setHorizontalAlignment(SwingConstants.CENTER);
        lane3.setHorizontalAlignment(SwingConstants.CENTER);
        lane4.setHorizontalAlignment(SwingConstants.CENTER);

        carInButton = new JButton("Car In"); //initializing all buttons
        carOutButton = new JButton("Car Out");
        pump1Button = new JButton("Pump 1");
        pump2Button = new JButton("Pump 2");
        pump3Button = new JButton("Pump 3");
        pump4Button = new JButton("Pump 4");
        pump5Button = new JButton("Pump 5");
        pump6Button = new JButton("Pump 6");
        pump7Button = new JButton("Pump 7");
        pump8Button = new JButton("Pump 8");

        pump1Button.setBackground(Color.GREEN); //default color set for the pump buttons
        pump2Button.setBackground(Color.GREEN);
        pump3Button.setBackground(Color.GREEN);
        pump4Button.setBackground(Color.GREEN);
        pump5Button.setBackground(Color.GREEN);
        pump6Button.setBackground(Color.GREEN);
        pump7Button.setBackground(Color.GREEN);
        pump8Button.setBackground(Color.GREEN);

        carInButton.addActionListener(BH); //button handlers for when clicked
        carOutButton.addActionListener(BH);

        pump1Button.addActionListener(PH); //pump handlers for when clicked
        pump2Button.addActionListener(PH);
        pump3Button.addActionListener(PH);
        pump4Button.addActionListener(PH);
        pump5Button.addActionListener(PH);
        pump6Button.addActionListener(PH);
        pump7Button.addActionListener(PH);
        pump8Button.addActionListener(PH);

        //seperated into rows and coloumns, adding content to the panel itself
        this.add(new JLabel("")); //first row
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(estimatedTimeDisplay);
        this.add(carCountDisplay);

        this.add(carOutButton); //second row
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));

        this.add(new JLabel(""));//third row
        this.add(new JLabel(""));
        this.add(lane1);
        this.add(lane2);
        this.add(lane3);
        this.add(lane4);

        this.add(new JLabel(""));//fourth row
        this.add(new JLabel(""));
        this.add(pump2Button);
        this.add(pump4Button);
        this.add(pump6Button);
        this.add(pump8Button);
        
        this.add(new JLabel(""));//fifth row
        this.add(new JLabel(""));
        this.add(pump1Button);
        this.add(pump3Button);
        this.add(pump5Button);
        this.add(pump7Button);

        this.add(new JLabel(""));//sixth row
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));

        this.add(carInButton); //seventh row
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));

        this.add(new JLabel("")); //eighth row
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        this.add(new JLabel(""));
    }

    class ButtonHandler implements ActionListener //button handler for buttons
    {
        public void actionPerformed(ActionEvent e) //gets the clicked button
        {
            if (e.getActionCommand().equals("Car In")) //adds to car count when clicked
                carCount++;
            if (e.getActionCommand().equals("Car Out")){ //subs to car count when clicked
                if (carCount == 0)
                    System.out.println("No cars in the station");
                else
                    carCount--;
            }
            System.out.println("carCount: " + carCount); 
            carCountDisplay.setText("Car Count: " + carCount); //displays the new car count
            if((carCount - 8) > 0) //checks if there are more than 8 cars
                estimatedTimeDisplay.setText("EST.: " + ((carCount - 4)/4) * 0.5 + " mins"); //for every new 4 cars adds 30 seconds
            else
                estimatedTimeDisplay.setText("EST.: 0.0 mins"); //default estimated time

        }
    }

    class PumpHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton clickedPump = (JButton) e.getSource();
            int pumpIndex = getPumpIndex(clickedPump);
    
            if (pumpIndex != -1) {
                final int finalPumpIndex = pumpIndex;
                final JButton finalClickedPump = clickedPump;
    
                Color newColor = Color.RED;
                finalClickedPump.setBackground(newColor);
    
                // Access Swing components within the EDT
                SwingUtilities.invokeLater(() -> {
                    colorPanels[finalPumpIndex].setBackground(newColor);
                });
    
                new Thread(() -> {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
    
                    SwingUtilities.invokeLater(() -> {
                        finalClickedPump.setBackground(Color.GREEN);
                        colorPanels[finalPumpIndex].setBackground(Color.GREEN);
                    });
                }).start();
            }
        }
    
        // Helper method to get the index of the clicked pump
        private int getPumpIndex(JButton clickedPump) {
            if (clickedPump == pump1Button) return 4;
            else if (clickedPump == pump2Button) return 0;
            else if (clickedPump == pump3Button) return 5;
            else if (clickedPump == pump4Button) return 1;
            else if (clickedPump == pump5Button) return 6;
            else if (clickedPump == pump6Button) return 2;
            else if (clickedPump == pump7Button) return 7;
            else if (clickedPump == pump8Button) return 3;
            else return -1; // Return -1 if no pump matches
        }
    }

}

public class Tab2Panel extends JPanel {
    private JPanel[] colorPanels;
    private Color[] sharedColors = {Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN};
    private static class RoundedBorder extends AbstractBorder { //Display monitor customization class
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


    public Tab2Panel() {
        this.setLayout(new GridLayout(2,4));
        colorPanels = createColorPanels();
    }

    public JPanel[] getColorPanels() {
        return colorPanels;
    }


    private JPanel[] createColorPanels() {
        JPanel[] panels = new JPanel[sharedColors.length];

        for (int i = 0; i < sharedColors.length; i++) {
            JPanel colorPanel = new JPanel();
            colorPanel.setLayout(new BorderLayout());
            colorPanel.setBackground(sharedColors[i]);
            colorPanel.setBorder(new RoundedBorder(Color.BLACK, 19, 40)); // Apply rounded border directly here

            JLabel label = new JLabel(getLabelText(i));
            label.setForeground(Color.BLACK);
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setFont(new Font("Serif", Font.BOLD, 75));

            colorPanel.add(label);
            panels[i] = colorPanel;
        }
    
        return panels;
    }
    private String getLabelText(int index) {
        String[] texts = {"2", "4", "6", "8", "1", "3", "5", "7"};
        return texts[index];
    }
}


public class Tab3Panel extends JPanel {
    public Tab3Panel() {
        add(new JLabel("Estimated Waiting Time Monitor"));

        // Add components and setup specific to Tab 3 here...
        // ... (Content of the third tab goes here)
    }

    // Any additional inner classes or handlers can be defined here if needed for Tab 3.
}