package de.tmalich.sudoku;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

public class SudokuSolver {
    private int[][] sudoku;
    private int[][] solution;

    public void solve(){
        for(int x=0; x<9; x++){
            for(int y=0; y<9; y++){
                if(sudoku[x][y] == 0){
                    for(int n=1; n<10; n++){
                        if(isPossible(x,y,n)){
                            sudoku[x][y] = n;
                        }
                    }
                    if(!isPossible(x,y,sudoku[x][y])){
                        sudoku[x][y] = 0;
                        solve();
                    }
                    // return;
                }
            }
        }
        solution = deepCopy(sudoku);
    }

    private ArrayList<Integer> findSolution(int row, int column) {
        ArrayList<Integer> possibleValues = new ArrayList<>();
        for (int value = 1; value < 10; value++) {
            if (isPossible(row, column, value)) {
                possibleValues.add(value);
            }
        }
        return possibleValues;
        //if (possibleValues.size() == 9) {
        //    return possibleValues.get(8);
        //} else if (possibleValues.size() == 8) {
        //    return possibleValues.get(7);
        //} else if (possibleValues.size() == 7) {
        //    return possibleValues.get(6);
        //} else if (possibleValues.size() == 6) {
        //    return possibleValues.get(5);
        //} else if (possibleValues.size() == 5) {
        //    return possibleValues.get(4);
        //} else if (possibleValues.size() == 4) {
        //    return possibleValues.get(3);
        //} else if (possibleValues.size() == 3) {
        //    return possibleValues.get(2);
        //} else if (possibleValues.size() == 2) {
        //    return possibleValues.get(1);
        //} else if (possibleValues.size() == 1) {
        //    return possibleValues.get(0);
        //}
        //return 0;
    }

    public void solve2() {
        List<Pair<Integer, Integer>> zeros = locateSolvable();
        solveZeros(zeros);
    }

    private List<Pair<Integer, Integer>> locateSolvable() {
        List<Pair<Integer, Integer>> solvable = new ArrayList<>();
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (solution[row][column] == 0) {
                    solvable.add(Pair.of(row, column));
                }
            }
        }
        return solvable;
    }

    private void solveZeros(List<Pair<Integer, Integer>> solvable) {
        boolean deadEnd=false;
        int deadEndRow = 0;
        int deadEndColumn = 0;
        for (Pair pair : solvable) {
            int row = (Integer) pair.getLeft();
            int column = (Integer) pair.getRight();

            ArrayList<Integer> solutions = findSolution(row, column);
            for (Integer sol : solutions) {
                solution[row][column] = sol;
                if(!isPossible(row, column, sol)){
                    solution[row][column] = 0;
                    solveZeros(solvable);
                }
             }
           // if (solutions.size() > 1 && !isPossible(row, column, solutions.get(0))) {
           //     deadEnd = true;
           //     deadEndRow = row;
           //     deadEndColumn = column;
           // }
        }
        //if(deadEnd) {
        //    solveZeros(solvable);
        //    solution[deadEndRow][deadEndColumn] = 0;
        //}
    }

    public boolean isPossible(int row, int column, int value) {
        return isPossibleInRow(row, column, value) && isPossibleInColumn(row, column, value) && isPossibleInBlock(row, column, value);
    }

    private boolean isPossibleInRow(int row, int column, int value) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == value) {
                return false;
            }
        }
        return true;
    }

    private boolean isPossibleInColumn(int row, int column, int value) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][column] == value) {
                return false;
            }
        }
        return true;
    }

    private boolean isPossibleInBlock(int row, int column, int value) { // 3.a
        int row0 = Math.floorDiv(row, 3) * 3;
        int column0 = Math.floorDiv(column, 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sudoku[row0 + i][column0 + j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    private int[][] deepCopy(int[][] src) {
        int[][] trg = new int[src.length][src.length];
        for (int x = 0; x < 9; x++) {
            trg[x] = src[x].clone();
        }
        return trg;
    }

    public void setSudoku(int[][] sudokuInput) {
        this.sudoku = sudokuInput;
        this.solution = deepCopy(sudokuInput);
    }

    public int[][] getSudoku() {
        return sudoku;
    }

    public int[][] getSolution() {
        return solution;
    }

    public String getArrayStyleString(int[][] grid) {
        StringBuilder sb = new StringBuilder("{\n");
        for (int x = 0; x < 9; x++) {
            sb.append("{");
            for (int y = 0; y < 9; y++) {
                sb.append(grid[x][y]);
                if (y < 8) {
                    sb.append(",");
                }
            }
            if (x < 8) {
                sb.append("},\n");
            } else {
                sb.append("}\n");
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    public static void main(String[] args) {
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
