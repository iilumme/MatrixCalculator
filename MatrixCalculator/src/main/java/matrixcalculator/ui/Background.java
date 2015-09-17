package matrixcalculator.ui;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * The background of GUI.
 */
public class Background extends JPanel {

    private Image image;
    private final String backgroundPic = "matcalc.jpeg";
    private final CalculationPanel calculationPanel;
    private final ButtonsPanel buttonsPanel;
    

    public Background() {
        this.image = null;
        this.calculationPanel = new CalculationPanel();
        this.buttonsPanel = new ButtonsPanel(this.calculationPanel);
        
        
        setLayout(new BorderLayout(0, 50));
        add(this.buttonsPanel, BorderLayout.NORTH);
        add(this.calculationPanel, BorderLayout.CENTER);
    }

    @Override
    public void paintComponent(Graphics g) {
        try {
            this.image = ImageIO.read(new java.net.URL(ClassLoader.getSystemResource(backgroundPic), "matcalc.jpeg"));
        } catch (IOException ex) {
            Logger.getLogger(Background.class.getName()).log(Level.SEVERE, null, ex);
        }

        g.drawImage(this.image, 0, 0, this);
    }
}
