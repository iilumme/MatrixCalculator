package matrixcalculator.logic;

import matrixcalculator.matrix.IdentityMatrix;
import matrixcalculator.matrix.Matrix;

/**
 * Calculates the inverse matrix.
 */
public class InverseCalculator {

    private final Calculator calculator;

    public InverseCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public Matrix calculate(Matrix a) throws Exception {

        int rows = a.getRows();
        int columns = a.getColumns();

        if (rows == 1) {
            Matrix m = new Matrix(1, 1);
            double[][] numbers = {{1 / (a.getNumbers()[0][0])}};
            m.setNumbers(numbers);
            return m;
        } else if (rows == 2) {
            Matrix m = new Matrix(2, 2);
            double[][] numbers = new double[2][2];

            numbers[0][0] = a.getNumbers()[1][1];
            numbers[0][1] = -1 * a.getNumbers()[0][1];
            numbers[1][0] = -1 * a.getNumbers()[1][0];
            numbers[1][1] = a.getNumbers()[0][0];

            m.setNumbers(numbers);

            return this.calculator.MatrixScalarMultiply(m, 1 / this.calculator.getDeterminant(a));

        } else {
            LUDecomposition lud = new LUDecomposition(a);

            Matrix L = lud.getLowerTriangularMatrix();
            Matrix U = lud.getUpperTriangularMatrix();
            IdentityMatrix I = new IdentityMatrix(rows);
            Matrix inverse = new Matrix(rows, columns);

            double[] y = new double[rows];
            double[] x = new double[rows];
            double[][] inverseNumbers = new double[rows][columns];

            for (int i = 0; i < columns; i++) {
                double[] identityMatrixColumn = I.getColumn(i);

                for (int j = 0; j < rows; j++) {

                    double minus = 0;

                    for (int k = 0; k < columns; k++) {
                        if (j == k) {
                            continue;
                        }
                        minus += L.getNumbers()[j][k] * y[k];
                    }

                    y[j] = identityMatrixColumn[j] - minus;
                }

                for (int l = rows - 1; l >= 0; l--) {

                    double minus = 0;

                    for (int k = 0; k < columns; k++) {
                        if (l == k) {
                            continue;
                        }

                        if (U.getNumbers()[l][k] == 0) {
                            continue;
                        }

                        minus += U.getNumbers()[l][k] * x[k];
                    }
                    x[l] = (y[l] - minus) / U.getNumbers()[l][l];
                    inverseNumbers[l][i] = x[l];
                }

            }

            inverse.setNumbers(inverseNumbers);
            return inverse;
        }

    }

}
