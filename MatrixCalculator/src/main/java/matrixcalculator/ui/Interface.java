package matrixcalculator.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Graphical interface for MatrixCalculator.
 */
public class Interface implements Runnable {
    
    private JFrame frame;

    @Override
    public void run() {
        this.frame = new JFrame("MatrixCalculator");
        this.frame.setPreferredSize(new Dimension(1000, 600));
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents(this.frame.getContentPane());
        
        this.frame.pack();
        this.frame.setVisible(true);
    }

    private void createComponents(Container c) {       
        c.setLayout(new GridLayout(1, 1));
        c.add(new Background()); 
    }

}
