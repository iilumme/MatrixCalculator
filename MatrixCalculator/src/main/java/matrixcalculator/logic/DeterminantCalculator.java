package matrixcalculator.logic;

import matrixcalculator.matrix.Matrix;

/**
 * Calculator for determinant.
 */
public class DeterminantCalculator {

    public double calculate(Matrix a) {

        int rows = a.getRows();
        int columns = a.getColumns();

        if (rows == 1) {
            return a.getNumbers()[0][0];
        } else if (rows == 2) {
            return a.getNumbers()[0][0] * a.getNumbers()[1][1] - a.getNumbers()[0][1] * a.getNumbers()[1][0];
        } else if (rows == 3) {
            return a.getNumbers()[0][0] * a.getNumbers()[1][1] * a.getNumbers()[2][2]
                    + a.getNumbers()[0][1] * a.getNumbers()[1][2] * a.getNumbers()[2][0]
                    + a.getNumbers()[0][2] * a.getNumbers()[1][0] * a.getNumbers()[2][1]
                    - a.getNumbers()[0][2] * a.getNumbers()[1][1] * a.getNumbers()[2][0]
                    - a.getNumbers()[0][1] * a.getNumbers()[1][0] * a.getNumbers()[2][2]
                    - a.getNumbers()[0][0] * a.getNumbers()[1][2] * a.getNumbers()[2][1];
        } else {

            LUDecomposition lud = new LUDecomposition(a);

            double result = 1;

            for (int i = 0; i < rows; i++) {
                result *= lud.getUpperTriangularMatrix().getNumbers()[i][i];
            }

            return result;
        }

    }
}
