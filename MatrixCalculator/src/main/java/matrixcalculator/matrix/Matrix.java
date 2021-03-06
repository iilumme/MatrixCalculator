package matrixcalculator.matrix;

/**
 * A class that models a matrix.
 */
public class Matrix {
    
    private int rows;
    private int columns;
    protected double[][] numbers;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.numbers = null;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public double[][] getNumbers() {
        return numbers;
    }

    public void setNumbers(double[][] numbers) {
        this.numbers = numbers;
    }
    
    

}
