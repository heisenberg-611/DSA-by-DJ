import java.util.*;

class Arr {
    // Print function to display Integer arrays
    public static void print(Integer[] arr) {
        System.out.print("[ ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("]");
    }
}

class Lab1_Task1_CSE220 {
    // Merge two sorted arrays into one sorted array
    public static Integer[] mergeSortedArray(Integer[] arr1, Integer[] arr2) {
        List<Integer> mergedList = new ArrayList<>();
        int i = 0, j = 0;

        // Merge both arrays
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                mergedList.add(arr1[i]);
                i++;
            } else {
                mergedList.add(arr2[j]);
                j++;
            }
        }

        // Append remaining elements from arr1
        while (i < arr1.length) {
            mergedList.add(arr1[i]);
            i++;
        }

        // Append remaining elements from arr2
        while (j < arr2.length) {
            mergedList.add(arr2[j]);
            j++;
        }

        // Convert List to Integer[]
        return mergedList.toArray(new Integer[0]);
    }

    // DO NOT CHANGE DRIVER CODE
    public static void main(String[] args) {
        Integer[] a1 = {1, 2, 3};
        Integer[] a2 = {2, 5, 6};
        System.out.print("Array 1: ");
        Arr.print(a1);
        System.out.print("Array 2: ");
        Arr.print(a2);
        System.out.println("Expected Output: [ 1 2 2 3 5 6 ]");
        Integer[] returned_val_1 = mergeSortedArray(a1, a2);
        System.out.print("Your Output: ");
        Arr.print(returned_val_1);
        System.out.print("\n======================\n");
        Integer[] a3 = {1, 3, 5, 11};
        Integer[] a4 = {2, 7, 8};
        System.out.print("\nArray 3: ");
        Arr.print(a3);
        System.out.print("Array 4: ");
        Arr.print(a4);
        System.out.println("Expected Output: [ 1 2 3 5 7 8 11 ]");
        Integer[] returned_val_2 = mergeSortedArray(a3, a4);
        System.out.print("Your Output: ");
        Arr.print(returned_val_2);
    }
}