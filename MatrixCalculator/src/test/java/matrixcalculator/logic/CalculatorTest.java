package matrixcalculator.logic;

import matrixcalculator.matrix.Matrix;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the Calculator class.
 */
public class CalculatorTest {

    private final Calculator calculator;
    private static final double DELTA = 1e-15;

    public CalculatorTest() {
        this.calculator = new Calculator();
    }

    @Test
    public void plusOperationWorks() throws Exception {
        Matrix a = new Matrix(2, 2);
        Matrix b = new Matrix(2, 2);

        double[][] anumbers = new double[2][2];
        anumbers[0][0] = 3;
        anumbers[0][1] = 2;
        anumbers[1][0] = 4;
        anumbers[1][1] = 1;

        a.setNumbers(anumbers);

        double[][] bnumbers = new double[2][2];
        bnumbers[0][0] = 6;
        bnumbers[0][1] = 4;
        bnumbers[1][0] = 1;
        bnumbers[1][1] = 5;

        b.setNumbers(bnumbers);

        Matrix c = calculator.Matrixplus(a, b);

        assertEquals(9, c.getNumbers()[0][0], DELTA);
        assertEquals(6, c.getNumbers()[0][1], DELTA);
        assertEquals(5, c.getNumbers()[1][0], DELTA);
        assertEquals(6, c.getNumbers()[1][1], DELTA);
    }

    @Test
    public void plusOperationWorksDoubleCheck() throws Exception {
        Matrix a = new Matrix(2, 2);
        Matrix b = new Matrix(2, 2);

        double[][] anumbers = new double[2][2];
        anumbers[0][0] = 3.2;
        anumbers[0][1] = 2;
        anumbers[1][0] = 4.1;
        anumbers[1][1] = 1;

        a.setNumbers(anumbers);

        double[][] bnumbers = new double[2][2];
        bnumbers[0][0] = 6;
        bnumbers[0][1] = 4;
        bnumbers[1][0] = 1;
        bnumbers[1][1] = 5;

        b.setNumbers(bnumbers);

        Matrix c = calculator.Matrixplus(a, b);

        assertEquals(9.2, c.getNumbers()[0][0], DELTA);
        assertEquals(6, c.getNumbers()[0][1], DELTA);
        assertEquals(5.1, c.getNumbers()[1][0], DELTA);
        assertEquals(6, c.getNumbers()[1][1], DELTA);
    }

    @Test
    public void plusOperationDoesNotWorkWhenDifferentKindOfMatrices() {
        Matrix a = new Matrix(2, 2);
        Matrix b = new Matrix(2, 3);

        Matrix c = null;

        try {
            c = calculator.Matrixplus(a, b);
        } catch (Exception ex) {
        }

        assertNull(c);
    }

    @Test
    public void plusOperationDoesNotWorkWhenDifferentKindOfMatricesSecondTest() {
        Matrix a = new Matrix(3, 4);
        Matrix b = new Matrix(2, 3);

        Matrix c = null;
        try {
            c = calculator.Matrixplus(a, b);
        } catch (Exception ex) {
        }

        assertNull(c);
    }

    @Test
    public void minusOperationWorks() throws Exception {
        Matrix a = new Matrix(2, 2);
        Matrix b = new Matrix(2, 2);

        double[][] anumbers = new double[2][2];
        anumbers[0][0] = 8;
        anumbers[0][1] = 2;
        anumbers[1][0] = 7;
        anumbers[1][1] = 1;

        a.setNumbers(anumbers);

        double[][] bnumbers = new double[2][2];
        bnumbers[0][0] = 9;
        bnumbers[0][1] = 4;
        bnumbers[1][0] = 1;
        bnumbers[1][1] = 5;

        b.setNumbers(bnumbers);

        Matrix c = calculator.Matrixminus(a, b);

        assertEquals(-1, c.getNumbers()[0][0], DELTA);
        assertEquals(-2, c.getNumbers()[0][1], DELTA);
        assertEquals(6, c.getNumbers()[1][0], DELTA);
        assertEquals(-4, c.getNumbers()[1][1], DELTA);
    }

    @Test
    public void minusOperationWorksDoubleCheck() throws Exception {
        Matrix a = new Matrix(2, 2);
        Matrix b = new Matrix(2, 2);

        double[][] anumbers = new double[2][2];
        anumbers[0][0] = 8.4;
        anumbers[0][1] = 2;
        anumbers[1][0] = 7;
        anumbers[1][1] = 1.4;

        a.setNumbers(anumbers);

        double[][] bnumbers = new double[2][2];
        bnumbers[0][0] = 9.2;
        bnumbers[0][1] = 4;
        bnumbers[1][0] = 1.1;
        bnumbers[1][1] = 5;

        b.setNumbers(bnumbers);

        Matrix c = calculator.Matrixminus(a, b);

        assertEquals(-0.8, c.getNumbers()[0][0], DELTA);
        assertEquals(-2, c.getNumbers()[0][1], DELTA);
        assertEquals(5.9, c.getNumbers()[1][0], DELTA);
        assertEquals(-3.6, c.getNumbers()[1][1], DELTA);
    }

