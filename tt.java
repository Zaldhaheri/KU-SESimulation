import javax.swing.*;
import java.awt.*;
import javax.swing.border.AbstractBorder;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GasStationSim extends JFrame {
    private GasStationUI ui;

    public GasStationSim() {
        super("GUI GSS");
        ui = new GasStationUI();
        add(ui.getTabbedPane());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GasStationSim::new);
    }
}

public class GasStationUI {
    private JTabbedPane tabbedPane;
    private JPanel panel1, panel2, panel3;
    private JTextArea carCountDisplay, estimatedTimeDisplay;
    private JLabel timeLabel;
    private JButton carInButton, carOutButton, pump1Button, pump2Button, pump3Button, pump4Button, pump5Button,
            pump6Button, pump7Button, pump8Button;
    private int carCount = 0;
    private Color[] sharedColors = { Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN,
            Color.GREEN, Color.GREEN };
    private JPanel[] colorPanels;
    private int activePumpCount = 0;
    private JLabel directionLabel;

    class RoundedBorder extends AbstractBorder {
        private final int arc;
        private final Color color;
        private final int thickness;

        public RoundedBorder(Color color, int arc, int thickness) {
            this.arc = arc;
            this.thickness = thickness;
            this.color = color;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            super.paintBorder(c, g, x, y, width, height);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(color);
            g2d.setStroke(new BasicStroke(thickness));
            g2d.draw(new RoundRectangle2D.Double(x, y, width - 1, height - 1, arc, arc));
        }
    }

    public GasStationUI() {
        colorPanels = new JPanel[8]; // Assuming there are 8 pumps
        // Create and configure each panel
        RoundedBorder roundedBorder = new RoundedBorder(Color.BLACK, 19, 40);
        for (int i = 0; i < colorPanels.length; i++) {
            JPanel colorPanel = new JPanel();
            colorPanel.setLayout(new BorderLayout());
            colorPanel.setBackground(sharedColors[i]); // Make sure sharedColors is initialized
            colorPanel.setBorder(roundedBorder);

            JLabel label = new JLabel(String.valueOf(i + 1)); // Labels from 1 to 8
            label.setForeground(Color.BLACK);
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setFont(new Font("Serif", Font.BOLD, 75));
            colorPanel.add(label);

            colorPanels[i] = colorPanel;
        }
        initializeUI();
    }

    private void initializeUI() {
        tabbedPane = new JTabbedPane();

        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(8, 6));
        panel1.setBackground(Color.GRAY);
        tabbedPane.addTab("Tab 1", panel1);

        panel2 = new JPanel();
        tabbedPane.addTab("Tab 2", panel2);

        panel3 = new JPanel();
        panel3.setLayout(new BorderLayout());
        tabbedPane.addTab("Tab 3", panel3);

        ButtonHandler BH = new ButtonHandler(this);
        PumpHandler PH = new PumpHandler(this);

        carCountDisplay = new JTextArea();
        estimatedTimeDisplay = new JTextArea();
        carCountDisplay.setEditable(false);
        estimatedTimeDisplay.setEditable(false);
        carCountDisplay.setText("Car Count: " + carCount);
        estimatedTimeDisplay.setText("EST.: 0.0 mins");

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

        pump1Button.addActionListener(PH);
        pump2Button.addActionListener(PH);
        pump3Button.addActionListener(PH);
        pump4Button.addActionListener(PH);
        pump5Button.addActionListener(PH);
        pump6Button.addActionListener(PH);
        pump7Button.addActionListener(PH);
        pump8Button.addActionListener(PH);

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
        panel1.add(pump2Button);
        panel1.add(pump4Button);
        panel1.add(pump6Button);
        panel1.add(pump8Button);

        panel1.add(new JLabel(""));
        panel1.add(new JLabel(""));
        panel1.add(pump1Button);
        panel1.add(pump3Button);
        panel1.add(pump5Button);
        panel1.add(pump7Button);

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

        // Set panel2 to use GridBagLayout
        panel2.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Common settings for all grid bag constraints
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        // Define the order of pumps in a 2D array (2 rows, 4 columns)
        int[][] pumpOrder = { { 1, 3, 5, 7 }, { 0, 2, 4, 6 } };

        // Add the panels to the grid
        for (int row = 0; row < pumpOrder.length; row++) {
            for (int col = 0; col < pumpOrder[row].length; col++) {
                gbc.gridx = col;
                gbc.gridy = row;
                panel2.add(colorPanels[pumpOrder[row][col]], gbc);
            }
        }

