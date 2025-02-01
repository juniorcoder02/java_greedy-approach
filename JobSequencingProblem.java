import java.util.ArrayList;
import java.util.Collections;

public class JobSequencingProblem {
    // Job class to store job information
    static class Job {
        int deadline;
        int profit;
        int id;

        public Job(int i, int d, int p) {
            id = i; // Job ID (index in input array)
            deadline = d; // Job deadline
            profit = p; // Job profit
        }
    }

    public static void main(String[] args) {
        // Given job information: {deadline, profit}
        int[][] jobsInfo = { {4, 20}, {1, 10}, {1, 40}, {1, 30} };

        ArrayList<Job> jobs = new ArrayList<>();

        // Step 1: Convert job data into Job objects
        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        // Step 2: Sort jobs in decreasing order of profit
        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);

        ArrayList<Integer> seq = new ArrayList<>(); // Stores job sequence
        int time = 0; // Tracks available slots

        // Step 3: Greedy approach to schedule jobs
        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (curr.deadline > time) { // Check if job can be scheduled within its deadline
                seq.add(curr.id); // Add job ID to sequence
                time++; // Increment time slot
            }
        }

        // Step 4: Print the results
        System.out.println("Maximum jobs that can be completed: " + seq.size());
        System.out.print("Job sequence: ");
        for (int i = 0; i < seq.size(); i++) {
            System.out.print("Job" + seq.get(i) + " ");
        }
        System.out.println();
    }
}
