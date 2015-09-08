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
        
        Matrix multiply = calc.MatrixMultiply(a, b);
        System.out.println("*****");
        
        for (int[] m : multiply.getNumbers()) {
            for (int n : m) {
                System.out.println(n);
            }
        }
        
        
        
        
        
        
        
        
        //ÄÄÄÄ
        
        
        Matrix o = new Matrix(2,3);
        Matrix p = new Matrix(3,2);
        
        int[][] onumbers = new int[2][3];
        onumbers[0][0] = 1;
        onumbers[0][1] = 2;
        onumbers[0][2] = 3;
        onumbers[1][0] = 8;
        onumbers[1][1] = 9;
        onumbers[1][2] = 0;
        
        o.setNumbers(onumbers);
        
        int[][] pnumbers = new int[3][2];
        pnumbers[0][0] = 4;
        pnumbers[0][1] = 5;
        pnumbers[1][0] = 6;
        pnumbers[1][1] = 7;
        pnumbers[2][0] = -1;
        pnumbers[2][1] = -2;
        
        p.setNumbers(pnumbers);
        
        
        Matrix uber = calc.MatrixMultiply(o, p);
        
        System.out.println("*****");
        
        for (int[] ube : uber.getNumbers()) {
            for (int u : ube) {
                System.out.println(u);
            }
        }
        
        
        
        
        
        //ÖÖÖÖÖ
        
        
        Matrix v = new Matrix(1,3);
        Matrix w = new Matrix(3,4);
        
        int[][] vnumbers = new int[1][3];
        vnumbers[0][0] = 3;
        vnumbers[0][1] = 4;
        vnumbers[0][2] = 2;
        
        v.setNumbers(vnumbers);
        
        int[][] wnumbers = new int[3][4];
        wnumbers[0][0] = 13;
        wnumbers[0][1] = 9;
        wnumbers[0][2] = 7;
        wnumbers[0][3] = 15;
        wnumbers[1][0] = 8;
        wnumbers[1][1] = 7;
        wnumbers[1][2] = 4;
        wnumbers[1][3] = 6;
        wnumbers[2][0] = 6;
        wnumbers[2][1] = 4;
        wnumbers[2][2] = 0;
        wnumbers[2][3] = 3;
        
        w.setNumbers(wnumbers);
        
        
        Matrix vw = calc.MatrixMultiply(v, w);
        
        System.out.println("*****");
        
        for (int[] ubwve : vw.getNumbers()) {
            for (int u : ubwve) {
                System.out.println(u);
            }
        }
        
//        SwingUtilities.invokeLater(new Interface());
    }

}
