Given a calculator
When set arguments to 2 and 5
Then adding should return 7

When set arguments to 2 and -5
Then adding should return -3

When set arguments to 2 and 6
Then subtracting should return -4

When set arguments to 13 and 3
Then subtracting should return 10

When set arguments (as double) to 13.0 and 3
Then subtracting should return 10

When set arguments to 2 and 3
Then subtracting should return -1

When set arguments to 7 and 3
Then subtracting should return 4

