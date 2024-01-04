package Array;

/**
 * You are given an array A of integers of size N.
 * Your task is to find the equilibrium index of the given array
 * The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.
 * If there are no elements that are at lower indexes or at higher indexes, then the corresponding sum of elements is considered as 0.
 * <p>
 * Note:
 * <p>
 * Array indexing starts from 0.
 * If there is no equilibrium index then return -1.
 * If there are more than one equilibrium indexes then return the minimum index.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 105
 * -105 <= A[i] <= 105
 * <p>
 * <p>
 * Input Format
 * First arugment is an array A .
 * <p>
 * <p>
 * Output Format
 * Return the equilibrium index of the given array. If no such index is found then return -1.
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * A = [-7, 1, 5, 2, -4, 3, 0]
 * <p>
 * Input 2:
 * A = [1, 2, 3]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * 3
 * Output 2:
 * -1
 */
public class EquilibriumIndexOfAnArray {
    public static int getEquilibriumIndexes(int[] A) {

        int N = A.length;
        long[] prefixSum = new long[N];

        prefixSum[0] = A[0];
        for (int i = 1; i < N; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
        }

        int count = -1;

        for (int i = 0; i < N; i++) {

            long left = 0;
            long right = 0;

            if (i == 0) {
                left = 0;
                right = prefixSum[N - 1] - prefixSum[i];
            } else {
                right = prefixSum[i - 1];
                left = prefixSum[N - 1] - prefixSum[i];
            }

            if (left == right) {
                count = i;
                return count;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {-7, 1, 5, 2, -4, 3, 0};

        System.out.println(getEquilibriumIndexes(arr));
    }
}
