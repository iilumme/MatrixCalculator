package matrixcalculator.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
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
        c.setLayout(new GridLayout(2, 4));
        c.setBackground(Color.white);
        
        JPanel first = new JPanel(new GridLayout(1, 3));
        
        JTextArea rows = new JTextArea();
        JTextArea columns = new JTextArea();
        JButton enter = new JButton();
        
        first.add(rows);
        first.add(columns);
        first.add(enter);
        
        JPanel second = new JPanel(new GridLayout(1, 3));
        
        JTextArea rows2 = new JTextArea();
        JTextArea columns2 = new JTextArea();
        JButton enter2 = new JButton();
        
        second.add(rows2);
        second.add(columns2);
        second.add(enter2);
        
        c.add(first);
        c.add(second);
        c.add(new JPanel());
        c.add(new JPanel());
        c.add(new JPanel());
        c.add(new JPanel());
        
    }

}
