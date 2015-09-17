package matrixcalculator.matrix;

/**
 * Models a zero matrix.
 * (All the numbers of Matrix are zeros.)
 */
public class ZeroMatrix extends Matrix {

    public ZeroMatrix(int rows, int columns) {
        super(rows, columns);

        super.numbers = new double[rows][columns];

        int row = 0;

        for (int column = 0; column < columns; column++) {

            super.numbers[row][column] = 0;

            if (column == columns - 1) {
                row++;
                column = -1;

                if (row == columns) {
                    break;
                }
            }

        }

    }

}
