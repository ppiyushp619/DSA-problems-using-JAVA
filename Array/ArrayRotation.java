package Array;
/**
 * Problem Description
 * Given an integer array A of size N and an integer B, you have to return the same array after rotating it B times towards the right.
 *
 *
 * Problem Constraints
 * 1 <= N <= 105
 * 1 <= A[i] <=109
 * 1 <= B <= 109
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 *
 *
 * Output Format
 * Return the array A after rotating it B times to the right
 *
 *
 * Example Input
 * Input 1:
 *
 * A = [1, 2, 3, 4]
 * B = 2
 * Input 2:
 *
 * A = [2, 5, 6]
 * B = 1
 *
 *
 * Example Output
 * Output 1:
 *
 * [3, 4, 1, 2]
 * Output 2:
 *
 * [6, 2, 5]
 *
 * */
public class ArrayRotation {

    public int[] rotateArray(int[] A, int B) {

        int N = A.length;

        B = B%N;

        reverseArray(A, 0, N-1);
        reverseArray(A, 0, B-1);
        reverseArray(A, B, N-1);

        return A;
    }

    int[] reverseArray(int[] arr, int startIndex, int endIndex){


        int i = startIndex;
        int j = endIndex;
        while (i < j){

            arr[i] = arr[i] + arr[j];
            arr[j] = arr[i] - arr[j];
            arr[i] = arr[i] - arr[j];
            i++;
            j--;
        }
        return arr;
    }

}
