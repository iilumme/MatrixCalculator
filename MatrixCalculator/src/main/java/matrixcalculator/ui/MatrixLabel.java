package matrixcalculator.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import matrixcalculator.matrix.Matrix;

/**
 * A class to model a result matrix of any operation.
 */
public class MatrixLabel extends JPanel {
    
    private double[][] numbers;

    public MatrixLabel(Matrix matrix) {
        
        this.numbers = new double[matrix.getRows()][matrix.getColumns()];
        
        setLayout(new GridLayout(matrix.getRows(), matrix.getColumns()));
        int row = 0;
        for (int column = 0; column < matrix.getColumns(); column++) {

            numbers[row][column] = matrix.getNumbers()[row][column];
            
            JLabel label = new JLabel("" + matrix.getNumbers()[row][column]);
            label.setFont(new Font("Courier New", Font.BOLD, 18));
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

    public double[][] getNumbers() {
        return numbers;
    }
    
    

}
