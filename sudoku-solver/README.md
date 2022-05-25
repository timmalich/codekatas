# Create a sudoku solver
## Sudoku
Sudoku is logic riddel on a 9x9 grid. 
The grid is dived into 9 smaller 3x3 blocks.

The rules are simple:
- Each row must contain numbers from 1 to 9
- Each column must contain numbers from 1 to 9
- Each number can only occure once per row
- Each number can only occure once per column
- Each number can only occure once per block


## Coding
Let's start with SudokuSolver.java. This class already contains a basic skeleton and a 2 dimensional array, which represents the sudoku.

### mvn commands
```shell
# either
cd sudoku-solver/solution
# or
cd sudoku-solver/kata

# Run a single test
mvn -Dtest=SudokuSolverTest#solve test

# Run all tests
mvn test

# Run solver
cd sudoku-solver/solution
mvn package exec:java
```

### code kata setup notes
```shell
kinit realuser
vpn
~/proxyOn.sh
code
```
