package de.tmalich.sudoku;

import java.util.Arrays;

public class SudokuSolver {
    private int[][] sudoku;
    private int[][] solution;

    public void solve(){ // 4.b
        return;
    }

    public boolean isPossible(int x, int y, int n){
        return false;
    }

    private boolean isPossibleInBlock(int x, int y, int n){ // 3.a
        int x0 = Math.floorDiv(x, 3)*3;
        int y0 = Math.floorDiv(y, 3)*3;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(sudoku[x0+i][y0+j] == n){
                    return false;
                }
            }
        }
        return true;
    }

    private int[][] deepCopy(int[][] src){
        int[][]trg = new int[src.length][src.length];
        for(int x=0; x<9; x++){
            trg[x] = src[x].clone();
        }
        return trg;
    }

    public void setSudoku(int[][] sudokuInput) {
        this.sudoku = sudokuInput;
    }

    public int[][] getSudoku() {
        return sudoku;
    }

    public int[][] getSolution() {
        return solution;
    }

    public String getArrayStyleString(int[][] grid){
        StringBuilder sb = new StringBuilder("{\n");
        for(int x=0; x<9; x++){
            sb.append("{");
            for(int y=0; y<9; y++){
                sb.append(grid[x][y]);
                if(y<8){
                    sb.append(",");
                }
            }
            if(x<8) {
                sb.append("},\n");
            }else{
                sb.append("}\n");
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    public static void main(String[] args){
        SudokuSolver sudokuSolver = new SudokuSolver();
        sudokuSolver.setSudoku(new int[][]{//
                        {0, 2, 4, 6, 0, 0, 0, 5, 0},//
                        {1, 7, 0, 0, 0, 5, 0, 0, 9},//
                        {3, 0, 0, 9, 0, 0, 0, 0, 1},//
                        {6, 9, 1, 0, 0, 3, 5, 8, 0},//
                        {0, 0, 8, 1, 0, 4, 9, 0, 0},//
                        {0, 3, 2, 8, 0, 0, 7, 1, 6},//
                        {5, 0, 0, 0, 0, 8, 0, 0, 7},//
                        {8, 0, 0, 7, 0, 0, 0, 6, 5},//
                        {0, 1, 0, 0, 0, 6, 4, 9, 0} //
                });
        System.out.println("Going to solve this: ");
        System.out.println(sudokuSolver.getArrayStyleString(sudokuSolver.getSudoku()));
        System.out.println("Solution is: ");
        sudokuSolver.solve();
        System.out.println(sudokuSolver.getArrayStyleString(sudokuSolver.getSolution()));
    }
}