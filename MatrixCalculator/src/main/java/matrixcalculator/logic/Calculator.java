package matrixcalculator.logic;

import matrixcalculator.matrix.*;

/**
 * Calculator calculates different operations.
 */
public class Calculator {

    private final DeterminantCalculator determinantCalculator;
    private final InverseCalculator inverseCalculator;
    private final Rounder rounder;

    public Calculator() {
        this.determinantCalculator = new DeterminantCalculator();
        this.inverseCalculator = new InverseCalculator(this);
        this.rounder = new Rounder();
    }

    /**
     * Adds two matrices.
     *
     * @param a the first matrix
     * @param b the second matrix
     * @return the result matrix of the operation
     * @throws java.lang.Exception if the number of rows and columns do not
     * match
     */
    public Matrix Matrixplus(Matrix a, Matrix b) throws Exception {

        if (a.getRows() != b.getRows() || a.getColumns() != b.getColumns()) {
            throw new Exception("The number of rows and columns do not match.");
        } else {

            Matrix sum = new Matrix(a.getRows(), a.getColumns());

            double[][] numbers = new double[a.getRows()][a.getColumns()];

            int row = 0;

            for (int column = 0; column < a.getColumns(); column++) {

                numbers[row][column] = this.rounder.round(a.getNumbers()[row][column] + b.getNumbers()[row][column], this.rounder.getDecimals(a.getNumbers()[row][column], b.getNumbers()[row][column]));

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
     *
     * @param a the first matrix
     * @param b the second matrix
     * @return the result matrix of the operation
     * @throws java.lang.Exception if the number of rows and columns do not
     * match
     */
    public Matrix Matrixminus(Matrix a, Matrix b) throws Exception {

        if (a.getRows() != b.getRows() || a.getColumns() != b.getColumns()) {
            throw new Exception("The number of rows and columns do not match.");
        } else {

            Matrix difference = new Matrix(a.getRows(), a.getColumns());

            double[][] numbers = new double[a.getRows()][a.getColumns()];

            int row = 0;

            for (int column = 0; column < a.getColumns(); column++) {

                numbers[row][column] = this.rounder.round(a.getNumbers()[row][column] - b.getNumbers()[row][column], this.rounder.getDecimals(a.getNumbers()[row][column], b.getNumbers()[row][column]));

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
     *
     * @param a the matrix
     * @param multiplier
     * @return the result matrix of the operation
     */
    public Matrix MatrixScalarMultiply(Matrix a, double multiplier) {

        Matrix multiplied = new Matrix(a.getRows(), a.getColumns());

        double[][] numbers = new double[a.getRows()][a.getColumns()];

        int row = 0;

        for (int column = 0; column < a.getColumns(); column++) {

            numbers[row][column] = this.rounder.round(a.getNumbers()[row][column] * multiplier, this.rounder.getDecimalsForMultiplying(a.getNumbers()[row][column], multiplier));

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
     *
     * @param a the multiplier matrix
     * @param b the multiplicand matrix
     * @return the result matrix of the operation
     * @throws java.lang.Exception the number of columns of the first matrix and
     * the number of rows of the second matrix should match
     */
    public Matrix MatrixMultiply(Matrix a, Matrix b) throws Exception {

        if (a.getColumns() != b.getRows()) {
            throw new Exception("The number of columns of the first matrix and the number of rows of the second matrix should match.");
        } else {

            Matrix multiplied = new Matrix(a.getRows(), b.getColumns());

            double[][] numbers = new double[a.getRows()][b.getColumns()];

            int aRow = 0;
            int aColumn = 0;

            int bRow = 0;
            int bColumn = 0;

            while (aRow < a.getRows() && aColumn < a.getColumns()) {

                int decimals;

                if (numbers[aRow][bColumn] == 0) {
                    decimals = this.rounder.getDecimalsForMultiplying(a.getNumbers()[aRow][aColumn], b.getNumbers()[bRow][bColumn]);
                } else {
                    decimals = Math.max(this.rounder.getDecimalsForMultiplying(a.getNumbers()[aRow][aColumn], b.getNumbers()[bRow][bColumn]), this.rounder.getDecimals(numbers[aRow][bColumn]));
                }

                numbers[aRow][bColumn] += a.getNumbers()[aRow][aColumn] * b.getNumbers()[bRow][bColumn];
                numbers[aRow][bColumn] = this.rounder.round(numbers[aRow][bColumn], decimals);

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
    }

    /**
     * Transpose matrix.
     *
     * @param a the matrix
     * @return the result matrix of the operation
     */
    public Matrix MatrixTranspose(Matrix a) {

        Matrix transpose = new Matrix(a.getColumns(), a.getRows());

        double[][] numbers = new double[a.getColumns()][a.getRows()];

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

    /**
     * Tells if the given matrix is a identity matrix or not.
     *
     * @param a the matrix
     * @return true or false
     */
    boolean isIdentityMatrix(Matrix a) {

        if (a instanceof IdentityMatrix) {
            return true;
        }

        int row = 0;

        for (int column = 0; column < a.getColumns(); column++) {

            if (column == row && a.getNumbers()[row][column] != 1) {
                return false;
            } else if (column != row && a.getNumbers()[row][column] != 0) {
                return false;
            }

            if (column == a.getColumns() - 1) {
                row++;
                column = -1;

                if (row == a.getColumns()) {
                    break;
                }
            }
        }
        return true;
    }

    /**
     * Tells if the second matrix (b) is the inverse matrix of the first matrix
     * (a).
     *
     * @param a the first matrix, possible invertible matrix
     * @param b the second matrix, possible inverse matrix of the first matrix
     * @return true or false
     * @throws java.lang.Exception the number of columns of the first matrix and
     * the number of rows of the second matrix should match
     */
    public boolean isInverseMatrixOfX(Matrix a, Matrix b) throws Exception {
        Matrix ab = MatrixMultiply(a, b);
        Matrix ba = MatrixMultiply(b, a);

        if (isIdentityMatrix(ab) && isIdentityMatrix(ba)) {
            return true;
        }
        return false;
    }

    /**
     * Gets the determinant of the matrix.
     *
     * @param a the matrix
     * @return the determinant
     * @throws Exception matrix should be a square matrix
     */
    public double getDeterminant(Matrix a) throws Exception {
        if (a.getRows() != a.getColumns()) {
            throw new Exception("Matrix is not a square matrix");
        }

        return this.rounder.round(this.determinantCalculator.calculate(a), this.rounder.searchTheBiggestAmountOfDecimals(a));
    }

    /**
     * Gets the inverse matrix of the matrix.
     *
     * @param a the matrix
     * @return the inverse matrix 
     * @throws Exception matrix should be a square matrix, There isn't a inverse matrix for this matrix.
     */
    public Matrix getInverseMatrix(Matrix a) throws Exception {
        if (a.getRows() != a.getColumns()) {
            throw new Exception("Matrix is not a square matrix");
        } else if (getDeterminant(a) == 0) {
            throw new Exception("There isn't a inverse matrix for this matrix.");
        }

        return this.inverseCalculator.calculate(a);
    }

}
