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
Hint: "In a world where time is money, brute force is sometimes not only not violent but also the more efficient route on the path to success!"

Let's start with SudokuSolver.java. This class already contains a basic skeleton and a runnable main method. The 2 dimensional integer array represents the sudoku to solve.
The method getArrayStyleString is only a helper that allows to print the sudoku.
Try to run it with: `mvn package exec:java`. You will notice a NPE, but we are gonna fix it soon.

SudokuSolverTest.java is a test skeleton that contains another sudoku array and it's solution.
Try to run all tests with `mvn test`.

No further errors occured so far? Perfect! Let's begin!

### Let's code 0
This strange project, that has been handed over to you throws a null pointer exception after running the main, but all tests are green? WTF has produced this garbage?!? ... With a sip of coffee we are powering up and realizing that it doesn't matter who's made this. Anyone makes misstakes, you make misstakes, I do misstakes (like a lot!), but: 
- WE WILL FIX THIS!
- WE WILL DO THIS! 
- WE WILL PRODUCE A BEATIFULL PIECE OF SOFTWARE - or at least a piece that works ;)
In your heart you already know what we must do! Write a failing test that reproduces the error and fix it afterwards.

### Let's code 1.a
Write a test that calls a method `boolean sudokuSolver.isPossible(int x, int y, int n)`.
The test should assert that it is not possible to put 'n' into position {x,y}, because it is a duplicate number within the defined row (x).
As soon as the test becomes red, "code it" green again!

### Let's code 1.b
Write a test that calls a method `boolean sudokuSolver.isPossible(int x, int y, int n)`.
The test should assert that it is possible to put 'n' into position {x,y}, because it has no duplicate numbers within the defined row (x).
As soon as the test becomes red, "code it" green again!

### Let's code 2.a
Write a test that calls a method `boolean sudokuSolver.isPossible(int x, int y, int n)`.
The test should assert that it is not possible to put 'n' into position {x,y}, because it is a duplicate number within the defined column (y).
As soon as the test becomes red, "code it" green again!

### Let's code 2.b
Write a test that calls a method `boolean sudokuSolver.isPossible(int x, int y, int n)`.
The test should assert that it is possible to put 'n' into position {x,y}, because it has no duplicate numbers within the defined column (y).
As soon as the test becomes red, "code it" green again!

### Let's code 3.a
Write a test that calls a method `boolean sudokuSolver.isPossible(int x, int y, int n)`.
The test should assert that it is not possible to put 'n' into position {x,y}, because it is a duplicate number within the block defined at x, y.
As soon as the test becomes red, "code it" green again!
Hint: There might already exists a method that does the job, since this is not an algo kata.


### Let's code 3.b
Write a test that calls a method `boolean sudokuSolver.isPossible(int x, int y, int n)`.
The test should assert that it is possible to put 'n' into position {x,y}, because it has no duplicate numbers within the block defined at x, y.

### Let's code 4.a
Write a test that solves the provided sudoku "sudokuInput". It should ensure that the solution array equals the provided "sudokuSolution".
As soon as the test becomes red, try to make it green again or see 4.b for some more hints.

### Let's code 4.b
1. A KISS developer that loves recursion, could come up with the idea to loop through all fields elements of the input array
2. This dude would check if the current element equals 0
3. In case that's true, the same mysterious being would try all numbers from 1-9.
4. If any of the numbers is possible he OR SHE could simply set the number on the current position.
5. The recursion lover cannot wait any longer, he must call the same method again, right now
6. Now it's time for a sip of coffee. That single sip made him think twice and he realizes, that "n" from step 4. might lead to a dead end. He-She-It takes another sip. He-She-It simply sets the {x,y} back to 0. He-She-It is very proud. ... Ohhhr, such a cute li'l developer.
7. The being is almost done. It want's to return something. Something can also be nothing. But where? Another must sip help! ... ! The best point to return must be within the check from 2. and right after the loop from 3.
8. With a heart pounding fast, the cute li'l hacker sees it clear. The very last thing to do is to store the solved puzzle with a deep copy.
9. It runs the tests once again, with his last energy. Finally she's either damn proud or needs to go bug hunting.

### Final words
If you still have energy you can feel free to refactore the code with this "solid" setup of tests.
You also could try to enrich the software. E.g. by reading the sudoku from a file, a url, or a command line parameter.

Thanks for playing, I hope you had fun!

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

