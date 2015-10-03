package matrixcalculator.logic;

import matrixcalculator.matrix.Matrix;

/**
 * Calculates the inverse matrix.
 */
public class InverseCalculator {
    
    private final Calculator calculator;

    public InverseCalculator(Calculator calculator) {
        this.calculator = calculator;
    }
    
    public Matrix calculate(Matrix a) throws Exception {
        if (a.getRows() == 2) {
            Matrix m = new Matrix(2, 2);
            double[][] numbers = new double[2][2];
            
            numbers[0][0] = a.getNumbers()[1][1];
            numbers[0][1] = -1 * a.getNumbers()[0][1];
            numbers[1][0] = -1 * a.getNumbers()[1][0];
            numbers[1][1] = a.getNumbers()[0][0];

            m.setNumbers(numbers);
            
            return this.calculator.MatrixScalarMultiply(m, 1/this.calculator.getDeterminant(a));
            
        }
       return null; 
    }
    
}
