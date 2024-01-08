package Array;

import java.util.Arrays;

public class EvenNuberInARange {

    public static int[] solve(int[] A, int[][] B) {

        /**

         A = [2, 1, 8, 3, 9, 6]
         B = [   [0, 3]
         [3, 5]
         [1, 3]
         [2, 4]   ]

         */

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

                if(i==0){
                    pfEven[i] = pfEven[i] + 1;
                } else {
                    pfEven[i] = pfEven[i - 1] + 1;
                }
                // Use previous value for prefix sum
            } else {
                if(i!=0) {
                    pfEven[i] = pfEven[i - 1];
                }
            }
        }

        System.out.println("pfEven: "+Arrays.toString(pfEven));

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

        System.out.println(Arrays.toString(solve(A, B)));
    }
}
