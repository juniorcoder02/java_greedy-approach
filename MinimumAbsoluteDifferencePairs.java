import java.util.Arrays;

public class MinimumAbsoluteDifferencePairs {
    public static void main(String[] args) {
        // Given two arrays
        int[] a = {4, 1, 8, 7};
        int[] b = {2, 3, 6, 5};

        // Step 1: Sort both arrays in ascending order
        Arrays.sort(a);
        Arrays.sort(b);

        int minDiff = 0; // Variable to store minimum absolute difference sum

        // Step 2: Compute the sum of absolute differences of corresponding elements
        for (int i = 0; i < a.length; i++) {
            minDiff += Math.abs(a[i] - b[i]);
        }

        // Step 3: Print the final minimum absolute difference sum
        System.out.println("Minimum absolute difference of pairs: " + minDiff);
    }
}
