public class ArrayManipulation9 {

    // Method to find the size of the largest bunch in the array
    public static int maxBunchCount(int[] array) {
        if (array.length == 0) {
            return 0; // Return 0 for an empty array
        }

        int maxBunchSize = 0; // To keep track of the maximum bunch size
        int currentBunchSize = 1; // To count the current bunch size

        // Iterate through the array
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
                currentBunchSize++; // Increment current bunch size
            } else {
                // Check if the current bunch size is greater than the max bunch size
                if (currentBunchSize > 1) {
                    maxBunchSize = Math.max(maxBunchSize, currentBunchSize);
                }
                currentBunchSize = 1; // Reset current bunch size
            }
        }

        // Final check for the last bunch
        if (currentBunchSize > 1) {
            maxBunchSize = Math.max(maxBunchSize, currentBunchSize);
        }

        return maxBunchSize; // Return the maximum bunch size found
    }

    public static void main(String[] args) {
        // Test cases
        int[] array1 = {1, 2, 2, 3, 4, 4, 4};
        int[] array2 = {1, 1, 2, 2, 1, 1, 1, 1};

        System.out.println("Input: [1, 2, 2, 3, 4, 4, 4] Output: " + maxBunchCount(array1)); // Output: 3
        System.out.println("Input: [1, 1, 2, 2, 1, 1, 1, 1] Output: " + maxBunchCount(array2)); // Output: 4
    }
}