public class ArrayManipulation7 {

    // Method to check if there exists an index i such that the left and right pans are balanced
    public static boolean canBalance(int[] A) {
        int totalSum = 0;
        for (int weight : A) {
            totalSum += weight; // Calculate the total sum of the array
        }

        int leftSum = 0; // Initialize left pan sum
        for (int i = 0; i < A.length - 1; i++) { // Iterate until the second last element
            leftSum += A[i]; // Add current weight to left pan
            // Calculate right pan sum
            int rightSum = totalSum - leftSum;
            // Check if left and right pans are balanced
            if (leftSum == rightSum) {
                return true; // Found a balance point
            }
        }

        return false; // No balance point found
    }

    public static void main(String[] args) {
        // Test cases
        int[] weights1 = {1, 1, 1, 2, 1};
        int[] weights2 = {2, 1, 1, 2, 1};
        int[] weights3 = {10, 3, 1, 2, 10};

        System.out.println("Input: [1, 1, 1, 2, 1] Output: " + canBalance(weights1)); // true
        System.out.println("Input: [2, 1, 1, 2, 1] Output: " + canBalance(weights2)); // false
        System.out.println("Input: [10, 3, 1, 2, 10] Output: " + canBalance(weights3)); // true
    }
}
