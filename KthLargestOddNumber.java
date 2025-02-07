public class KthLargestOddNumber {

    // Function to find the Kth largest odd number in the given range [L, R]
    public static int kthLargestNumberInRange(int L, int R, int K) {
        // Step 1: Find the largest odd number in the range
        int maxOdd = (R % 2 != 0) ? R : R - 1; // If R is odd, keep it; otherwise, take R-1

        // Step 2: Find the smallest odd number in the range
        int minOdd = (L % 2 != 0) ? L : L + 1; // If L is odd, keep it; otherwise, take L+1

        // Step 3: Check if there are any odd numbers in the range
        if (minOdd > maxOdd) {
            return 0; // No odd numbers exist in the range
        }

        // Step 4: Count the total number of odd numbers in the range
        int totalOdds = (maxOdd - minOdd) / 2 + 1;

        // Step 5: Check if K is within the range of available odd numbers
        if (K > totalOdds) {
            return 0; // If K is greater than total odds, return 0 (not possible)
        }

        // Step 6: Calculate the Kth largest odd number using the formula
        return maxOdd - (K - 1) * 2;
    }

    public static void main(String[] args) {
        // Example Test Cases
        int L = -3, R = 3, K = 1;
        System.out.println(kthLargestNumberInRange(L, R, K)); // Output: 3

        L = 1; R = 10; K = 3;
        System.out.println(kthLargestNumberInRange(L, R, K)); // Output: 5

        L = 4; R = 10; K = 2;
        System.out.println(kthLargestNumberInRange(L, R, K)); // Output: 7

        L = 8; R = 10; K = 1;
        System.out.println(kthLargestNumberInRange(L, R, K)); // Output: 9

        L = 6; R = 8; K = 1;
        System.out.println(kthLargestNumberInRange(L, R, K)); // Output: 7

        L = 2; R = 6; K = 3;
        System.out.println(kthLargestNumberInRange(L, R, K)); // Output: 3

        L = 12; R = 16; K = 1;
        System.out.println(kthLargestNumberInRange(L, R, K)); // Output: 15
    }
}
