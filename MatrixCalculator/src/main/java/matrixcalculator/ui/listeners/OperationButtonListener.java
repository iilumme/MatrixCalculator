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
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (operationButton.getName()) {
            case "plus":
                Matrix sum = null;
                try {
                    sum = calculator.Matrixplus(calculationPanel.getMatrix("first"), calculationPanel.getMatrix("second"));
                    calculationPanel.emptyMessage();
                    calculationPanel.emptyResult();
                    calculationPanel.setResult(new MatrixLabel(sum));
                } catch (Exception ex) {
                    calculationPanel.setMessage("Something wrong with cells");
                }

                break;
            case "minus":
                Matrix difference = null;
                try {
                    difference = calculator.Matrixminus(calculationPanel.getMatrix("first"), calculationPanel.getMatrix("second"));
                    calculationPanel.emptyMessage();
                    calculationPanel.emptyResult();
                    calculationPanel.setResult(new MatrixLabel(difference));
                } catch (Exception ex) {
                    calculationPanel.setMessage("Something wrong with cells");
                }

                break;
            case "scalar":
                Matrix scalarproduct = null;
                try {
                    scalarproduct = calculator.MatrixScalarMultiply(calculationPanel.getMatrix("first"), calculationPanel.getMultiplier());
                    calculationPanel.emptyMessage();
                    calculationPanel.emptyResult();
                    calculationPanel.setResult(new MatrixLabel(scalarproduct));
                } catch (Exception ex) {
                    calculationPanel.setMessage("Something wrong with cells");
                }

                break;
            case "multiply":
                Matrix multiplyproduct = null;
                try {
                    multiplyproduct = calculator.MatrixMultiply(calculationPanel.getMatrix("first"), calculationPanel.getMatrix("second"));
                    calculationPanel.emptyMessage();
                    calculationPanel.emptyResult();
                    calculationPanel.setResult(new MatrixLabel(multiplyproduct));
                } catch (Exception ex) {
                    calculationPanel.setMessage("Something wrong with cells");
                }

                break;
            case "transpose":
                Matrix transpose = null;
                try {
                    transpose = calculator.MatrixTranspose(calculationPanel.getMatrix("first"));
                    calculationPanel.emptyMessage();
                    calculationPanel.emptyResult();
                    calculationPanel.setResult(new MatrixLabel(transpose));
                } catch (Exception ex) {
                    calculationPanel.setMessage("Something wrong with cells");
                }

                break;
            case "inverse": {
                try {
                    boolean inverse = calculator.isInverseMatrixOfX(calculationPanel.getMatrix("first"), calculationPanel.getMatrix("second"));
                    calculationPanel.emptyMessage();
                    calculationPanel.emptyResult();
                    calculationPanel.setMessage(inverse + "");
                } catch (Exception ex) {
                    calculationPanel.setMessage("Something wrong with cells");
                }
            }
            break;
            case "determinant":
                calculationPanel.emptyResult();
                break;
        }
    }

}