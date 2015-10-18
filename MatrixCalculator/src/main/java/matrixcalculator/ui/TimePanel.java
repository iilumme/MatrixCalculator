package matrixcalculator.ui;

import java.awt.Color;
import java.awt.GridLayout;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A panel for showing how much time a calculation operation takes.
 */
public class TimePanel extends JPanel {

    private JLabel time;

    public TimePanel() {
        super(new GridLayout(1, 1));
        setBackground(Color.LIGHT_GRAY);

        this.time = new JLabel("Time used: ");
        add(time);
    }

    public void setTime(double t) {
        BigDecimal bd = new BigDecimal(t);
        bd = bd.setScale(8, RoundingMode.HALF_EVEN);
        this.time.setText("Time used: " + bd + " seconds");
        revalidate();
        repaint();

    }

}
