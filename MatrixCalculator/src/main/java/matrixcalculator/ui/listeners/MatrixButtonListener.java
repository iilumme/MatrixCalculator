package matrixcalculator.ui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import matrixcalculator.ui.MatrixPanel;

public class MatrixButtonListener implements ActionListener {

    private final JButton button;
    private final MatrixPanel matrixPanel;

    public MatrixButtonListener(JButton button, MatrixPanel matrixPanel) {
        this.button = button;
        this.matrixPanel = matrixPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (this.button.getName()) {
            case "zero":
                this.matrixPanel.getMatrixField().setSpecificMatrix(0);
                break;
            case "identity":
                this.matrixPanel.getMatrixField().setSpecificMatrix(1);
                break;
            case "empty":
                this.matrixPanel.getMatrixField().empty();
                break;
        }

    }

}
