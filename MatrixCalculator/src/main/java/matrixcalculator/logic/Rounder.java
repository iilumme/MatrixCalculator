package matrixcalculator.logic;

import java.math.BigDecimal;
import java.math.RoundingMode;
import matrixcalculator.matrix.Matrix;

/**
 * Class for rounding doubles.
 * @author iina
 */
public class Rounder {

    /**
     * Rounds the given double.
     *
     * @param d the double
     * @param decimals the wanted amount of decimal digits
     * @return rounded double
     */
    public double round(double d, int decimals) {
        BigDecimal bigDecimal = new BigDecimal(d);
        bigDecimal = bigDecimal.setScale(decimals, RoundingMode.HALF_EVEN);
        return bigDecimal.doubleValue();
    }

    /**
     * Returns the number of decimals of the given double.
     *
     * @param first the given double
     * @return the number of decimals
     */
    public int getDecimals(double first) {
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
    public int getDecimals(double first, double second) {
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
    public int getDecimalsForMultiplying(double first, double second) {
        String f = Double.toString(first);
        String s = Double.toString(second);

        int pointF = f.indexOf('.');
        int pointS = s.indexOf('.');

        int decimalsF = f.length() - pointF - 1;
        int decimalsS = s.length() - pointS - 1;

        return decimalsF + decimalsS;
    }

    /**
     * Searches the biggest amount of decimals in the matrix.
     *
     * @param a the matrix
     * @return decimals
     */
    public int searchTheBiggestAmountOfDecimals(Matrix a) {

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

}
