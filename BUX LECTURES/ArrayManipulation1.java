public class ArrayManipulation1{

    // Method to shift elements of the array to the left by k positions
    public static void shiftLeft(int[] source, int k) {
        int length = source.length;

        // Shift elements to the left
        for (int i = 0; i < length - k; i++) {
            source[i] = source[i + k];
        }

        // Fill the last k positions with 0
        for (int i = length - k; i < length; i++) {
            source[i] = 0;
        }
    }

    public static void main(String[] args) {
        // Test the shiftLeft method
        int[] source = {10, 20, 30, 40, 50, 60};
        int k = 3;

        System.out.println("Original array: ");
        printArray(source);

        shiftLeft(source, k);

        System.out.println("Array after shifting left by " + k + " positions: ");
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