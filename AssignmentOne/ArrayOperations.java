import java.util.Scanner;
import java.util.Arrays;

class ArrayOperations {

    // Method to insert a new element at the end of array
    static int[] insert(int[] arr, int value) {

        // Creating a new array with size increased by 1
        int[] newArr = Arrays.copyOf(arr, arr.length + 1);

        // Assigning new value at last index
        newArr[arr.length] = value;
        return newArr;
    }

    // Method to delete an element from array
    static int[] delete(int[] arr, int value) {

        // Counting elements except the value to be deleted
        int count = 0;
        for (int i : arr)
            if (i != value)
                count++;

        // Creating new array of required size
        int[] newArr = new int[count];
        int index = 0;

        // Copying elements except the deleted value
        for (int i : arr) {
            if (i != value) {
                newArr[index++] = i;
            }
        }
        return newArr;
    }

    // Method for linear search
    static int linearSearch(int[] arr, int key) {

        // Traversing array element by element
        for (int i = 0; i < arr.length; i++) {

            // If key matches element, return index
            if (arr[i] == key)
                return i;
        }
        // If key not found
        return -1;
    }

    // Method for binary search
    static int binarySearch(int[] arr, int key) {

        // Sorting array before binary search
        Arrays.sort(arr);

        // Performing binary search
        return Arrays.binarySearch(arr, key);
    }

    // Method to find maximum value in array
    static int maxValue(int[] arr) {

        // Initializing max with first element
        int max = arr[0];

        // Comparing each element with max
        for (int i : arr)
            if (i > max)
                max = i;

        return max;
    }

    // Method to count even and odd numbers
    static void countEvenOdd(int[] arr) {
        int even = 0, odd = 0;

        // Checking each element for even or odd
        for (int i : arr) {
            if (i % 2 == 0)
                even++;
            else
                odd++;
        }

        System.out.println("Even count: " + even);
        System.out.println("Odd count: " + odd);
    }

    // Method to perform insertion sort
    static void insertionSort(int[] arr) {

        // Loop starting from second element
        for (int i = 1; i < arr.length; i++) {

            int key = arr[i];
            int j = i - 1;

            // Shifting elements greater than key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Inserting key at correct position
            arr[j + 1] = key;
        }

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Initial empty array
        int[] arr = {};

        // Infinite loop for menu
        while (true) {

            System.out.println("\n1.Insert 2.Delete 3.Linear Search 4.Binary Search 5.Max 6.Even/Odd 7.Sort 8.Exit");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value: ");
                    arr = insert(arr, sc.nextInt());
                    System.out.println(Arrays.toString(arr));
                    break;

                case 2:
                    System.out.print("Enter value to delete: ");
                    arr = delete(arr, sc.nextInt());
                    System.out.println(Arrays.toString(arr));
                    break;

                case 3:
                    System.out.print("Enter key: ");
                    System.out.println(linearSearch(arr, sc.nextInt()));
                    break;

                case 4:
                    System.out.print("Enter key: ");
                    System.out.println(binarySearch(arr, sc.nextInt()));
                    break;

                case 5:
                    System.out.println("Max: " + maxValue(arr));
                    break;

                case 6:
                    countEvenOdd(arr);
                    break;

                case 7:
                    insertionSort(arr);
                    break;

                case 8:
                    return; // Exits program
            }
        }
    }
}