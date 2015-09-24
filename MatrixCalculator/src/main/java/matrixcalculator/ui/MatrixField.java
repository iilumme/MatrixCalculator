package matrixcalculator.ui;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Panel in which is the matrix table where user can insert the numbers.
 */
public class MatrixField extends JPanel {

    private int rows;
    private int columns;
    private JTextField[][] fields;

    public MatrixField(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.fields = new JTextField[this.rows][this.columns];

        setLayout(new GridLayout(this.rows, this.columns));

        createFields();
        addFields();

        setBackground(Color.LIGHT_GRAY);

    }

    public void createFields() {

        setLayout(new GridLayout(this.rows, this.columns));

        int row = 0;

        for (int column = 0; column < columns; column++) {

            JTextField field = new JTextField(3);
            field.setSize(3, 3);
            this.fields[row][column] = field;

            if (column == columns - 1) {
                row++;
                column = -1;

                if (row == rows) {
                    break;
                }
            }
        }
    }

    public void addFields() {
        int row = 0;

        for (int column = 0; column < this.columns; column++) {

            add(this.fields[row][column]);

            if (column == this.columns - 1) {
                row++;
                column = -1;

                if (row == this.rows) {
                    break;
                }
            }
        }
    }

    public void updateFields() {
        removeAll();
        this.fields = new JTextField[this.rows][this.columns];
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public JTextField[][] getFields() {
        return fields;
    }

    /**
     * Sets zero matrix or identity matrix in the fields.
     *
     * @param matrix 0, if zero matrix. 1, if identity matrix.
     */
    public void setSpecificMatrix(int matrix) {
        if (matrix == 0) {
            int row = 0;

            for (int column = 0; column < this.columns; column++) {

                this.fields[row][column].setText("0");

                if (column == this.columns - 1) {
                    row++;
                    column = -1;

                    if (row == this.columns) {
                        break;
                    }
                }

            }
        } else if (matrix == 1) {

            int row = 0;

            for (int column = 0; column < this.columns; column++) {

                if (column == row) {
                    this.fields[row][column].setText("1");
                } else {
                    this.fields[row][column].setText("0");
                }

                if (column == this.columns - 1) {
                    row++;
                    column = -1;

                    if (row == this.columns) {
                        break;
                    }
                }

            }

        }

    }

    /**
     * Sets the given numbers in the JTextField components.
     * @param numbers 
     */
    public void setNumbers(double[][] numbers) {
        int row = 0;

        for (int column = 0; column < this.columns; column++) {

            this.fields[row][column].setText("" + numbers[row][column]);

            if (column == this.columns - 1) {
                row++;
                column = -1;

                if (row == this.columns) {
                    break;
                }
            }

        }
    }

    /**
     * Empties the matrix table.
     */
    public void empty() {
        int row = 0;
        for (int column = 0; column < this.columns; column++) {

            this.fields[row][column].setText("");

            if (column == this.columns - 1) {
                row++;
                column = -1;

                if (row == this.columns) {
                    break;
                }
            }

        }
    }

}
