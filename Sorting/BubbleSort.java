package Sorting;

public class BubbleSort {
    public static void main(String[] args) {
        // int arr[] = { 13, 46, 24, 52, 20, 9 };
        int arr[] = { 1, 2, 3, 4, 5 };
        int n = arr.length;
        bubbleSortAlgo(arr, n);
    }

    // method 1:
    /*
     *
     * private static void bubbleSortAlgo(int[] arr, int n) {
     * for (int i = 0; i < n - 1; i++) {
     * for (int j = 0; j < n - i - 1; j++) {
     * if (arr[j + 1] < arr[j]) {
     * int temp = arr[j];
     * arr[j] = arr[j + 1];
     * arr[j + 1] = temp;
     * }
     * }
     * }
     * 
     * for (int i = 0; i < n; i++) {
     * System.out.print(arr[i] + " ");
     * }
     * }
     */

    private static void bubbleSortAlgo(int arr[], int n) {
        int isSwapped = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    isSwapped = 1;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            if (isSwapped == 0) {
                break;
            }
        }

        print(arr, n);
    }

    private static void print(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
