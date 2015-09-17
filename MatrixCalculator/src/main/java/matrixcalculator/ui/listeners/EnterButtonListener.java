package matrixcalculator.ui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import matrixcalculator.ui.CalculationPanel;
import matrixcalculator.ui.MatrixPanel;
import matrixcalculator.ui.RowsAndColumnsPanel;

/**
 * ActionListener for ENTER button. Changes the rows and the columns of matrix.
 */
public class EnterButtonListener implements ActionListener {

    private final RowsAndColumnsPanel rowsAndColumnsPanel;
    private final MatrixPanel matrixPanel;
    private final CalculationPanel calculationPanel;

    public EnterButtonListener(RowsAndColumnsPanel racp, MatrixPanel mp, CalculationPanel cp) {
        this.rowsAndColumnsPanel = racp;
        this.matrixPanel = mp;
        this.calculationPanel = cp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int rows = 1;
        int columns = 1;

        if (this.rowsAndColumnsPanel.getRows().getText().matches("[0-9]+") && this.rowsAndColumnsPanel.getColumns().getText().matches("[0-9]+")) {
            rows = Integer.parseInt(this.rowsAndColumnsPanel.getRows().getText());
            columns = Integer.parseInt(this.rowsAndColumnsPanel.getColumns().getText());
            this.calculationPanel.emptyMessage();
        } else {
            this.calculationPanel.setMessage("Something wrong with cells");
        }

        this.matrixPanel.getMatrixField().setRows(rows);
        this.matrixPanel.getMatrixField().setColumns(columns);

        this.matrixPanel.getMatrixField().updateFields();
        this.matrixPanel.getMatrixField().createFields();
        this.matrixPanel.getMatrixField().addFields();

        this.matrixPanel.getMatrixField().revalidate();

    }

}
