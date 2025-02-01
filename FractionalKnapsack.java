import java.util.*;

public class FractionalKnapsack {
    public static void main(String[] args) {
        // Given item values and weights
        int[] value = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int w = 50; // Knapsack capacity

        // Step 1: Compute value-to-weight ratio and store in a 2D array
        double[][] ratio = new double[value.length][2]; // {index, value/weight}

        for (int i = 0; i < value.length; i++) {
            ratio[i][0] = i; // Store index of the item
            ratio[i][1] = value[i] / (double) weight[i]; // Compute value-to-weight ratio
        }

        // Step 2: Sort items based on value-to-weight ratio in descending order
        Arrays.sort(ratio, (a, b) -> Double.compare(b[1], a[1])); // Descending order

        int capacity = w; // Remaining knapsack capacity
        double finalValue = 0.0; // Total value of selected items

        // Step 3: Select items greedily
        for (int i = 0; i < ratio.length; i++) {
            int idx = (int) ratio[i][0]; // Get original index of item

            if (capacity >= weight[idx]) {
                // If the whole item fits, take it
                finalValue += value[idx];
                capacity -= weight[idx];
            } else {
                // Take a fraction of the item
                finalValue += (ratio[i][1] * capacity);
                break; // Knapsack is full
            }
        }

        // Step 4: Print final total value
        System.out.println("Maximum value in Knapsack = " + finalValue);
    }
}
