#include <iostream>

using namespace std;

// Function to merge two sorted arrays
void mergeSortedArrays(int arr1[], int size1, int arr2[], int size2, int merged[]) {
    int i = 0, j = 0, k = 0;

    // Traverse both arrays and merge them
    while (i < size1 && j < size2) {
        if (arr1[i] < arr2[j]) {
            merged[k++] = arr1[i++];
        } else {
            merged[k++] = arr2[j++];
        }
    }

    // Add remaining elements from arr1
    while (i < size1) {
        merged[k++] = arr1[i++];
    }

    // Add remaining elements from arr2
    while (j < size2) {
        merged[k++] = arr2[j++];
    }
}

void sorting(int arr[], int size) {
    // Implement sorting logic here (e.g., bubble sort, insertion sort, etc.)
    // For simplicity, we'll use a simple bubble sort here
    for (int i = 0; i < size - 1; i++) {
        for (int j = 0; j < size - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                // Swap arr[j] and arr[j+1]
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

int main() {
    int a, b;
    cout << "Enter the size of the first array: ";
    cin >> a;
    cout << "Enter the size of the second array: ";
    cin >> b;

    // Dynamically allocate memory for the arrays
    int* arr1 = new int[a];
    int* arr2 = new int[b];

    // Take input from the user for values of the arrays
    cout << "Enter the values of the 1st array: ";
    for (int i = 0; i < a; i++) {
        cin >> arr1[i];
    }
    cout << "Enter the values of the 2nd array: ";
    for (int i = 0; i < b; i++) {
        cin >> arr2[i];
    }

    // Sort the arrays
    sorting(arr1, a);
    sorting(arr2, b);

    // Create an array to hold the merged result
    int* merged = new int[a + b];

    // Merge the arrays
    mergeSortedArrays(arr1, a, arr2, b, merged);

    // Output the merged array
    cout << "Merged Array: ";
    for (int i = 0; i < a + b; i++) {
        cout << merged[i] << " ";
    }
    cout << endl;

    // Free dynamically allocated memory
    delete[] arr1;
    delete[] arr2;
    delete[] merged;

    return 0;
}