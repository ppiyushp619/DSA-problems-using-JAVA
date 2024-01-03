package Array;

import java.util.Arrays;

/**
 * Problem:
 * You are given an integer array A of length N.
 * You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
 * For each query, you have to find the sum of all elements from L to R indices in A (0 - indexed).
 * More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.
 *
 * Problem Constraints
 * 1 <= N, M <= 105
 * 1 <= A[i] <= 109
 * 0 <= L <= R < N
 *
 * input:
 * A = [1, 2, 3, 4, 5]
 * B = [[0, 3], [1, 2]]
 *
 * output:
 * [10, 5]
 */
public class RangeSumQuery {

    public static long[] rangeSum(int[] A, int[][] B) {

        int N = A.length;
        int M = B.length;
        long[] prefixSum = new long[N];
        long[] outPutArray = new long[M];

        //Construct Prefix sum
        prefixSum[0] = A[0];
        for(int i = 1; i <N; i++){
            prefixSum[i] = prefixSum[i-1] + A[i];
        }

        for(int i=0; i<M; i++){
            if(B[i][0]==0){
                outPutArray[i] =  prefixSum[B[i][1]];
            }else{
                outPutArray[i] = prefixSum[B[i][1]] - prefixSum[B[i][0]-1];
            }
        }
        return outPutArray;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[][] B = {{0, 3}, {1, 2}};

        System.out.println(Arrays.toString(rangeSum(A, B)));
    }

}
