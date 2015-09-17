package matrixcalculator.ui;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import matrixcalculator.matrix.Matrix;

/**
 * A class to model a result matrix of any operation.
 */
public class MatrixLabel extends JPanel {

    public MatrixLabel(Matrix matrix) {
        setLayout(new GridLayout(matrix.getRows(), matrix.getColumns()));
        int row = 0;
        for (int column = 0; column < matrix.getColumns(); column++) {

            JLabel label = new JLabel("" + matrix.getNumbers()[row][column]);
            label.setBorder(BorderFactory.createMatteBorder(1, 4, 1, 1, Color.ORANGE));
            add(label);

            if (column == matrix.getColumns() - 1) {
                row++;
                column = -1;

                if (row == matrix.getRows()) {
                    break;
                }
            }
        }
    }

}
