package matrixcalculator.logic;

import matrixcalculator.matrix.Matrix;

/**
 *
 */
public class LUDecomposition {

    private final Matrix a;
    private Matrix lowerTriangularMatrix;
    private Matrix upperTriangularMatrix;
    private final int rows;
    private final int columns;

    public LUDecomposition(Matrix a) {

        this.a = a;
        this.rows = a.getRows();
        this.columns = a.getColumns();

        this.lowerTriangularMatrix = new Matrix(rows, columns);
        this.upperTriangularMatrix = new Matrix(rows, columns);

        calculateLU();
    }

    private void calculateLU() {

        lowerTriangularMatrix.setNumbers(setLowerNumbers(rows, columns));
        upperTriangularMatrix.setNumbers(setUpperNumbers(rows, columns));

        double[][] numbers = a.getNumbers();

        //rows
        for (int i = 0; i < rows; i++) {
            //columns
            for (int j = 0; j < columns; j++) {
                double elements[] = new double[rows * 2];
                int pos = 0;
                //The position of the 'X', the number which should be discovered.
                int[][] posOfX = new int[1][2];
                //To which matrix the 'X' belongs.
                String whichMatrix = null;

                //each number in the column
                for (int k = 0; k < rows; k++) {
                    elements[pos] = lowerTriangularMatrix.getNumbers()[i][k];
                    pos++;
                    elements[pos] = upperTriangularMatrix.getNumbers()[k][j];
                    pos++;

                    if (lowerTriangularMatrix.getNumbers()[i][k] == Double.MAX_VALUE && upperTriangularMatrix.getNumbers()[k][j] != 0) {
                        posOfX[0][0] = i;
                        posOfX[0][1] = k;
                        whichMatrix = "L";
                    } else if (lowerTriangularMatrix.getNumbers()[i][k] != 0 && upperTriangularMatrix.getNumbers()[k][j] == Double.MAX_VALUE) {
                        posOfX[0][0] = i;
                        posOfX[0][1] = j;
                        whichMatrix = "U";
                    }
                }

                //The elements which are used in the calculation of 'X'.
                double[] countables = new double[2];
                //The position where the elements is to be added.
                int posit = 0;

                for (int k = 0; k < elements.length; k++) {
                    double first = elements[k];
                    double second = elements[k + 1];

                    if (first == 1 && second == Double.MAX_VALUE) {
                        countables[posit] = second;
                        posit++;
                    } else if (first == Double.MAX_VALUE && second == 1) {
                        countables[posit] = first;
                        posit++;
                    } else if (first != 0 && second == Double.MAX_VALUE) {
                        countables[posit] = first;
                        posit++;
                        countables[posit] = second;
                        posit++;
                    } else if (first == Double.MAX_VALUE && second != 0) {
                        countables[posit] = second;
                        posit++;
                        countables[posit] = first;
                        posit++;
                    } else if (first != 0 && second != 0) {
                        double result = first * second;
                        numbers[i][j] -= result;
                    }

                    k++;
                }

                if (countables[1] == 0) {
                    double importantNumber = numbers[i][j];
                    if (whichMatrix.equals("L")) {
                        lowerTriangularMatrix.getNumbers()[posOfX[0][0]][posOfX[0][1]] = importantNumber;
                    } else {
                        upperTriangularMatrix.getNumbers()[posOfX[0][0]][posOfX[0][1]] = importantNumber;
                    }
                } else {
                    double importantNumber = numbers[i][j] / countables[0];
                    if (whichMatrix.equals("L")) {
                        lowerTriangularMatrix.getNumbers()[posOfX[0][0]][posOfX[0][1]] = importantNumber;
                    } else {
                        upperTriangularMatrix.getNumbers()[posOfX[0][0]][posOfX[0][1]] = importantNumber;
                    }
                }

            }
        }
    }

    private double[][] setUpperNumbers(int rows, int columns) {
        double[][] upperNumbers = new double[rows][columns];

        //The numbers which we do not know are now maximum values of Double.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (j < i) {
                    upperNumbers[i][j] = 0;
                } else {
                    upperNumbers[i][j] = Double.MAX_VALUE;
                }
            }
        }
        return upperNumbers;
    }

    private double[][] setLowerNumbers(int rows, int columns) {
        double[][] lowerNumbers = new double[rows][columns];

        //The numbers which we do not know are now maximum values of Double.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == j) {
                    lowerNumbers[i][j] = 1;
                } else if (j > i) {
                    lowerNumbers[i][j] = 0;
                } else {
                    lowerNumbers[i][j] = Double.MAX_VALUE;
                }
            }
        }
        return lowerNumbers;
    }

    public Matrix getLowerTriangularMatrix() {
        return lowerTriangularMatrix;
    }

    public Matrix getUpperTriangularMatrix() {
        return upperTriangularMatrix;
    }

}
