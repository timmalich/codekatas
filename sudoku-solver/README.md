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
