import java.util.*;

public class ChocolaProblem {
    public static void main(String[] args) {
        // Step 1: Define the dimensions of the chocolate
        int n = 4, m = 6; // Rows (n) and Columns (m)

        // Step 2: Define cutting costs for vertical and horizontal cuts
        Integer costVer[] = {2, 1, 3, 1, 4}; // Vertical cut costs
        Integer costHor[] = {4, 1, 2};       // Horizontal cut costs

        // Step 3: Sort the costs in decreasing order (Greedy approach)
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        // Step 4: Initialize variables
        int h = 0, v = 0; // Pointers for horizontal and vertical costs
        int hp = 1, vp = 1; // Number of horizontal & vertical parts
        int cost = 0; // Stores the total minimum cost

        // Step 5: Greedy selection of cuts
        while (h < costHor.length && v < costVer.length) {
            if (costVer[v] <= costHor[h]) {
                // Choosing horizontal cut
                cost += (costHor[h] * vp);
                hp++; // Increase horizontal parts
                h++;
            } else {
                // Choosing vertical cut
                cost += (costVer[v] * hp);
                vp++; // Increase vertical parts
                v++;
            }
        }

        // Step 6: Add remaining horizontal cuts
        while (h < costHor.length) {
            cost += (costHor[h] * vp);
            h++;
        }

        // Step 7: Add remaining vertical cuts
        while (v < costVer.length) {
            cost += (costVer[v] * hp);
            v++;
        }

        // Step 8: Print the result
        System.out.println("Minimum cost of cuts = " + cost);
    }
}
