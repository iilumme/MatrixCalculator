package matrixcalculator.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import matrixcalculator.matrix.Matrix;

/**
 * Panel in which are the matrices.
 */
public class CalculationPanel extends JPanel {

    private final JPanel multiplierPanel;
    private final JLabel multiplierLabel;
    private final JTextField multiplier;

    private final MatrixPanel first;
    private final MatrixPanel second;

    private MatrixLabel matrixLabel;
    private final JLabel message;

    public CalculationPanel() {

        this.multiplierPanel = new JPanel(new GridLayout(2, 1));
        this.multiplierLabel = new JLabel("Multiplier");
        this.multiplier = new JTextField("1");

        this.multiplierPanel.add(this.multiplierLabel);
        this.multiplierPanel.add(this.multiplier);
        this.multiplierPanel.setOpaque(false);

        this.first = new MatrixPanel(this);
        this.second = new MatrixPanel(this);

        this.matrixLabel = null;
        this.message = new JLabel();

        add(multiplierPanel, BorderLayout.LINE_START);
        add(first, BorderLayout.WEST);
        add(second, BorderLayout.EAST);
        add(message, BorderLayout.PAGE_END);

        setOpaque(false);
    }

    public Matrix getMatrix(String position) throws Exception {

        MatrixField field;

        if (position.equals("first")) {
            field = this.first.getMatrixField();
        } else {
            field = this.second.getMatrixField();
        }

        Matrix a = new Matrix(field.getRows(), field.getColumns());

        double[][] numbers = new double[field.getRows()][field.getColumns()];

        int row = 0;

        for (int column = 0; column < field.getColumns(); column++) {

            if (!field.getFields()[row][column].getText().matches("[0-9]+")) {
                throw new Exception("Something wrong with cells");
            }

            numbers[row][column] = Integer.parseInt(field.getFields()[row][column].getText());

            if (column == field.getColumns() - 1) {
                row++;
                column = -1;

                if (row == field.getRows()) {
                    break;
                }
            }
        }

        a.setNumbers(numbers);

        return a;
    }

    public int getMultiplier() {
        if (multiplier.getText().matches("[0-9]+")) {
            return Integer.parseInt(multiplier.getText());
        }

        multiplier.setText("1");
        return 1;
    }

    public void setResult(MatrixLabel matrixLabel) {
        this.matrixLabel = matrixLabel;
        add(this.matrixLabel, BorderLayout.SOUTH);
        revalidate();
    }

    public void emptyResult() {
        this.matrixLabel = null;
        revalidate();
    }

    public void setMessage(String message) {
        this.message.setVisible(true);
        this.message.setText(message);
        revalidate();
    }

    public void emptyMessage() {
        this.message.setVisible(false);
        revalidate();
    }

}
