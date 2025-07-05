public class ArrayManipulation3{

    // Method to shift elements of the array to the right by k positions
    public static void shiftRight(int[] source, int k) {
        int n = source.length;
        // Ensure k is within the bounds of the array length
        k = k % n;

        // Shift elements to the right
        for (int i = n - 1; i >= k; i--) {
            source[i] = source[i - k];
        }

        // Fill the first k positions with 0
        for (int i = 0; i < k; i++) {
            source[i] = 0;
        }
    }

    public static void main(String[] args) {
        // Test the shiftRight method
        int[] source = {10, 20, 30, 40, 50, 60};
        int k = 1;

        System.out.println("Original array: ");
        printArray(source);

        shiftRight(source, k);

        System.out.println("Array after shifting right by " + k + " positions: ");
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