public class LexicographicallySmallestString {

    /**
     * Function to generate the lexicographically smallest string of length N
     * such that the sum of the characters (where 'a' = 1, ..., 'z' = 26) equals K.
     * 
     * Approach:
     * 1. Fill the string with 'a' initially to keep it lexicographically smallest.
     * 2. Compute the remaining sum needed after using 'a' for all positions.
     * 3. Start modifying characters from the rightmost position,
     *    increasing them to the highest possible value (without exceeding K).
     * 4. Return the final string.
     */
    public static String getSmallestString(int N, int K) {
        // Step 1: Initialize an array of characters with length N
        char[] result = new char[N];

        // Fill the array with 'a' initially, as it has the smallest lexicographic value
        for (int i = 0; i < N; i++) {
            result[i] = 'a';
        }

        // Step 2: Compute the remaining sum needed after assigning 'a' (which contributes N)
        int remainingSum = K - N;

        // Step 3: Adjust characters from the right to reach the target sum
        for (int i = N - 1; i >= 0 && remainingSum > 0; i--) {
            // Maximum value we can add to this position is 25 ('z' - 'a')
            int addValue = Math.min(remainingSum, 25);
            
            // Update the character at position i accordingly
            result[i] = (char) ('a' + addValue);
            
            // Reduce the remaining sum needed
            remainingSum -= addValue;
        }

        // Convert character array to string and return
        return new String(result);
    }

    public static void main(String[] args) {
        // Example test case
        int N = 5;
        int K = 42;
        
        // Output: aamz (Lexicographically smallest string satisfying the given conditions)
        System.out.println(getSmallestString(N, K));
    }
}
