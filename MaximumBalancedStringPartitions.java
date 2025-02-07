public class MaximumBalancedStringPartitions {

    // Function to find the maximum number of balanced partitions in a given string
    public static int maxBalancedCount(String str) {
        int count = 0; // Stores the number of balanced partitions
        int balance = 0; // Keeps track of the balance between 'L' and 'R' characters

        // Iterate over each character in the string
        for (char ch : str.toCharArray()) {
            // If the character is 'L', increase balance
            if (ch == 'L') {
                balance++;
            } 
            // If the character is 'R', decrease balance
            else {
                balance--;
            }

            // When balance becomes zero, we have found a balanced substring
            if (balance == 0) {
                count++; // Increase the count of balanced partitions
            }
        }
        
        return count; // Return the total number of balanced partitions
    }

    public static void main(String[] args) {
        // Example Test Cases
        String str = "LRRRRLLRLLRL";
        System.out.println(maxBalancedCount(str)); // Output: 3

        str = "RLRRLLRLRL";
        System.out.println(maxBalancedCount(str)); // Output: 4

        str = "LLLLRRRR";
        System.out.println(maxBalancedCount(str)); // Output: 1

        str = "RLRLRLRLRL";
        System.out.println(maxBalancedCount(str)); // Output: 5

        str = "LLRR";
        System.out.println(maxBalancedCount(str)); // Output: 1
    }
}
