package LeetCode.MediumLevel;

import java.math.BigInteger;

/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.
 */


//I use combinatorics to solve this problem.
//Since all the paths must consist of a total of n+m−2 (the same as m−1+n−1) moves,
//n down and m right, our job is to select the right move from the collection of total moves.
//We calculate total moves in this way due to we are already standing on the first cell
//(so we need one less move in each direction to get to the last cell)
//Then, I use Combination without repetition, where total number to choose is total moves, and number to select is right moves.
//Also, I did not find solution like this in the web.
public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        int totalMoves = m-1+n-1;
        int rightMoves = m-1;
        return findAllCombinations(totalMoves,rightMoves);
    }

    public static int findAllCombinations(int total, int chosen){
        BigInteger totalFactorial = BigInteger.ONE;
        BigInteger chosenFactorial = BigInteger.ONE;
        BigInteger minFactorial = BigInteger.ONE; //Factorial of total minus chosen
        for (int i = 1; i <= total ; i++) {
            totalFactorial = totalFactorial.multiply(BigInteger.valueOf(i));
        }
        for (int i = 1; i <= chosen; i++) {
            chosenFactorial = chosenFactorial.multiply(BigInteger.valueOf(i));
        }
        for (int i = 1; i <= total-chosen; i++) {
            minFactorial = minFactorial.multiply(BigInteger.valueOf(i));
        }
        return (totalFactorial.divide(chosenFactorial.multiply(minFactorial))).intValue();
    }
}
