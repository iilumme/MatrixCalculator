package matrixcalculator.ui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import matrixcalculator.ui.CalculationPanel;

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
                calculationPanel.getFirstMatrixPanel().getMatrixField().setNumbers(numbers);
                calculationPanel.getSecondMatrixPanel().getMatrixField().empty();
                break;
            case "left":
                double[][] numbers2 = calculationPanel.getMatrixLabel().getNumbers();
                calculationPanel.getSecondMatrixPanel().getMatrixField().setNumbers(numbers2);
                calculationPanel.getFirstMatrixPanel().getMatrixField().empty();
                break;
        }
    }

}
