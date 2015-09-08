package matrixcalculator.logic;

import matrixcalculator.matrix.Matrix;

public class Calculator {

    public Matrix Matrixplus(Matrix a, Matrix b) {

        Matrix sum = new Matrix(a.getRows(), a.getColumns());

        int[][] numbers = new int[a.getRows()][a.getColumns()];

        int row = 0;

        for (int column = 0; column < a.getColumns(); column++) {

            numbers[row][column] = a.getNumbers()[row][column] + b.getNumbers()[row][column];

            if (column == a.getColumns() - 1) {
                row++;
                column = -1;

                if (row == a.getRows()) {
                    break;
                }
            }

        }

        sum.setNumbers(numbers);

        return sum;
    }

    public Matrix Matrixminus(Matrix a, Matrix b) {

        Matrix difference = new Matrix(a.getRows(), a.getColumns());

        int[][] numbers = new int[a.getRows()][a.getColumns()];

        int row = 0;

        for (int column = 0; column < a.getColumns(); column++) {

            numbers[row][column] = a.getNumbers()[row][column] - b.getNumbers()[row][column];

            if (column == a.getColumns() - 1) {
                row++;
                column = -1;

                if (row == a.getRows()) {
                    break;
                }
            }

        }

        difference.setNumbers(numbers);

        return difference;
    }

    public Matrix MatrixScalarMultiply(Matrix a, int multiplier) {

        Matrix multiplied = new Matrix(a.getRows(), a.getColumns());

        int[][] numbers = new int[a.getRows()][a.getColumns()];

        int row = 0;

        for (int column = 0; column < a.getColumns(); column++) {

            numbers[row][column] = a.getNumbers()[row][column] * multiplier;

            if (column == a.getColumns() - 1) {
                row++;
                column = -1;

                if (row == a.getRows()) {
                    break;
                }
            }

        }

        multiplied.setNumbers(numbers);

        return multiplied;
    }

    public Matrix MatrixMultiply(Matrix a, Matrix b) {

        Matrix multiplied = new Matrix(a.getRows(), b.getColumns());

        int[][] numbers = new int[a.getRows()][b.getColumns()];

        int aRow = 0;
        int aColumn = 0;

        int bRow = 0;
        int bColumn = 0;

        while (aRow < a.getRows() && aColumn < a.getColumns()) {

            numbers[aRow][bColumn] += a.getNumbers()[aRow][aColumn] * b.getNumbers()[bRow][bColumn];

            if (bColumn == b.getColumns() - 1 && aColumn == a.getColumns() - 1) {
                aRow++;
                aColumn = 0;

                if (bRow == b.getRows() - 1 && bColumn == b.getColumns() - 1) {
                    bRow = 0;
                } else {
                    bRow++;
                }
                bColumn = -1;

            } else if (bColumn == b.getColumns() - 1) {
                aColumn++;
                bRow++;
                bColumn = -1;
            }

            bColumn++;

        }

        multiplied.setNumbers(numbers);

        return multiplied;
    }

}
