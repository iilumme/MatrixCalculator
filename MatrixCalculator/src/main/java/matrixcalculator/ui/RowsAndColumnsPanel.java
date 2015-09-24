package matrixcalculator.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Panel for setting the count of rows and columns.
 */
public class RowsAndColumnsPanel extends JPanel {

    private final JPanel rowPanel;
    private final JLabel rowLabel;
    private final JTextField rows;

    private final JPanel columnPanel;
    private final JLabel columnLabel;
    private final JTextField columns;

    private final JButton enter;
    private final JButton zeroMatrix;
    private final JButton identityMatrix;
    private final JButton empty;

    public RowsAndColumnsPanel() {
        setLayout(new GridLayout(2, 3));

        this.rowPanel = new JPanel(new BorderLayout());
        this.rowLabel = new JLabel(" rows");
        this.rows = new JTextField(5);
        rowPanel.add(rowLabel, BorderLayout.WEST);
        rowPanel.add(rows, BorderLayout.EAST);
        rowPanel.setBackground(Color.LIGHT_GRAY);

        this.columnPanel = new JPanel(new BorderLayout());
        this.columnLabel = new JLabel(" columns");
        this.columns = new JTextField(5);
        columnPanel.add(columnLabel, BorderLayout.WEST);
        columnPanel.add(columns, BorderLayout.EAST);
        columnPanel.setBackground(Color.LIGHT_GRAY);

        this.enter = new JButton("Set");
        this.zeroMatrix = new JButton("Zero Matrix");
        this.identityMatrix = new JButton("Identity Matrix");
        this.empty = new JButton("Empty");
        
        this.zeroMatrix.setName("zero");
        this.identityMatrix.setName("identity");
        this.empty.setName("empty");

        
        add(rowPanel);
        add(columnPanel);
        add(enter);
        add(zeroMatrix);
        add(identityMatrix);
        add(empty);

        setBackground(Color.LIGHT_GRAY);
    }

    public JTextField getRows() {
        return rows;
    }

    public JTextField getColumns() {
        return columns;
    }

    public JButton getEnter() {
        return enter;
    }

    public JButton getZeroMatrixButton() {
        return zeroMatrix;
    }

    public JButton getIdentityMatrixButton() {
        return identityMatrix;
    }

    public JButton getEmptyButton() {
        return empty;
    }
}
