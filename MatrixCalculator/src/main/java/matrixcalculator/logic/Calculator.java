package matrixcalculator.logic;

import java.math.BigDecimal;
import java.math.RoundingMode;
import matrixcalculator.matrix.*;

/**
 * Calculator calculates different operations.
 */
public class Calculator {

    private final DeterminantCalculator determinantCalculator;

    public Calculator() {
        this.determinantCalculator = new DeterminantCalculator();
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

                numbers[row][column] = round(a.getNumbers()[row][column] + b.getNumbers()[row][column], getDecimals(a.getNumbers()[row][column], b.getNumbers()[row][column]));

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

                numbers[row][column] = round(a.getNumbers()[row][column] - b.getNumbers()[row][column], getDecimals(a.getNumbers()[row][column], b.getNumbers()[row][column]));

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

            numbers[row][column] = round(a.getNumbers()[row][column] * multiplier, getDecimalsForMultiplying(a.getNumbers()[row][column], multiplier));

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
                    decimals = getDecimalsForMultiplying(a.getNumbers()[aRow][aColumn], b.getNumbers()[bRow][bColumn]);
                } else {
                    decimals = Math.max(getDecimalsForMultiplying(a.getNumbers()[aRow][aColumn], b.getNumbers()[bRow][bColumn]), getDecimals(numbers[aRow][bColumn]));
                }

                numbers[aRow][bColumn] += a.getNumbers()[aRow][aColumn] * b.getNumbers()[bRow][bColumn];
                numbers[aRow][bColumn] = round(numbers[aRow][bColumn], decimals);

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
     * Tells if the given matrix is a zero matrix or not.
     *
     * @param a the matrix
     * @return true or false
     */
    public boolean isZeroMatrix(Matrix a) {

        if (a instanceof ZeroMatrix) {
            return true;
        }

        int row = 0;

        for (int column = 0; column < a.getColumns(); column++) {

            if (a.getNumbers()[row][column] != 0) {
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
     * Tells if the given matrix is a identity matrix or not.
     *
     * @param a the matrix
     * @return true or false
     */
    public boolean isIdentityMatrix(Matrix a) {

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
     * Tells if the second matrix (b) is the inverse matrix of the fist matrix
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
     * Rounds the given double.
     *
     * @param d the double
     * @param decimals the wanted amount of decimal digits
     * @return rounded double
     */
    private double round(double d, int decimals) {
        BigDecimal bigDecimal = new BigDecimal(d);
        System.out.println(bigDecimal);
        bigDecimal = bigDecimal.setScale(decimals, RoundingMode.HALF_EVEN);
        System.out.println(bigDecimal);
        return bigDecimal.doubleValue();
    }

    /**
     * Returns the number of decimals of the given double.
     *
     * @param first the given double
     * @return the number of decimals
     */
    private int getDecimals(double first) {
        String f = Double.toString(first);

        int pointF = f.indexOf('.');
        int decimalsF = f.length() - pointF - 1;

        return decimalsF;
    }

    /**
     * Returns the bigger number of decimals of the two given doubles.
     *
     * @param first the first double
     * @param second the second double
     * @return the bigger number of decimals
     */
    private int getDecimals(double first, double second) {
        String f = Double.toString(first);
        String s = Double.toString(second);

        int pointF = f.indexOf('.');
        int pointS = s.indexOf('.');

        int decimalsF = f.length() - pointF - 1;
        int decimalsS = s.length() - pointS - 1;

        return Math.max(decimalsF, decimalsS);
    }

    /**
     * Returns the sum of decimals for multiplying.
     *
     * @param first the first double
     * @param second the second double
     * @return the sum of decimals
     */
    private int getDecimalsForMultiplying(double first, double second) {
        String f = Double.toString(first);
        String s = Double.toString(second);

        int pointF = f.indexOf('.');
        int pointS = s.indexOf('.');

        int decimalsF = f.length() - pointF - 1;
        int decimalsS = s.length() - pointS - 1;

        return decimalsF + decimalsS;
    }

    private int searchTheBiggestAmountOfDecimals(Matrix a) {

        int decimals = 0;

        int row = 0;

        for (int column = 0; column < a.getColumns(); column++) {

            if (getDecimals(a.getNumbers()[row][column]) > decimals) {
                decimals = getDecimals(a.getNumbers()[row][column]);
            }

            if (column == a.getColumns() - 1) {
                row++;
                column = -1;

                if (row == a.getRows()) {
                    break;
                }
            }

        }
        return decimals;
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
        System.out.println(searchTheBiggestAmountOfDecimals(a));
        
        return round(this.determinantCalculator.calculate(a), searchTheBiggestAmountOfDecimals(a));
    }

}
