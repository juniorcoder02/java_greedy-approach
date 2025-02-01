import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class IndianCoins {
    public static void main(String[] args) {
        // Step 1: Define available Indian coin denominations
        Integer[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 2000};

        // Step 2: Sort the coins in decreasing order (Greedy approach)
        Arrays.sort(coins, Comparator.reverseOrder());

        int countOfCoins = 0; // Stores total coins used
        int amount = 1050; // Given amount to be formed
        ArrayList<Integer> ans = new ArrayList<>(); // Stores selected coins

        // Step 3: Greedy approach to minimize coins
        for (int coin : coins) {
            while (coin <= amount) { // Check if we can use the coin
                countOfCoins++; // Increment coin count
                ans.add(coin); // Add coin to the list
                amount -= coin; // Reduce amount
            }
        }

        // Step 4: Print the results
        System.out.println("Total (minimum) coins used = " + countOfCoins);
        System.out.print("Coins used: ");
        for (int a : ans) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
