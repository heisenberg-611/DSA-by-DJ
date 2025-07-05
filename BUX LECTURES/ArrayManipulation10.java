import java.util.HashMap;

public class ArrayManipulation10 {

    // Method to check if there are at least two elements with the same repetition
    public static boolean hasSameRepetition(int[] array) {
        HashMap<Integer, Integer> countMap = new HashMap<>();

        // Count occurrences of each element
        for (int num : array) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Count the repetitions
        HashMap<Integer, Integer> repetitionMap = new HashMap<>();
        for (int count : countMap.values()) {
            repetitionMap.put(count, repetitionMap.getOrDefault(count, 0) + 1);
        }

        // Check if any repetition count appears more than once
        for (int repetitionCount : repetitionMap.values()) {
            if (repetitionCount > 1) {
                return true; // Found at least two elements with the same repetition
            }
        }

        return false; // No two elements have the same repetition
    }

    public static void main(String[] args) {
        // Test cases
        int[] array1 = {4, 5, 6, 6, 4, 3, 6, 4};
        int[] array2 = {3, 4, 6, 3, 4, 7, 4, 6, 8, 6, 6};

        System.out.println("Input: {4, 5, 6, 6, 4, 3, 6, 4} Output: " + hasSameRepetition(array1)); // Output: True
        System.out.println("Input: {3, 4, 6, 3, 4, 7, 4, 6, 8, 6, 6} Output: " + hasSameRepetition(array2)); // Output: False
    }
}
