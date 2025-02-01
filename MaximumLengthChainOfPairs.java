import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthChainOfPairs { 
    public static void main(String[] args) {
        // Given pairs (a, b)
        int[][] pairs = { {5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90} };

        // Step 1: Sort pairs based on the second value (ending time) in ascending order
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));

        int chainLen = 1; // Minimum chain length starts with the first selected pair
        int lastChainEnd = pairs[0][1]; // Track the end of the last selected pair

        // Step 2: Iterate through pairs and build the longest chain
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > lastChainEnd) { 
                // If the start of the current pair is greater than the last selected end, add it to the chain
                chainLen++;
                lastChainEnd = pairs[i][1]; // Update last selected pair's end
            }
        }

        // Step 3: Print the maximum chain length
        System.out.println("Maximum length of chain = " + chainLen);
    }
}