    @Test
    public void minusOperationDoesNotWorkWhenDifferentKindOfMatrices() {
        Matrix a = new Matrix(3, 2);
        Matrix b = new Matrix(2, 2);

        Matrix c = null;
        try {
            c = calculator.Matrixminus(a, b);
        } catch (Exception ex) {
        }

        assertNull(c);
    }

    @Test
    public void minusOperationDoesNotWorkWhenDifferentKindOfMatricesSecondTest() {
        Matrix a = new Matrix(3, 7);
        Matrix b = new Matrix(2, 5);

        Matrix c = null;
        try {
            c = calculator.Matrixminus(a, b);
        } catch (Exception ex) {
        }

        assertNull(c);
    }

    @Test
    public void scalarMultiplyingWorks() {
        Matrix a = new Matrix(2, 3);

        double[][] anumbers = new double[2][3];
        anumbers[0][0] = 8;
        anumbers[0][1] = -2;
        anumbers[0][2] = 1;
        anumbers[1][0] = -7;
        anumbers[1][1] = 3;
        anumbers[1][2] = 1;

        a.setNumbers(anumbers);

        Matrix c = calculator.MatrixScalarMultiply(a, -3);

        assertEquals(-24, c.getNumbers()[0][0], DELTA);
        assertEquals(6, c.getNumbers()[0][1], DELTA);
        assertEquals(-3, c.getNumbers()[0][2], DELTA);
        assertEquals(21, c.getNumbers()[1][0], DELTA);
        assertEquals(-9, c.getNumbers()[1][1], DELTA);
        assertEquals(-3, c.getNumbers()[1][2], DELTA);
    }

    @Test
    public void transposeWorks() {
        Matrix a = new Matrix(2, 3);

        double[][] anumbers = new double[2][3];
        anumbers[0][0] = 8;
        anumbers[0][1] = 1;
        anumbers[0][2] = 1;
        anumbers[1][0] = 6;
        anumbers[1][1] = 3;
        anumbers[1][2] = 1;

        a.setNumbers(anumbers);

        Matrix c = calculator.MatrixTranspose(a);

        assertEquals(8, c.getNumbers()[0][0], DELTA);
        assertEquals(6, c.getNumbers()[0][1], DELTA);
        assertEquals(1, c.getNumbers()[1][0], DELTA);
        assertEquals(3, c.getNumbers()[1][1], DELTA);
        assertEquals(1, c.getNumbers()[2][0], DELTA);
        assertEquals(1, c.getNumbers()[2][1], DELTA);
    }

    @Test
    public void multiplyingWorks2x2And2x3() throws Exception {
        Matrix a = new Matrix(2, 2);
        Matrix b = new Matrix(2, 3);

        double[][] anumbers = new double[2][2];
        anumbers[0][0] = -1;
        anumbers[0][1] = 3;
        anumbers[1][0] = 3;
        anumbers[1][1] = -4;

        a.setNumbers(anumbers);

        double[][] bnumbers = new double[2][3];
        bnumbers[0][0] = 1;
        bnumbers[0][1] = 0;
        bnumbers[0][2] = 5;
        bnumbers[1][0] = -3;
        bnumbers[1][1] = 1;
        bnumbers[1][2] = 0;

        b.setNumbers(bnumbers);

        Matrix c = calculator.MatrixMultiply(a, b);

        assertEquals(-10, c.getNumbers()[0][0], DELTA);
        assertEquals(3, c.getNumbers()[0][1], DELTA);
        assertEquals(-5, c.getNumbers()[0][2], DELTA);
        assertEquals(15, c.getNumbers()[1][0], DELTA);
        assertEquals(-4, c.getNumbers()[1][1], DELTA);
        assertEquals(15, c.getNumbers()[1][2], DELTA);
    }

    @Test
    public void multiplyingDoesNotWorkWhenDifferentKindOfMatrices() {
        Matrix a = new Matrix(5, 2);
        Matrix b = new Matrix(10, 8);

        Matrix c = null;
        try {
            c = calculator.MatrixMultiply(a, b);
        } catch (Exception ex) {
        }

        assertNull(c);
    }

