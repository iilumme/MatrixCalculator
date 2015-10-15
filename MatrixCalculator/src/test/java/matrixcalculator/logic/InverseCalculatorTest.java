package matrixcalculator.logic;

import matrixcalculator.matrix.Matrix;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the InverseCalculator class.
 */
public class InverseCalculatorTest {

    private final InverseCalculator ic;
    private static final double DELTA = 1e-15;

    public InverseCalculatorTest() {
        this.ic = new InverseCalculator(new Calculator());
    }
    
    @Test
    public void Matrix1x1Works() throws Exception {
        Matrix a = new Matrix(1, 1);
        double[][] numbers = {{6}};
        a.setNumbers(numbers);

        Matrix inverse = ic.calculate(a);

        double[][] shoudBe = {{0.16666666666666666}};

        Assert.assertArrayEquals(shoudBe, inverse.getNumbers());
    }

    @Test
    public void Matrix2x2Works() throws Exception {
        Matrix a = new Matrix(2, 2);
        double[][] numbers = {{1, 2}, {2, 1}};
        a.setNumbers(numbers);

        Matrix inverse = ic.calculate(a);

        double[][] shoudBe = {{-0.3333333333333333, 0.6666666666666666}, {0.6666666666666666, -0.3333333333333333}};

        Assert.assertArrayEquals(shoudBe, inverse.getNumbers());
    }

    @Test
    public void works() throws Exception {
        Matrix a = new Matrix(3, 3);
        double[][] numbers = {{7, 2, 1}, {0, 3, -1}, {-3, 4, -2}};
        a.setNumbers(numbers);

        Matrix inverse = ic.calculate(a);

        double[][] shoudBe = {{-2.0000000000000075, 8.000000000000027, -5.000000000000019}, {3.0000000000000107, -11.000000000000037, 7.000000000000025}, {9.000000000000032, -34.000000000000114, 21.000000000000075}};

        Assert.assertArrayEquals(shoudBe, inverse.getNumbers());
    }

}
