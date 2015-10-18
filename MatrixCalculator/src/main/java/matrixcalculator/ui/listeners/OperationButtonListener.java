package matrixcalculator.ui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import matrixcalculator.logic.Calculator;
import matrixcalculator.matrix.Matrix;
import matrixcalculator.ui.CalculationPanel;
import matrixcalculator.ui.MatrixLabel;

/**
 * ActionListener for all the calculation operation buttons.
 */
public class OperationButtonListener implements ActionListener {

    private final JButton operationButton;
    private final CalculationPanel calculationPanel;
    private final Calculator calculator;

    public OperationButtonListener(JButton oButton, CalculationPanel calculationPanel) {
        this.operationButton = oButton;
        this.calculationPanel = calculationPanel;
        this.calculator = new Calculator();
    }

    /**
     * Calculates the wanted operations and gives the result.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (operationButton.getName()) {
            case "plus":
                try {
                    long start_time = System.nanoTime();
                    Matrix sum = calculator.Matrixplus(calculationPanel.getMatrix("first"), calculationPanel.getMatrix("second"));
                    long end_time = System.nanoTime();
                    double time = (end_time - start_time) / 1000000000.0;
                    resultMatrixAndMessageSettings(sum, time);
                } catch (Exception ex) {
                    calculationPanel.setMessage(ex.getMessage());
                    calculationPanel.setNotVisibleLeftRight();
                }

                break;
            case "minus":
                try {
                    long start_time = System.nanoTime();
                    Matrix difference = calculator.Matrixminus(calculationPanel.getMatrix("first"), calculationPanel.getMatrix("second"));
                    long end_time = System.nanoTime();
                    double time = (end_time - start_time) / 1000000000.0;
                    resultMatrixAndMessageSettings(difference, time);
                } catch (Exception ex) {
                    calculationPanel.setMessage(ex.getMessage());
                    calculationPanel.setNotVisibleLeftRight();
                }

                break;
            case "scalar":
                try {
                    long start_time = System.nanoTime();
                    Matrix scalarproduct = calculator.MatrixScalarMultiply(calculationPanel.getMatrix("first"), calculationPanel.getMultiplier());
                    long end_time = System.nanoTime();
                    double time = (end_time - start_time) / 1000000000.0;
                    calculationPanel.removeMessage();
                    resultMatrixAndMessageSettings(scalarproduct, time);
                } catch (Exception ex) {
                    calculationPanel.setMessage(ex.getMessage());
                    calculationPanel.setNotVisibleLeftRight();
                }

                break;
            case "multiply":
                try {
                    long start_time = System.nanoTime();
                    Matrix multiplyproduct = calculator.MatrixMultiply(calculationPanel.getMatrix("first"), calculationPanel.getMatrix("second"));
                    long end_time = System.nanoTime();
                    double time = (end_time - start_time) / 1000000000.0;
                    resultMatrixAndMessageSettings(multiplyproduct, time);
                } catch (Exception ex) {
                    calculationPanel.setMessage(ex.getMessage());
                    calculationPanel.setNotVisibleLeftRight();
                }

                break;
            case "transpose":
                try {
                    long start_time = System.nanoTime();
                    Matrix transpose = calculator.MatrixTranspose(calculationPanel.getMatrix("first"));
                    long end_time = System.nanoTime();
                    double time = (end_time - start_time) / 1000000000.0;
                    resultMatrixAndMessageSettings(transpose, time);
                } catch (Exception ex) {
                    calculationPanel.setMessage(ex.getMessage());
                    calculationPanel.setNotVisibleLeftRight();
                }

                break;
            case "inverse": {
                try {
                    long start_time = System.nanoTime();
                    boolean inverse = calculator.isInverseMatrixOfX(calculationPanel.getMatrix("first"), calculationPanel.getMatrix("second"));
                    long end_time = System.nanoTime();
                    double time = (end_time - start_time) / 1000000000.0;
                    calculationPanel.removeMessage();
                    calculationPanel.removeResultMatrix();
                    calculationPanel.setMessage(inverse + "");
                    calculationPanel.setVisibleLeftRight();
                    calculationPanel.setTime(time);
                } catch (Exception ex) {
                    calculationPanel.setMessage(ex.getMessage());
                    calculationPanel.setNotVisibleLeftRight();
                }
            }
            break;
            case "determinant": {
                try {
                    long start_time = System.nanoTime();
                    double det = calculator.getDeterminant(calculationPanel.getMatrix("first"));
                    long end_time = System.nanoTime();
                    double time = (end_time - start_time) / 1000000000.0;
                    resultMatrixAndMessageSettings(det, time);
                } catch (Exception ex) {
                    calculationPanel.setMessage(ex.getMessage());
                    calculationPanel.setNotVisibleLeftRight();
                }
            }

            break;
            case "inversematrix":
                try {
                    long start_time = System.nanoTime();
                    Matrix inverse = calculator.getInverseMatrix(calculationPanel.getMatrix("first"));
                    long end_time = System.nanoTime();
                    double time = (end_time - start_time) / 1000000000.0;
                    resultMatrixAndMessageSettings(inverse, time);
                } catch (Exception ex) {
                    calculationPanel.setMessage(ex.getMessage());
                    calculationPanel.setNotVisibleLeftRight();
                }
                break;
        }
    }

    private void resultMatrixAndMessageSettings(Matrix matrix, double time) {
        calculationPanel.removeMessage();
        calculationPanel.removeResultMatrix();
        calculationPanel.setResultMatrix(new MatrixLabel(matrix));
        calculationPanel.setVisibleLeftRight();
        calculationPanel.setTime(time);
    }

    private void resultMatrixAndMessageSettings(double d, double time) {
        calculationPanel.removeMessage();
        calculationPanel.removeResultMatrix();
        calculationPanel.setResultMatrix(new MatrixLabel(d));
        calculationPanel.setVisibleLeftRight();
        calculationPanel.setTime(time);
    }

}
