package matrixcalculator.matrix;

import org.junit.Test;
import static org.junit.Assert.*;

public class MatrixTest {

    private Matrix matrix;
    private final ZeroMatrix zeroMatrix;
    private final IdentityMatrix identityMatrix;
    private static final double DELTA = 1e-15;

    public MatrixTest() {
        this.matrix = new Matrix(2, 3);
        this.zeroMatrix = new ZeroMatrix(3, 2);
        this.identityMatrix = new IdentityMatrix(3);
    }

    @Test
    public void setRowsWorks() {
        this.matrix.setRows(5);
        assertEquals(5, this.matrix.getRows());
    }

    @Test
    public void setColumsWorks() {
        this.matrix.setColumns(7);
        assertEquals(7, this.matrix.getColumns());
    }

    @Test
    public void allTheNumbersAreZerosInZeroMatrix() {

        int notZeros = 0;

        for (double[] d : this.zeroMatrix.getNumbers()) {
            for (double e : d) {
                if (e != 0) {
                    notZeros++;
                }
            }
        }

        assertTrue(notZeros == 0);
    }

    @Test
    public void identityMatrixIsCorrect() {
        int row = 0;

        for (int column = 0; column < identityMatrix.getColumns(); column++) {

            if (column == row && identityMatrix.getNumbers()[row][column] != 1) {
                assertTrue(false);
            } else if (column != row && identityMatrix.getNumbers()[row][column] != 0) {
                assertTrue(false);
            }

            if (column == identityMatrix.getColumns() - 1) {
                row++;
                column = -1;

                if (row == identityMatrix.getColumns()) {
                    break;
                }
            }
        }

        assertTrue(true);
    }

    @Test
    public void getColumnWorks() {
        double[][] numbers = {{1, 4, 8}, {3, 5, 7}, {1, 2, 7}};
        this.identityMatrix.setNumbers(numbers);

        double[] firstColumn = {1, 3, 1};
        assertArrayEquals(firstColumn, this.identityMatrix.getColumn(0), DELTA);
        double[] secondColumn = {4, 5, 2};
        assertArrayEquals(secondColumn, this.identityMatrix.getColumn(1), DELTA);
        double[] thirdColumn = {8, 7, 7};
        assertArrayEquals(thirdColumn, this.identityMatrix.getColumn(2), DELTA);
    }
}
