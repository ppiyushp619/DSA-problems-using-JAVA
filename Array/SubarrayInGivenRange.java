package Array;

/**
 * Problem Description
 * Given an array A of length N, return the subarray from B to C.
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 *
 * 1 <= A[i] <= 109
 *
 * 0 <= B <= C < N
 *
 *
 *
 * Input Format
 * The first argument A is an array of integers
 *
 * The remaining argument B and C are integers.
 *
 *
 *
 * Output Format
 * Return a subarray
 *
 *
 * Example Input
 * Input 1:
 * A = [4, 3, 2, 6]
 * B = 1
 * C = 3
 * Input 2:
 *
 * A = [4, 2, 2]
 * B = 0
 * C = 1
 *
 *
 * Example Output
 * Output 1:
 * [3, 2, 6]
 * Output 2:
 *
 * [4, 2]
 * */

public class SubarrayInGivenRange {

    public int[] solve(int[] A, int B, int C) {
        int n = A.length;
        int[] subArray = new int[C - B + 1]; // length of subArray = (ending_index - starting_index + 1),so we used [C-B+1]
        int j = 0; //assigning starting index for new subArray from 0th index
        for(int i = B; i <= C; i++){ //running loop from starting point i.e B to ending point i.e C
            subArray[j] = A[i]; //storing values t0 subArray[j]
            j++; //incrementing count of subArray index
        }
        return subArray; // returning new subarrayfrom range B to C
    }
}
