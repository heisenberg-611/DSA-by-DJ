public class ArrayManipulation4 {

    // Method to rotate elements of the array to the right by k positions
    public static void rotateRight(int[] source, int k) {
        int n = source.length;
        // Ensure k is within the bounds of the array length
        k = k % n;

        // Create a temporary array to hold the rotated values
        int[] temp = new int[n];

        
        

        // Copy the temporary array back to the source array
        for (int i = 0; i < n; i++) {
            source[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        // Test the rotateRight method
        int[] source = {10, 20, 30, 40, 50, 60};
        int k = 3;

        System.out.println("Original array: ");
        printArray(source);

        rotateRight(source, k);

        System.out.println("Array after rotating right by " + k + " positions: ");
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