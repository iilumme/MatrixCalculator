package matrixcalculator.ui;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import matrixcalculator.logic.Calculator;
import matrixcalculator.ui.listeners.OperationButtonListener;

/**
 * Panel which contains all the operation buttons.
 */
public class ButtonsPanel extends JPanel {

    private final JButton plusOperation;
    private final JButton minusOperation;
    private final JButton scalarOperation;
    private final JButton multiplyOperation;
    private final JButton transpose;
    private final JButton inverse;
    private final JButton determinant;
    private final JButton inverseMatrix;

    private final Calculator calculator;

    public ButtonsPanel(CalculationPanel calculationPanel) {
        setLayout(new GridLayout(2, 4));

        plusOperation = new JButton("ADDITION");
        minusOperation = new JButton("SUBTRACTION");
        scalarOperation = new JButton("SCALAR MULTIPLICATION");
        multiplyOperation = new JButton("MULTIPLICATION");
        transpose = new JButton("TRANSPOSE");
        inverse = new JButton("IS IT THE INVERSE MATRIX OF 'X'?");
        determinant = new JButton("DETERMINANT (coming soon)");
        inverseMatrix = new JButton("INVERSE MATRIX (coming soon)");
        
        calculator = new Calculator();

        plusOperation.setName("plus");
        minusOperation.setName("minus");
        scalarOperation.setName("scalar");
        multiplyOperation.setName("multiply");
        transpose.setName("transpose");
        inverse.setName("inverse");
        determinant.setName("determinant");
        inverseMatrix.setName("inversematrix");

        plusOperation.addActionListener(new OperationButtonListener(plusOperation, calculationPanel));
        minusOperation.addActionListener(new OperationButtonListener(minusOperation, calculationPanel));
        scalarOperation.addActionListener(new OperationButtonListener(scalarOperation, calculationPanel));
        multiplyOperation.addActionListener(new OperationButtonListener(multiplyOperation, calculationPanel));
        transpose.addActionListener(new OperationButtonListener(transpose, calculationPanel));
        inverse.addActionListener(new OperationButtonListener(inverse, calculationPanel));
        determinant.addActionListener(new OperationButtonListener(determinant, calculationPanel));
        inverseMatrix.addActionListener(new OperationButtonListener(inverseMatrix, calculationPanel));

        add(plusOperation);
        add(minusOperation);
        add(scalarOperation);
        add(multiplyOperation);
        add(transpose);
        add(inverse);
        add(determinant);
        add(inverseMatrix);

        setOpaque(false);
    }

}
