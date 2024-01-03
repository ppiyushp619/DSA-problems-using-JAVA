package Array;

import java.util.Arrays;

/**
 * Problem:
 * Given an array A of N integers. Construct prefix sum of the array in the given array itself.
 * <p>
 * Problem Constraints
 * 1 <= N <= 105
 * 1 <= A[i] <= 103
 */
public class  InPlacePrefixSum {
    public static int[] solve(int[] A) {
        int N = A.length;
        for (int i = 1; i < N; i++) {
            A[i] = A[i - 1] + A[i];
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(solve(A)));
    }
}
