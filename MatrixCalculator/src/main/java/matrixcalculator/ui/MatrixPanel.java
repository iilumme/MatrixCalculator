package matrixcalculator.ui;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import matrixcalculator.ui.listeners.EnterButtonListener;
import matrixcalculator.ui.listeners.MatrixButtonListener;

/**
 * Panel in which are the matrix and RowXColumn setting.
 */
public class MatrixPanel extends JPanel {

    private final RowsAndColumnsPanel rowsAndColumnsPanel;
    private MatrixField matrixField;

    public MatrixPanel(CalculationPanel calculationPanel) {
        setLayout(new BorderLayout(0, 20));

        this.rowsAndColumnsPanel = new RowsAndColumnsPanel();
        this.matrixField = new MatrixField(3, 3);

        add(rowsAndColumnsPanel, BorderLayout.NORTH);
        add(matrixField, BorderLayout.CENTER);

        this.rowsAndColumnsPanel.getEnter().addActionListener(new EnterButtonListener(this.rowsAndColumnsPanel, this, calculationPanel));
        this.rowsAndColumnsPanel.getZeroMatrixButton().addActionListener(new MatrixButtonListener(this.rowsAndColumnsPanel.getZeroMatrixButton(), this));
        this.rowsAndColumnsPanel.getIdentityMatrixButton().addActionListener(new MatrixButtonListener(this.rowsAndColumnsPanel.getIdentityMatrixButton(), this));
        this.rowsAndColumnsPanel.getEmptyButton().addActionListener(new MatrixButtonListener(this.rowsAndColumnsPanel.getEmptyButton(), this));
        
        setOpaque(false);
    }

    public MatrixField getMatrixField() {
        return matrixField;
    }

    public void setMatrixField(MatrixField matrixField) {
        this.matrixField = matrixField;
    }
}
