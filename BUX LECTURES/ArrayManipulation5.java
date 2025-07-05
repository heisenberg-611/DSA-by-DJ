public class ArrayManipulation5 {

    // Method to remove an element from the array at the specified index
    public static void remove(int[] source, int size, int idx) {
        // Check if the index is valid
        if (idx < 0 || idx >= size) {
            System.out.println("Index out of bounds.");
            return;
        }

        // Shift elements to the left to fill the gap
        for (int i = idx; i < size - 1; i++) {
            source[i] = source[i + 1];
        }

        // Set the last element to 0 (or any other value to indicate removal)
        source[size - 1] = 0;
    }

    public static void main(String[] args) {
        // Test the remove method
        int[] source = {10, 20, 30, 40, 50, 0, 0};
        int size = 5; // Current size of the array
        int idx = 2;  // Index of the element to be removed

        System.out.println("Original array: ");
        printArray(source);

        remove(source, size, idx);

        System.out.println("Array after removing element at index " + idx + ": ");
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