        // Add the direction label at the bottom
        gbc.gridx = 0; // Starting column
        gbc.gridy = 2; // Third row
        gbc.gridwidth = 4; // Span across all columns
        gbc.weighty = 0; // Less vertical weight for the label
        directionLabel = new JLabel("Drive to the lane 4)", SwingConstants.CENTER);
        directionLabel.setFont(new Font("Serif", Font.BOLD, 16));
        panel2.add(directionLabel, gbc);

        timeLabel = new JLabel(formatTime(carCount * 0.5));
        timeLabel.setFont(new Font("Serif", Font.BOLD, 120));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel3.add(timeLabel, BorderLayout.CENTER);
    }

    public JLabel getDirectionLabel() {
        return directionLabel;
    }

    public JButton getPump1Button() {
        return pump1Button;
    }

    public JButton getPump2Button() {
        return pump2Button;
    }

    public JButton getPump3Button() {
        return pump3Button;
    }

    public JButton getPump4Button() {
        return pump4Button;
    }

    public JButton getPump5Button() {
        return pump5Button;
    }

    public JButton getPump6Button() {
        return pump6Button;
    }

    public JButton getPump7Button() {
        return pump7Button;
    }

    public JButton getPump8Button() {
        return pump8Button;
    }

    public void incrementCarCount() {
        carCount++;
    }

    public void decrementCarCount() {
        if (carCount > 0) {
            carCount--;
        }
    }

    public int getCarCount() {
        return carCount;
    }

    public JPanel[] getColorPanels() {
        return colorPanels;
    }

    public int getActivePumpCount() {
        return activePumpCount;
    }

    public JTextArea getCarCountDisplay() {
        return carCountDisplay;
    }

    public JTextArea getEstimatedTimeDisplay() {
        return estimatedTimeDisplay;
    }

    public JLabel getTimeLabel() {
        return timeLabel;
    }

    public void incrementActivePumpCount() {
        activePumpCount++;
    }

    public void decrementActivePumpCount() {
        if (activePumpCount > 0) {
            activePumpCount--;
        }
    }

    public String formatTime(double time) {
        int minutes = (int) (time * 60);
        int hours = minutes / 60;
        minutes %= 60;
        return String.format("%02d:%02d MINS", hours, minutes);
    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }
}

public class ButtonHandler implements ActionListener {
    private GasStationUI ui;

    public ButtonHandler(GasStationUI ui) {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Car In")) {
            ui.incrementCarCount();
        } else if (e.getActionCommand().equals("Car Out")) {
            ui.decrementCarCount();
        }
        ui.getCarCountDisplay().setText("Car Count: " + ui.getCarCount());
        if ((ui.getCarCount() - 8) > 0) {
            ui.getEstimatedTimeDisplay().setText("EST.: " + ((ui.getCarCount() - 4) / 4) * 0.5 + " mins");
            ui.getTimeLabel().setText(ui.formatTime(((ui.getCarCount() - 4) / 4) * 0.5));
        } else {
            ui.getEstimatedTimeDisplay().setText("EST.: 0.0 mins");
            ui.getTimeLabel().setText(ui.formatTime(0));
        }
    }
}

public class PumpHandler implements ActionListener {
    private GasStationUI ui;

