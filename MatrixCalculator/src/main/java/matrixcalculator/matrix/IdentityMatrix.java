package matrixcalculator.matrix;

/**
 * Models a identity matrix. (The numbers on the main diagonal are 1, and the
 * others 0.)
 */
public class IdentityMatrix extends Matrix {

    public IdentityMatrix(int n) {
        super(n, n);

        super.numbers = new double[n][n];

        int row = 0;

        for (int column = 0; column < n; column++) {

            if (column == row) {
                super.numbers[row][column] = 1;
            } else {
                super.numbers[row][column] = 0;
            }

            if (column == n - 1) {
                row++;
                column = -1;

                if (row == n) {
                    break;
                }
            }

        }
    }

    public double[] getRow(int position) {
        double[] row = new double[super.getRows()];

        for (int i = 0; i < super.getRows(); i++) {
            row[i] = super.getNumbers()[i][position];
        }

        return row;
    }

}
