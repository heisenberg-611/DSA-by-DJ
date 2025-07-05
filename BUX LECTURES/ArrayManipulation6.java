public class ArrayManipulation6 {

    // Method to remove all occurrences of a given element from the array
    public static void removeAll(int[] source, int size, int element) {
        int writeIndex = 0; // Index to write the next non-element value

        // Iterate through the array
        for (int i = 0; i < size; i++) {
            // If the current element is not the one to be removed, write it to the writeIndex
            if (source[i] != element) {
                source[writeIndex] = source[i];
                writeIndex++;
            }
        }

        // Fill the remaining positions with 0
        for (int i = writeIndex; i < size; i++) {
            source[i] = 0;
        }
    }

    public static void main(String[] args) {
        // Test the removeAll method
        int[] source = {10, 2, 30, 2, 50, 2, 2, 0, 0};
        int size = 7; // Current size of the array
        int element = 2; // Element to be removed

        System.out.println("Original array: ");
        printArray(source);

        removeAll(source, size, element);

        System.out.println("Array after removing all occurrences of " + element + ": ");
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
