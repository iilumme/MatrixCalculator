package matrixcalculator.ui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import matrixcalculator.ui.CalculationPanel;

/**
 * ActionListener for buttons which sets new matrices to the left or right.
 */
public class LeftRightButtonListener implements ActionListener {

    private final JButton button;
    private final CalculationPanel calculationPanel;

    public LeftRightButtonListener(JButton button, CalculationPanel calculationPanel) {
        this.button = button;
        this.calculationPanel = calculationPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (this.button.getName()) {
            case "right":

                double[][] numbers = calculationPanel.getMatrixLabel().getNumbers();

                calculationPanel.getFirstMatrixPanel().getMatrixField().setRows(calculationPanel.getMatrixLabel().getRows());
                calculationPanel.getFirstMatrixPanel().getMatrixField().setColumns(calculationPanel.getMatrixLabel().getColumns());

                calculationPanel.getFirstMatrixPanel().getMatrixField().updateFields();
                calculationPanel.getFirstMatrixPanel().getMatrixField().createFields();
                calculationPanel.getFirstMatrixPanel().getMatrixField().addFields();
                calculationPanel.getFirstMatrixPanel().getMatrixField().revalidate();

                calculationPanel.getFirstMatrixPanel().getMatrixField().setNumbers(numbers);
                calculationPanel.getSecondMatrixPanel().getMatrixField().empty();

                break;
            case "left":

                double[][] numbers2 = calculationPanel.getMatrixLabel().getNumbers();

                calculationPanel.getSecondMatrixPanel().getMatrixField().setRows(calculationPanel.getMatrixLabel().getRows());
                calculationPanel.getSecondMatrixPanel().getMatrixField().setColumns(calculationPanel.getMatrixLabel().getColumns());

                calculationPanel.getSecondMatrixPanel().getMatrixField().updateFields();
                calculationPanel.getSecondMatrixPanel().getMatrixField().createFields();
                calculationPanel.getSecondMatrixPanel().getMatrixField().addFields();
                calculationPanel.getSecondMatrixPanel().getMatrixField().revalidate();

                calculationPanel.getSecondMatrixPanel().getMatrixField().setNumbers(numbers2);
                calculationPanel.getFirstMatrixPanel().getMatrixField().empty();

                break;
        }
    }

}
