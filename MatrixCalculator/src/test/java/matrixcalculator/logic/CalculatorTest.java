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

    private final Calculator calculator;
    private static final double DELTA = 1e-15;

    public CalculatorTest() {
        this.calculator = new Calculator();
    }

//    @BeforeClass
//    public static void setUpClass() {
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
//
//    @Before
//    public void setUp() {
//    }
//
//    @After
//    public void tearDown() {
//    }

    @Test
    public void plusOperationWorks() {
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
    public void plusOperationWorksDoubleCheck() {
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

        Matrix c = calculator.Matrixplus(a, b);

        assertNull(c);
    }

    @Test
    public void minusOperationWorks() {
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
    public void minusOperationWorksDoubleCheck() {
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

        assertEquals(-0.7999999999999989, c.getNumbers()[0][0], DELTA);
        assertEquals(-2, c.getNumbers()[0][1], DELTA);
        assertEquals(5.9, c.getNumbers()[1][0], DELTA);
        assertEquals(-3.6, c.getNumbers()[1][1], DELTA);
    }

    @Test
    public void minusOperationDoesNotWorkWhenDifferentKindOfMatrices() {
        Matrix a = new Matrix(3, 2);
        Matrix b = new Matrix(2, 2);

        Matrix c = calculator.Matrixminus(a, b);

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
    public void multiplyingWorks2x2And2x3() {
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

        Matrix c = calculator.MatrixMultiply(a, b);

        assertNull(c);
    }
    
    @Test
    public void multiplyingWorks2x3And3x3() {
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

    
    
}
