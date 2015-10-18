package matrixcalculator.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * The background of GUI.
 */
public class Background extends JPanel {

    private final CalculationPanel calculationPanel;
    private final ButtonsPanel buttonsPanel;
    private final TimePanel timePanel;

    public Background() {
        this.calculationPanel = new CalculationPanel(this);
        this.buttonsPanel = new ButtonsPanel(this.calculationPanel);
        this.timePanel = new TimePanel();

        setBackground(Color.WHITE);
        setLayout(new BorderLayout(0, 50));
        add(this.buttonsPanel, BorderLayout.NORTH);
        add(this.calculationPanel, BorderLayout.CENTER);
        add(this.timePanel, BorderLayout.SOUTH);
    }

    public TimePanel getTimePanel() {
        return timePanel;
    }

    @Override
    public void paintComponent(Graphics g) {
    }
}