    @Test
    public void multiplyingWorks2x3And3x3() throws Exception {
        Matrix a = new Matrix(2, 3);
        Matrix b = new Matrix(3, 3);

        double[][] anumbers = new double[2][3];
        anumbers[0][0] = 1;
        anumbers[0][1] = 1;
        anumbers[0][2] = 2;
        anumbers[1][0] = -1;
        anumbers[1][1] = 3;
        anumbers[1][2] = 4;

        a.setNumbers(anumbers);

        double[][] bnumbers = new double[3][3];
        bnumbers[0][0] = 5;
        bnumbers[0][1] = 1;
        bnumbers[0][2] = 0;
        bnumbers[1][0] = 0;
        bnumbers[1][1] = 2;
        bnumbers[1][2] = 1;
        bnumbers[2][0] = 2;
        bnumbers[2][1] = 0;
        bnumbers[2][2] = 4;

        b.setNumbers(bnumbers);

        Matrix c = calculator.MatrixMultiply(a, b);

        assertEquals(9, c.getNumbers()[0][0], DELTA);
        assertEquals(3, c.getNumbers()[0][1], DELTA);
        assertEquals(9, c.getNumbers()[0][2], DELTA);
        assertEquals(3, c.getNumbers()[1][0], DELTA);
        assertEquals(5, c.getNumbers()[1][1], DELTA);
        assertEquals(19, c.getNumbers()[1][2], DELTA);
    }

    @Test
    public void isInverseMatrixofXFalse() throws Exception {
        Matrix a = new Matrix(2, 2);
        Matrix b = new Matrix(2, 2);

        double[][] anumbers = new double[2][2];
        anumbers[0][0] = 3.2;
        anumbers[0][1] = 2;
        anumbers[1][0] = 4.1;
        anumbers[1][1] = 1;

        a.setNumbers(anumbers);

        double[][] bnumbers = new double[2][2];
        bnumbers[0][0] = 6;
        bnumbers[0][1] = 4;
        bnumbers[1][0] = 1;
        bnumbers[1][1] = 5;

        b.setNumbers(bnumbers);

        assertFalse(calculator.isInverseMatrixOfX(a, b));

    }

    @Test
    public void isInverseMatrixofXTrue() throws Exception {

        Matrix c = new Matrix(3, 3);
        Matrix d = new Matrix(3, 3);

        double[][] cnumbers = new double[3][3];
        cnumbers[0][0] = 1;
        cnumbers[0][1] = -1;
        cnumbers[0][2] = 0;
        cnumbers[1][0] = 0;
        cnumbers[1][1] = 2;
        cnumbers[1][2] = 1;
        cnumbers[2][0] = 1;
        cnumbers[2][1] = 0;
        cnumbers[2][2] = 0;

        c.setNumbers(cnumbers);

        double[][] dnumbers = new double[3][3];
        dnumbers[0][0] = 0;
        dnumbers[0][1] = 0;
        dnumbers[0][2] = 1;
        dnumbers[1][0] = -1;
        dnumbers[1][1] = 0;
        dnumbers[1][2] = 1;
        dnumbers[2][0] = 2;
        dnumbers[2][1] = 1;
        dnumbers[2][2] = -2;

        d.setNumbers(dnumbers);

        assertTrue(calculator.isInverseMatrixOfX(c, d));
    }

    @Test
    public void calculateDeterminantWorks() throws Exception {
        Matrix a = new Matrix(2, 2);

        double[][] anumbers = new double[2][2];
        anumbers[0][0] = 0;
        anumbers[0][1] = 1;
        anumbers[1][0] = 0;
        anumbers[1][1] = 1;

        a.setNumbers(anumbers);

        assertEquals(0, calculator.getDeterminant(a), DELTA);
    }

    @Test
    public void calculateDeterminantDoesNotWorks() throws Exception {
        Matrix a = new Matrix(2, 1);

        double[][] anumbers = new double[2][1];
        anumbers[0][0] = 0;
        anumbers[1][0] = 1;

        a.setNumbers(anumbers);

        boolean works = true;
        try {
            double det = calculator.getDeterminant(a);
        } catch (Exception e) {
            works = false;
        }

        assertFalse(works);

    }

    @Test
    public void getInverseWorksCorrectly() throws Exception {
        try {
            this.calculator.getInverseMatrix(new Matrix(2, 3));
        } catch (Exception ex) {
            assertTrue(true);
        }

        try {
            Matrix a = new Matrix(2, 2);
            double[][] numbers = {{1, 1}, {1, 1}};
            a.setNumbers(numbers);
            this.calculator.getInverseMatrix(a);
        } catch (Exception ex) {
            assertTrue(true);
        }

        Matrix a = new Matrix(2, 2);
        double[][] numbers = {{1, 2}, {2, 1}};
        a.setNumbers(numbers);

        Matrix inverse = this.calculator.getInverseMatrix(a);

        double[][] shoudBe = {{-0.3333333333333333, 0.6666666666666666}, {0.6666666666666666, -0.3333333333333333}};

        Assert.assertArrayEquals(shoudBe, inverse.getNumbers());

    }

}
