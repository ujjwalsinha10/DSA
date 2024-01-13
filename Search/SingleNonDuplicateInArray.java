package Search;

/*
 * Input Format: arr[] = {1,1,2,2,3,3,4,5,5,6,6}
 * Result: 4
 */

public class SingleNonDuplicateInArray {
    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6 };
        int n = arr.length;

        System.out.println(findNonDuplicateElement(arr, n));
    }

    // TC: O(logN)
    private static int findNonDuplicateElement(int[] arr, int n) {
        // Edge cases
        if (n == 1)
            return arr[0];
        if (arr[0] != arr[1])
            return arr[0];
        if (arr[n - 1] != arr[n - 2])
            return arr[n - 1];
        int start = 1;
        int end = n - 2;
        while (start <= end) {
            int mid = (start + end) / 2;

            // if arr[mid] is the single element
            if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
                return arr[mid];
            }

            // we are in the left
            if (((mid % 2 == 1) && (arr[mid] == arr[mid - 1])) || ((mid % 2 == 0) && (arr[mid] == arr[mid + 1]))) {
                // Eleminate the left half
                start = mid + 1;
            } else {
                // Eleminate the right half
                end = mid - 1;
            }
        }
        return -1;
    }
}
