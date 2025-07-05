public class ArrayManipulation8 {

    // Method to create and return the pattern array
    public static int[] createPatternArray(int n) {
        // Create an array of length n squared
        int[] array = new int[n * n];

        // Fill the array with the specified pattern
        int index = 0; // To keep track of the current index in the array
        for (int i = 0; i < n; i++) { // Outer loop for each group
            for (int j = 0; j <= i; j++) { // Inner loop to fill the group
                array[index++] = j; // Fill with increasing values
            }
            for (int j = i - 1; j >= 0; j--) { // Inner loop to fill the decreasing part
                array[index++] = j; // Fill with decreasing values
            }
        }

        return array; // Return the filled array
    }

    public static void main(String[] args) {
        // Test the createPatternArray method
        int n = 4; // Change this value to test with different n
        int[] result = createPatternArray(n);

        // Print the resulting array
        System.out.print("Pattern array for n = " + n + ": { ");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" }");
    }
}
