import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MaxActivitySelection {
    public static void main(String[] args) {
        // Given start and end times of activities
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};

        // Step 1: Store activities along with their indices in a 2D array
        int n = start.length;
        int[][] activities = new int[n][3];

        for (int i = 0; i < n; i++) {
            activities[i][0] = i;    // Store original index of activity
            activities[i][1] = start[i]; // Store start time
            activities[i][2] = end[i];   // Store end time
        }

        // Step 2: Sort activities based on their end times (greedy strategy)
        Arrays.sort(activities, Comparator.comparingInt(o -> o[2]));

        // Step 3: Select activities using greedy approach
        ArrayList<Integer> selectedActivities = new ArrayList<>();

        // Select the first activity since it has the earliest end time
        int maxActivities = 1;
        selectedActivities.add(activities[0][0]); // Add index of first activity
        int lastEndTime = activities[0][2]; // Track last selected activity's end time

        // Step 4: Iterate through remaining activities and select non-overlapping ones
        for (int i = 1; i < n; i++) {
            if (activities[i][1] >= lastEndTime) { // Check if activity starts after last selected one ends
                maxActivities++; // Increase count of selected activities
                selectedActivities.add(activities[i][0]); // Add activity index to result
                lastEndTime = activities[i][2]; // Update last end time
            }
        }

        // Step 5: Print the maximum number of activities that can be selected
        System.out.println("Maximum activities that can be performed: " + maxActivities);

        // Print the selected activities
        System.out.print("Selected Activities: ");
        for (int i : selectedActivities) {
            System.out.print("A" + i + " ");
        }
        System.out.println();
    }
}
