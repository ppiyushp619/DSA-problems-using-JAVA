package Array;

/**
 *
 * Problem Description
 * Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the maximum value of the array
 *
 * and at least one occurrence of the minimum value of the array.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 2000
 *
 *
 *
 * Input Format
 * First and only argument is vector A
 *
 *
 *
 * Output Format
 * Return the length of the smallest subarray which has at least one occurrence of minimum and maximum element of the array
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 3, 2]
 * Input 2:
 *
 * A = [2, 6, 1, 6, 9]
 *
 *
 * Example Output
 * Output 1:
 *
 *  2
 * Output 2:
 *
 *  3
 */
public class ClosestMinMax {
    public int getSmallestSubArray(int[] A) {
        // Initialize variables to track the maximum and minimum elements in the array
        int max = A[0];
        int min = A[0];

        // Iterate through the array to find the maximum and minimum elements
        for(int i = 0; i < A.length; i++){
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }

        // Initialize variables to track the indices of the maximum and minimum elements
        int max_index = -1;
        int min_index = -1;

        // Initialize a variable to store the answer (minimum subarray length)
        int ans = A.length;

        // Iterate through the array to find the indices of the maximum and minimum elements
        for(int i = 0; i < A.length; i++){
            // Update max_index if the current element is equal to the maximum element
            max_index = (A[i] == max) ? i : max_index;

            // Update min_index if the current element is equal to the minimum element
            min_index = (A[i] == min) ? i : min_index;

            // If both max_index and min_index have been found, calculate the subarray length
            if(max_index != -1 && min_index != -1){
                ans = Math.min(ans, Math.abs(max_index - min_index) + 1);
            }
        }

        // Return the minimum subarray length
        return ans;
    }

}
