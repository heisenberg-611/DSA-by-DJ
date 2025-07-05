public class ArrayManipulation2 {

    // Method to rotate elements of the array to the left by k positions
    public static void rotateLeft(int[] source, int k) {
        int n = source.length;
        // Ensure k is within the bounds of the array length
        k = k % n;

        // Create a temporary array to hold the rotated values
        int[] temp = new int[n];

        // Fill the temporary array with rotated values
        for (int i = 0; i < n; i++) {
            temp[i] = source[(i + k) % n];
        }

        // Copy the temporary array back to the source array
        for (int i = 0; i < n; i++) {
            source[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        // Test the rotateLeft method
        int[] source = {10, 20, 30, 40, 50, 60};
        int k = 3;

        System.out.println("Original array: ");
        printArray(source);

        rotateLeft(source, k);

        System.out.println("Array after rotating left by " + k + " positions: ");
        printArray(source);
    }

    // Helper method to print the array
    public static void printArray(int[] array) {
        System.out.print("[ ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" ]");
    }
}