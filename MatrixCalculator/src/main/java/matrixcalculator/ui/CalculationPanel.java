package matrixcalculator.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import matrixcalculator.matrix.Matrix;
import matrixcalculator.ui.listeners.LeftRightButtonListener;

/**
 * Panel in which are the matrices and the settings.
 */
public class CalculationPanel extends JPanel {

    private final JPanel multiplierPanel;
    private final JLabel multiplierLabel;
    private final JTextField multiplier;

    private final MatrixPanel first;
    private final MatrixPanel second;

    private MatrixLabel matrixLabel;
    private final JLabel message;

    private final JButton right;
    private final JButton left;

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

        this.right = new JButton("Set new matrix to the Right");
        this.left = new JButton("Set new matrix to the Left");

        this.right.setName("right");
        this.left.setName("left");

        this.right.addActionListener(new LeftRightButtonListener(this.right, this));
        this.left.addActionListener(new LeftRightButtonListener(this.left, this));

        add(this.multiplierPanel, BorderLayout.LINE_START);
        add(this.first, BorderLayout.WEST);
        add(this.second, BorderLayout.EAST);
        add(this.message, BorderLayout.LINE_END);
        add(this.left, BorderLayout.PAGE_END);
        add(this.right, BorderLayout.PAGE_END);

        this.right.setVisible(false);
        this.left.setVisible(false);
        setOpaque(false);
    }

    /**
     * Creates a matrix from the matrixfield.
     *
     * @param position the first or the second matrix
     * @return matrix
     * @throws Exception
     */
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

            if (!field.getFields()[row][column].getText().matches("[-+]?[0-9]*\\.?[0-9]*")) {
                throw new Exception("Something wrong with cells");
            }

            numbers[row][column] = Double.parseDouble(field.getFields()[row][column].getText());

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

    /**
     * Returns the multiplier.
     *
     * @return the multiplier.
     */
    public double getMultiplier() {
        if (multiplier.getText().matches("[-+]?[0-9]*\\.?[0-9]*")) {
            return Double.parseDouble(multiplier.getText());
        }
        multiplier.setText("1");
        return 1;
    }

    public MatrixLabel getMatrixLabel() {
        return matrixLabel;
    }

    /**
     * Sets the result matrix.
     *
     * @param matrixLabel
     */
    public void setResultMatrix(MatrixLabel matrixLabel) {
        this.matrixLabel = matrixLabel;
        add(matrixLabel, BorderLayout.LINE_END);
        revalidate();
    }

    /**
     * Removes the result matrix.
     */
    public void removeResultMatrix() {
        if (this.matrixLabel != null) {
            remove(this.matrixLabel);
            revalidate();
        }
    }

    /**
     * Sets the message.
     *
     * @param message
     */
    public void setMessage(String message) {
        this.message.setVisible(true);
        this.message.setText(message);
        revalidate();
    }

    /**
     * Removes the message.
     */
    public void removeMessage() {
        this.message.setVisible(false);
        revalidate();
    }

    public MatrixPanel getFirstMatrixPanel() {
        return first;
    }

    public MatrixPanel getSecondMatrixPanel() {
        return second;
    }
    
    public void setVisibleLeftRight() {
        this.left.setVisible(true);
        this.right.setVisible(true);
    }

}
