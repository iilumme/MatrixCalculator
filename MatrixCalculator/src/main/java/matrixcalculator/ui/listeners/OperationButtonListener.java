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
                    Matrix sum = calculator.Matrixplus(calculationPanel.getMatrix("first"), calculationPanel.getMatrix("second"));
                    resultMatrixAndMessageSettings(sum);
                } catch (Exception ex) {
                    calculationPanel.setMessage(ex.getMessage());
                    calculationPanel.setNotVisibleLeftRight();
                }

                break;
            case "minus":
                try {
                    Matrix difference = calculator.Matrixminus(calculationPanel.getMatrix("first"), calculationPanel.getMatrix("second"));
                    resultMatrixAndMessageSettings(difference);
                } catch (Exception ex) {
                    calculationPanel.setMessage(ex.getMessage());
                    calculationPanel.setNotVisibleLeftRight();
                }

                break;
            case "scalar":
                try {
                    Matrix scalarproduct = calculator.MatrixScalarMultiply(calculationPanel.getMatrix("first"), calculationPanel.getMultiplier());
                    calculationPanel.removeMessage();
                    resultMatrixAndMessageSettings(scalarproduct);
                } catch (Exception ex) {
                    calculationPanel.setMessage(ex.getMessage());
                    calculationPanel.setNotVisibleLeftRight();
                }

                break;
            case "multiply":
                try {
                    Matrix multiplyproduct = calculator.MatrixMultiply(calculationPanel.getMatrix("first"), calculationPanel.getMatrix("second"));
                    resultMatrixAndMessageSettings(multiplyproduct);
                } catch (Exception ex) {
                    calculationPanel.setMessage(ex.getMessage());
                    calculationPanel.setNotVisibleLeftRight();
                }

                break;
            case "transpose":
                try {
                    Matrix transpose = calculator.MatrixTranspose(calculationPanel.getMatrix("first"));
                    resultMatrixAndMessageSettings(transpose);
                } catch (Exception ex) {
                    calculationPanel.setMessage(ex.getMessage());
                    calculationPanel.setNotVisibleLeftRight();
                }

                break;
            case "inverse": {
                try {
                    boolean inverse = calculator.isInverseMatrixOfX(calculationPanel.getMatrix("first"), calculationPanel.getMatrix("second"));
                    calculationPanel.removeMessage();
                    calculationPanel.removeResultMatrix();
                    calculationPanel.setMessage(inverse + "");
                    calculationPanel.setVisibleLeftRight();
                } catch (Exception ex) {
                    calculationPanel.setMessage(ex.getMessage());
                    calculationPanel.setNotVisibleLeftRight();
                }
            }
            break;
            case "determinant": {
                try {
                    double det = calculator.getDeterminant(calculationPanel.getMatrix("first"));
                    resultMatrixAndMessageSettings(det);
                } catch (Exception ex) {
                    calculationPanel.setMessage(ex.getMessage());
                    calculationPanel.setNotVisibleLeftRight();
                }
            }

            break;
            case "inversematrix":
                calculationPanel.removeResultMatrix();
                break;
        }
    }

    private void resultMatrixAndMessageSettings(Matrix matrix) {
        calculationPanel.removeMessage();
        calculationPanel.removeResultMatrix();
        calculationPanel.setResultMatrix(new MatrixLabel(matrix));
        calculationPanel.setVisibleLeftRight();
    }

    private void resultMatrixAndMessageSettings(double d) {
        calculationPanel.removeMessage();
        calculationPanel.removeResultMatrix();
        calculationPanel.setResultMatrix(new MatrixLabel(d));
        calculationPanel.setVisibleLeftRight();
    }

}
