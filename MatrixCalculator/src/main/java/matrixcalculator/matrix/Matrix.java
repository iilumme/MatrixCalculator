package matrixcalculator.matrix;

/**
 * 
 */
public class Matrix {
    
    private int rows;
    private int columns;
    private int[][] numbers;

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

    public int[][] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[][] numbers) {
        this.numbers = numbers;
    }
    
    

}
