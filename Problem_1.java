/* Problem 1: Diagonal Difference [15 Points]
Given a square matrix, calculate the absolute difference between the sums of its diagonals.
For example, the square matrix arr is shown below:

123
456
989

The left-to-right diagonal 1 + 5+ 9 = 15. The right to left diagonal 3 + 5+ 9 = 17. Their absolute
difference is |15 – 17| = 2.

You should have a function named diagonalDifference that takes the following parameter: int arr[n][m]: an array of integer

Return    int: the absolute diagonal difference


Input Format
The first line contains a single integer n, the number of rows and columns in the square matrix arr.
Each of the next lines describes a row, arr[i], and consists of n space-separated integers arr[i][j].

Constraints
Array size m x n must be less than 100 x 100

Output Format
Return the absolute difference between the sums of the matrix's two diagonals as a single integer.

Sample Input

3
11 2  4
4  5  6
10 8 -12

Sample Output
15


Explanation
The primary diagonal is:

11
     5
         -12

Sum across the primary diagonal: 11 + 5 - 12 = 4

The secondary diagonal is:

         4
     5
10

Sum across the secondary diagonal: 4 + 5 + 10 = 19

Difference: |4 - 19| = 15                                          Note: |x| is the absolute value of
 */

import java.util.Scanner;
import java.lang.Math;

public class Problem_1 {
    public static int diagonalDifference( int[][] arr) {
        // iterating and summing up the values along the primary diagonal of the square array
        int primaryDiag = 0;
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            primaryDiag += arr[i][j];
        }
        // iterating and summing up the values along the secondary diagonal of the square array
        int secondaryDiag = 0;
        for (int i = 0; i < arr.length; i++) {
            int j = arr.length - 1 - i; 
            secondaryDiag += arr[i][j];
        }

        return Math.abs(primaryDiag - secondaryDiag);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // taking the size of the Array
        System.out.print("Enter an integer n that is the number of rows and columns in the Square matrix (n < 100): ");
        int n = in.nextInt();
        while (n >= 100) {
            System.out.print("Enter a number less than 100: ");
            n = in.nextInt();
        }
        int[][] arr = new int[n][n];
        
        // taking in the values at each index of the array
        System.out.println("Now enter each element of the array row by row, seperating each value but a space: \nEx: 1 2 3\n    4 5 6\n    7 8 9");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        // performing operations and printing the result
        int result = diagonalDifference(arr);
        System.out.println("The absolute difference between the sums of the matrix's two diagonals is: " + result);


        in.close();
    }
    
}
