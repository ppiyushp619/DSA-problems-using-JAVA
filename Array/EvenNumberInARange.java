package Array;

import java.util.Arrays;

/**
 * Problem Description
 * You are given an array A of length N and Q queries given by the 2D array B of size Q×2.
 * Each query consists of two integers B[i][0] and B[i][1].
 * For every query, your task is to find the count of even numbers in the range from A[B[i][0]] to A[B[i][1]].
 *
 * Problem Constraints
 * 1 <= N <= 105
 * 1 <= Q <= 105
 * 1 <= A[i] <= 109
 * 0 <= B[i][0] <= B[i][1] < N
 *
 *
 * Input Format
 * First argument A is an array of integers.
 * Second argument B is a 2D array of integers.
 *
 *
 * Output Format
 * Return an array of integers.
 *
 *
 * Example Input
 * Input 1:
 * A = [1, 2, 3, 4, 5]
 * B = [   [0, 2]
 *         [2, 4]
 *         [1, 4]   ]
 * Input 2:
 * A = [2, 1, 8, 3, 9, 6]
 * B = [   [0, 3]
 *         [3, 5]
 *         [1, 3]
 *         [2, 4]   ]
 *
 *
 * Example Output
 * Output 1:
 * [1, 1, 2]
 * Output 2:
 * [2, 1, 1, 1]
 * */

public class EvenNumberInARange {

    public static int[] getCountOfEvenNumbers(int[] A, int[][] B) {

        int N = A.length; //6
        int Q = B.length; //3

        // Declare arrays with sizes
        int[] noOfEven = new int[Q];
        int[] pfEven = new int[N];

        // Initialize pfEven[0] for accumulation
        pfEven[0] = 0;

        // Count even numbers in A and create a prefix sum array
        for (int i = 0; i < N; i++) {
            if (A[i] % 2 == 0) {
                // Accumulate even counts for prefix sum

                if (i == 0) {
                    pfEven[i] = pfEven[i] + 1;
                } else {
                    pfEven[i] = pfEven[i - 1] + 1;
                }
                // Use previous value for prefix sum
            } else {
                if (i != 0) {
                    pfEven[i] = pfEven[i - 1];
                }
            }
        }

        // Process queries using the prefix sum array
        for (int j = 0; j < Q; j++) {
            if (B[j][0] == 0) {
                noOfEven[j] = pfEven[B[j][1]];
            } else {
                noOfEven[j] = pfEven[B[j][1]] - pfEven[B[j][0] - 1];
            }
        }

        return noOfEven;
    }

    public static void main(String[] args) {
        int [] A = {2, 1, 8, 3, 9, 6};
        int[][] B = {{0, 3},{3, 5},{1, 3},{2, 4}};


        System.out.println(Arrays.toString(getCountOfEvenNumbers(A, B)));
    }
}
