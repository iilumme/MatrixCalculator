package matrixcalculator.logic;

import matrixcalculator.matrix.Matrix;

/**
 * Calculator calculates different operations. At the moment, the maximum number of matrices is 2.
 */
public class Calculator {

    /**
     * Adds two matrices.
     * @param a the first matrix
     * @param b the second matrix
     * @return the result matrix of the operation
     */
    public Matrix Matrixplus(Matrix a, Matrix b) {

        if (a.getRows() != b.getRows() || a.getColumns() != b.getColumns()) {
            return null;
        } else {

            Matrix sum = new Matrix(a.getRows(), a.getColumns());

            int[][] numbers = new int[a.getRows()][a.getColumns()];

            int row = 0;

            for (int column = 0; column < a.getColumns(); column++) {

                numbers[row][column] = a.getNumbers()[row][column] + b.getNumbers()[row][column];

                if (column == a.getColumns() - 1) {
                    row++;
                    column = -1;

                    if (row == a.getRows()) {
                        break;
                    }
                }

            }

            sum.setNumbers(numbers);

            return sum;
        }
    }

    /**
     * Minus operation of two matrices.
     * @param a the first matrix
     * @param b the second matrix
     * @return the result matrix of the operation
     */
    public Matrix Matrixminus(Matrix a, Matrix b) {

        if (a.getRows() != b.getRows() || a.getColumns() != b.getColumns()) {
            return null;
        } else {

            Matrix difference = new Matrix(a.getRows(), a.getColumns());

            int[][] numbers = new int[a.getRows()][a.getColumns()];

            int row = 0;

            for (int column = 0; column < a.getColumns(); column++) {

                numbers[row][column] = a.getNumbers()[row][column] - b.getNumbers()[row][column];

                if (column == a.getColumns() - 1) {
                    row++;
                    column = -1;

                    if (row == a.getRows()) {
                        break;
                    }
                }

            }

            difference.setNumbers(numbers);

            return difference;
        }
    }

    /**
     * Scalar multiplication of matrix.
     * @param a the matrix
     * @param multiplier
     * @return the result matrix of the operation
     */
    public Matrix MatrixScalarMultiply(Matrix a, int multiplier) {

        Matrix multiplied = new Matrix(a.getRows(), a.getColumns());

        int[][] numbers = new int[a.getRows()][a.getColumns()];

        int row = 0;

        for (int column = 0; column < a.getColumns(); column++) {

            numbers[row][column] = a.getNumbers()[row][column] * multiplier;

            if (column == a.getColumns() - 1) {
                row++;
                column = -1;

                if (row == a.getRows()) {
                    break;
                }
            }

        }

        multiplied.setNumbers(numbers);

        return multiplied;
    }

    /**
     * Multiplication of two matrices.
     * @param a the multiplier matrix
     * @param b the multiplicand matrix
     * @return the result matrix of the operation
     */
    public Matrix MatrixMultiply(Matrix a, Matrix b) {

        Matrix multiplied = new Matrix(a.getRows(), b.getColumns());

        int[][] numbers = new int[a.getRows()][b.getColumns()];

        int aRow = 0;
        int aColumn = 0;

        int bRow = 0;
        int bColumn = 0;

        while (aRow < a.getRows() && aColumn < a.getColumns()) {

            numbers[aRow][bColumn] += a.getNumbers()[aRow][aColumn] * b.getNumbers()[bRow][bColumn];

            if (bColumn == b.getColumns() - 1 && aColumn == a.getColumns() - 1) {
                aRow++;
                aColumn = 0;

                if (bRow == b.getRows() - 1 && bColumn == b.getColumns() - 1) {
                    bRow = 0;
                } else {
                    bRow++;
                }
                bColumn = -1;

            } else if (bColumn == b.getColumns() - 1) {
                aColumn++;
                bRow++;
                bColumn = -1;
            }

            bColumn++;

        }

        multiplied.setNumbers(numbers);

        return multiplied;
    }

    /**
     * Transpose matrix.
     * @param a the matrix
     * @return the result matrix of the operation
     */
    public Matrix MatrixTranspose(Matrix a) {

        Matrix transpose = new Matrix(a.getColumns(), a.getRows());

        int[][] numbers = new int[a.getColumns()][a.getRows()];

        int row = 0;

        for (int column = 0; column < a.getColumns(); column++) {

            numbers[column][row] = a.getNumbers()[row][column];

            if (column == a.getColumns() - 1) {
                row++;
                column = -1;

                if (row == a.getRows()) {
                    break;
                }
            }

        }

        transpose.setNumbers(numbers);

        return transpose;
    }

}