    public PumpHandler(GasStationUI ui) {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedPump = (JButton) e.getSource();
        int pumpIndex = -1;

        if (clickedPump == ui.getPump1Button())
            pumpIndex = 0;
        else if (clickedPump == ui.getPump2Button())
            pumpIndex = 1;
        else if (clickedPump == ui.getPump3Button())
            pumpIndex = 2;
        else if (clickedPump == ui.getPump4Button())
            pumpIndex = 3;
        else if (clickedPump == ui.getPump5Button())
            pumpIndex = 4;
        else if (clickedPump == ui.getPump6Button())
            pumpIndex = 5;
        else if (clickedPump == ui.getPump7Button())
            pumpIndex = 6;
        else if (clickedPump == ui.getPump8Button())
            pumpIndex = 7;

        if (pumpIndex != -1) {
            if (ui.getActivePumpCount() < ui.getCarCount()) {
                final int finalPumpIndex = pumpIndex;
                final JButton finalClickedPump = clickedPump;

                // Change the color of the button and the corresponding panel to red
                finalClickedPump.setBackground(Color.RED);
                ui.getColorPanels()[finalPumpIndex].setBackground(Color.RED);

                ui.incrementActivePumpCount();

                new Thread(() -> {
                    try {
                        Thread.sleep(15000); // Button stays red for 5 seconds
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    SwingUtilities.invokeLater(() -> {
                        // Change button and panel color to yellow
                        finalClickedPump.setBackground(Color.YELLOW);
                        ui.getColorPanels()[finalPumpIndex].setBackground(Color.YELLOW);
                        new Thread(() -> {
                            try {
                                Thread.sleep(2000); // Button stays yellow for 2 seconds
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                            SwingUtilities.invokeLater(() -> {
                                // Change button and panel color back to green
                                finalClickedPump.setBackground(Color.GREEN);
                                ui.getColorPanels()[finalPumpIndex].setBackground(Color.GREEN);

                                ui.decrementActivePumpCount();
                                if (ui.getCarCount() != 0)
                                    ui.decrementCarCount();

                                ui.getCarCountDisplay().setText("Car Count: " + ui.getCarCount());
                                if ((ui.getCarCount() - 8) > 0) {
                                    ui.getEstimatedTimeDisplay()
                                            .setText("EST.: " + ((ui.getCarCount() - 4) / 4) * 0.5 + " mins");
                                    ui.getTimeLabel().setText(ui.formatTime(((ui.getCarCount() - 4) / 4) * 0.5));
                                } else {
                                    ui.getEstimatedTimeDisplay().setText("EST.: 0.0 mins");
                                    ui.getTimeLabel().setText(ui.formatTime(0));
                                }
                            });
                        }).start();
                    });
                }).start();
            }
            updateDirectionLabel();
        }
    }

    private void updateDirectionLabel() {
    // Check pumps in each lane and update the direction accordingly

    if (!isPumpBusy(7) && !isPumpBusy(6)) { // Check Lane 4 (Pumps 8 and 7)
        ui.getDirectionLabel().setText("Drive to Lane 4"); // Lane 4 is available
    } else if (!isPumpBusy(5) && !isPumpBusy(4)) { // Check Lane 3 (Pumps 6 and 5)
        ui.getDirectionLabel().setText("Drive to Lane 3"); // Lane 3 is available
    } else if (!isPumpBusy(3) && !isPumpBusy(2)) { // Check Lane 2 (Pumps 4 and 3)
        ui.getDirectionLabel().setText("Drive to Lane 2"); // Lane 2 is available
    } else if (!isPumpBusy(1) && !isPumpBusy(0)) { // Check Lane 1 (Pumps 2 and 1)
        ui.getDirectionLabel().setText("Drive to Lane 1"); // Lane 1 is available
    } else if (!isPumpBusy(7) || !isPumpBusy(6)) { // Lane 4 has at least one available pump
        ui.getDirectionLabel().setText("Drive to Lane 4"); // Lane 4 is available with at least one pump free
    } else if (!isPumpBusy(5) || !isPumpBusy(4)) { // Lane 3 has at least one available pump
        ui.getDirectionLabel().setText("Drive to Lane 3"); // Lane 3 is available with at least one pump free
    } else if (!isPumpBusy(3) || !isPumpBusy(2)) { // Lane 2 has at least one available pump
        ui.getDirectionLabel().setText("Drive to Lane 2"); // Lane 2 is available with at least one pump free
    } else if (!isPumpBusy(1) || !isPumpBusy(0)) { // Lane 1 has at least one available pump
        ui.getDirectionLabel().setText("Drive to Lane 1"); // Lane 1 is available with at least one pump free
    } else {
        ui.getDirectionLabel().setText("Drive to Lane 4"); // All lanes have both pumps busy, loop back to Lane 4
    }
}

private boolean isPumpBusy(int pumpIndex) {
    return ui.getColorPanels()[pumpIndex].getBackground() == Color.RED;
}


    public class TimeFormatter {
        public static String formatTime(double time) {
            int minutes = (int) (time * 60);
            int hours = minutes / 60;
            minutes %= 60;
            return String.format("%02d:%02d MINS", hours, minutes);
        }
    }

    class RoundedBorder extends AbstractBorder {
        private final int arc;
        private final Color color;
        private final int thickness;

        public RoundedBorder(Color color, int arc, int thickness) {
            this.arc = arc;
            this.thickness = thickness;
            this.color = color;
            // Implementation of RoundedBorder - you might need to customize this based on
            // your requirements.
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            super.paintBorder(c, g, x, y, width, height);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(color);
            g2d.setStroke(new BasicStroke(thickness));
            g2d.draw(new RoundRectangle2D.Double(x, y, width - 1, height - 1, arc, arc));
        }
        // Override necessary methods from AbstractBorder.
    }
}