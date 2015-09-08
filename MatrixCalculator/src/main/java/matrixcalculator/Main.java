package matrixcalculator;

import javax.swing.SwingUtilities;
import matrixcalculator.logic.Calculator;
import matrixcalculator.matrix.Matrix;
import matrixcalculator.ui.Interface;

public class Main {

    public static void main(String[] args) {
        
        Matrix a = new Matrix(2,2);
        Matrix b = new Matrix(2,2);
        
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
        
        Calculator calc = new Calculator();
        
        Matrix c = calc.Matrixplus(a, b);
        
        for (int[] cnumber : c.getNumbers()) {
            for (int d : cnumber) {
                System.out.println(d);
            }
        }
        
        
        Matrix dm = calc.Matrixminus(a, b);
        
        for (int[] dnumber : dm.getNumbers()) {
            for (int e : dnumber) {
                System.out.println(e);
            }
        }
        
        Matrix multi = calc.MatrixScalarMultiply(a, -2);
        
        for (int[] multinum : multi.getNumbers()) {
            for (int n : multinum) {
                System.out.println(n);
            }
        }
        
        
//        SwingUtilities.invokeLater(new Interface());
    }

}
