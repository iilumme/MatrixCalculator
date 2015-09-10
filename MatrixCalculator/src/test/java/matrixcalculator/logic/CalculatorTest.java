package matrixcalculator.logic;

import matrixcalculator.matrix.Matrix;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the Calculator class.
 */
public class CalculatorTest {

    private Calculator calculator;

    public CalculatorTest() {
        this.calculator = new Calculator();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void plusOperationWorks() {
        Matrix a = new Matrix(2, 2);
        Matrix b = new Matrix(2, 2);

        int[][] anumbers = new int[2][2];
        anumbers[0][0] = 3;
        anumbers[0][1] = 2;
        anumbers[1][0] = 4;
        anumbers[1][1] = 1;

        a.setNumbers(anumbers);

        int[][] bnumbers = new int[2][2];
        bnumbers[0][0] = 6;
        bnumbers[0][1] = 4;
        bnumbers[1][0] = 1;
        bnumbers[1][1] = 5;

        b.setNumbers(bnumbers);

        Matrix c = calculator.Matrixplus(a, b);

        assertEquals(9, c.getNumbers()[0][0]);
        assertEquals(6, c.getNumbers()[0][1]);
        assertEquals(5, c.getNumbers()[1][0]);
        assertEquals(6, c.getNumbers()[1][1]);
    }

    @Test
    public void plusOperationDoesNotWorkWhenDifferentMatrices() {
        Matrix a = new Matrix(2, 2);
        Matrix b = new Matrix(2, 3);

        Matrix c = calculator.Matrixplus(a, b);

        assertNull(c);
    }

    @Test
    public void minusOperationWorks() {
        Matrix a = new Matrix(2, 2);
        Matrix b = new Matrix(2, 2);

        int[][] anumbers = new int[2][2];
        anumbers[0][0] = 8;
        anumbers[0][1] = 2;
        anumbers[1][0] = 7;
        anumbers[1][1] = 1;

        a.setNumbers(anumbers);

        int[][] bnumbers = new int[2][2];
        bnumbers[0][0] = 9;
        bnumbers[0][1] = 4;
        bnumbers[1][0] = 1;
        bnumbers[1][1] = 5;

        b.setNumbers(bnumbers);

        Matrix c = calculator.Matrixminus(a, b);

        assertEquals(-1, c.getNumbers()[0][0]);
        assertEquals(-2, c.getNumbers()[0][1]);
        assertEquals(6, c.getNumbers()[1][0]);
        assertEquals(-4, c.getNumbers()[1][1]);
    }

    @Test
    public void minusOperationDoesNotWorkWhenDifferentMatrices() {
        Matrix a = new Matrix(3, 2);
        Matrix b = new Matrix(2, 2);

        Matrix c = calculator.Matrixminus(a, b);

        assertNull(c);
    }

    @Test
    public void scalarMultiplyingWorks() {
        Matrix a = new Matrix(2, 3);

        int[][] anumbers = new int[2][3];
        anumbers[0][0] = 8;
        anumbers[0][1] = -2;
        anumbers[0][2] = 1;
        anumbers[1][0] = -7;
        anumbers[1][1] = 3;
        anumbers[1][2] = 1;

        a.setNumbers(anumbers);

        Matrix c = calculator.MatrixScalarMultiply(a, -3);

        assertEquals(-24, c.getNumbers()[0][0]);
        assertEquals(6, c.getNumbers()[0][1]);
        assertEquals(-3, c.getNumbers()[0][2]);
        assertEquals(21, c.getNumbers()[1][0]);
        assertEquals(-9, c.getNumbers()[1][1]);
        assertEquals(-3, c.getNumbers()[1][2]);
    }
    
    @Test
    public void transposeWorks() {
        Matrix a = new Matrix(2, 3);

        int[][] anumbers = new int[2][3];
        anumbers[0][0] = 8;
        anumbers[0][1] = 1;
        anumbers[0][2] = 1;
        anumbers[1][0] = 6;
        anumbers[1][1] = 3;
        anumbers[1][2] = 1;

        a.setNumbers(anumbers);

        Matrix c = calculator.MatrixTranspose(a);

        assertEquals(8, c.getNumbers()[0][0]);
        assertEquals(6, c.getNumbers()[0][1]);
        assertEquals(1, c.getNumbers()[1][0]);
        assertEquals(3, c.getNumbers()[1][1]);
        assertEquals(1, c.getNumbers()[2][0]);
        assertEquals(1, c.getNumbers()[2][1]);
    }
}
