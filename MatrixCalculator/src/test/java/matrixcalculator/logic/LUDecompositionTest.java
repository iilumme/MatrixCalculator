package matrixcalculator.logic;

import matrixcalculator.matrix.Matrix;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Tests the LUDecomposition class.
 */
public class LUDecompositionTest {

    private final LUDecomposition lud;
    private final LUDecomposition ludB;
    private static final double DELTA = 1e-15;

    public LUDecompositionTest() {
        Matrix a = new Matrix(4, 4);
        double[][] anumbers = {{2, 5, 1, 1}, {8, 1, 2, 1}, {3, 4, 2, 2}, {1, 3, 1, 2}};
        a.setNumbers(anumbers);
        this.lud = new LUDecomposition(a);
        
        
        Matrix b = new Matrix(3, 3);
        double[][] bnumbers = {{2, 4, 6}, {8, 1, 2}, {3, 4, 2}};
        b.setNumbers(bnumbers);
        this.ludB = new LUDecomposition(b);
        
    }

    @Test
    public void LIsCorrectA() {
        double[][] lowernumbers = this.lud.getLowerTriangularMatrix().getNumbers();
        assertEquals(1, lowernumbers[0][0], DELTA);
        assertEquals(0, lowernumbers[0][1], DELTA);
        assertEquals(0, lowernumbers[0][2], DELTA);
        assertEquals(0, lowernumbers[0][3], DELTA);
        
        assertEquals(4, lowernumbers[1][0], DELTA);
        assertEquals(1, lowernumbers[1][1], DELTA);
        assertEquals(0, lowernumbers[1][2], DELTA);
        assertEquals(0, lowernumbers[1][3], DELTA);
        
        assertEquals(1.5, lowernumbers[2][0], DELTA);
        assertEquals(3.5/19, lowernumbers[2][1], DELTA);
        assertEquals(1, lowernumbers[2][2], DELTA);
        assertEquals(0, lowernumbers[2][3], DELTA);
        
        assertEquals(0.5, lowernumbers[3][0], DELTA);
        assertEquals(-0.5/19, lowernumbers[3][1], DELTA);
        assertEquals(0.5151515151515151, lowernumbers[3][2], DELTA);
        assertEquals(1, lowernumbers[3][3], DELTA);
    }
    
    @Test
    public void UIsCorrectA() {
        double[][] uppernumbers = this.lud.getUpperTriangularMatrix().getNumbers();
        assertEquals(2, uppernumbers[0][0], DELTA);
        assertEquals(5, uppernumbers[0][1], DELTA);
        assertEquals(1, uppernumbers[0][2], DELTA);
        assertEquals(1, uppernumbers[0][3], DELTA);
        
        assertEquals(0, uppernumbers[1][0], DELTA);
        assertEquals(-19, uppernumbers[1][1], DELTA);
        assertEquals(-2, uppernumbers[1][2], DELTA);
        assertEquals(-3, uppernumbers[1][3], DELTA);
        
        assertEquals(0, uppernumbers[2][0], DELTA);
        assertEquals(0, uppernumbers[2][1], DELTA);
        double a = 0.868421052631579;
        assertEquals(a, uppernumbers[2][2], DELTA);
        assertEquals(1.0526315789473684, uppernumbers[2][3], DELTA);
        
        assertEquals(0, uppernumbers[3][0], DELTA);
        assertEquals(0, uppernumbers[3][1], DELTA);
        assertEquals(0, uppernumbers[3][2], DELTA);
        double c = 0.8787878787878788;
        assertEquals(c, uppernumbers[3][3], DELTA);
    }
    
    
    @Test
    public void LIsCorrectB() {
        double[][] lowernumbers = this.ludB.getLowerTriangularMatrix().getNumbers();
        assertEquals(1, lowernumbers[0][0], DELTA);
        assertEquals(0, lowernumbers[0][1], DELTA);
        assertEquals(0, lowernumbers[0][2], DELTA);
        
        assertEquals(4, lowernumbers[1][0], DELTA);
        assertEquals(1, lowernumbers[1][1], DELTA);
        assertEquals(0, lowernumbers[1][2], DELTA);
        
        assertEquals(1.5, lowernumbers[2][0], DELTA);
        assertEquals(0.13333333333333333, lowernumbers[2][1], DELTA);
        assertEquals(1, lowernumbers[2][2], DELTA);
    }
    
    @Test
    public void UIsCorrectB() {
        double[][] uppernumbers = this.ludB.getUpperTriangularMatrix().getNumbers();
        assertEquals(2, uppernumbers[0][0], DELTA);
        assertEquals(4, uppernumbers[0][1], DELTA);
        assertEquals(6, uppernumbers[0][2], DELTA);
        
        assertEquals(0, uppernumbers[1][0], DELTA);
        assertEquals(-15, uppernumbers[1][1], DELTA);
        assertEquals(-22, uppernumbers[1][2], DELTA);
        
        assertEquals(0, uppernumbers[2][0], DELTA);
        assertEquals(0, uppernumbers[2][1], DELTA);
        assertEquals(-4.066666666666666, uppernumbers[2][2], DELTA);

    }

}
