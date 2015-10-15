package matrixcalculator.logic;

import matrixcalculator.matrix.Matrix;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the DeterminantCalculator class.
 *
 * @author iina
 */
public class DeterminantCalculatorTest {

    private final DeterminantCalculator determinantCalculator;
    private static final double DELTA = 1e-15;

    public DeterminantCalculatorTest() {
        this.determinantCalculator = new DeterminantCalculator();
    }

    @Test
    public void Size1x1Matrix() {
        Matrix a = new Matrix(1, 1);

        double[][] anumbers = new double[1][1];

        anumbers[0][0] = 5;

        a.setNumbers(anumbers);

        assertEquals(5, this.determinantCalculator.calculate(a), DELTA);

    }

    @Test
    public void Size2x2Matrix() {
        Matrix a = new Matrix(2, 2);

        double[][] anumbers = new double[2][2];

        anumbers[0][0] = 4;
        anumbers[0][1] = 5;
        anumbers[1][0] = 1;
        anumbers[1][1] = 2;

        a.setNumbers(anumbers);

        assertEquals(3, this.determinantCalculator.calculate(a), DELTA);

    }

    @Test
    public void Size3x3Matrix() {
        Matrix a = new Matrix(3, 3);

        double[][] anumbers = new double[3][3];

        anumbers[0][0] = 2;
        anumbers[0][1] = 5;
        anumbers[0][2] = 1;
        anumbers[1][0] = 8;
        anumbers[1][1] = 1;
        anumbers[1][2] = 2;
        anumbers[2][0] = 3;
        anumbers[2][1] = 4;
        anumbers[2][2] = 2;

        a.setNumbers(anumbers);

        assertEquals(-33, this.determinantCalculator.calculate(a), DELTA);

    }

    @Test
    public void Size4x4Matrix() {
        Matrix a = new Matrix(4, 4);

        double[][] anumbers = new double[4][4];

        anumbers[0][0] = 2;
        anumbers[0][1] = 5;
        anumbers[0][2] = 1;
        anumbers[0][3] = 1;

        anumbers[1][0] = 8;
        anumbers[1][1] = 1;
        anumbers[1][2] = 2;
        anumbers[1][3] = 1;

        anumbers[2][0] = 3;
        anumbers[2][1] = 4;
        anumbers[2][2] = 2;
        anumbers[2][3] = 2;

        anumbers[3][0] = 1;
        anumbers[3][1] = 3;
        anumbers[3][2] = 1;
        anumbers[3][3] = 2;

        a.setNumbers(anumbers);

        assertEquals(-29, this.determinantCalculator.calculate(a), DELTA);

    }

    @Test
    public void Size5x5Matrix() {
        Matrix a = new Matrix(5, 5);

        double[][] anumbers = new double[5][5];

        anumbers[0][0] = 2;
        anumbers[0][1] = 5;
        anumbers[0][2] = 1;
        anumbers[0][3] = 1;
        anumbers[0][4] = 1;

        anumbers[1][0] = 8;
        anumbers[1][1] = 1;
        anumbers[1][2] = 2;
        anumbers[1][3] = 1;
        anumbers[1][4] = 1;

        anumbers[2][0] = 3;
        anumbers[2][1] = 4;
        anumbers[2][2] = 2;
        anumbers[2][3] = 2;
        anumbers[2][4] = 1;

        anumbers[3][0] = 1;
        anumbers[3][1] = 3;
        anumbers[3][2] = 1;
        anumbers[3][3] = 2;
        anumbers[3][4] = 1;

        anumbers[4][0] = 1;
        anumbers[4][1] = 3;
        anumbers[4][2] = 1;
        anumbers[4][3] = 2;
        anumbers[4][4] = 1;

        a.setNumbers(anumbers);

        assertEquals(0, this.determinantCalculator.calculate(a), DELTA);

    }

}
