package Search;

/*
 * Input Format: arr = [7, 8, 1, 2, 3, 3, 3, 4, 5, 6], k = 3
 * Result: True
 */
public class SearchInRotatedArrayWithDuplicates {
    public static void main(String[] args) {

        int arr[] = { 7, 8, 1, 2, 3, 3, 3, 4, 5, 6 };
        int n = arr.length;
        int k = 7;

        System.out.println(searchIfPresent(arr, n, k));
    }

    // TC: Best- O(logN) Worst- O(N/2)  SC: O(1)
    private static boolean searchIfPresent(int[] arr, int n, int k) {
        int start = 0;
        int end = n - 1;
        boolean isPresent = false;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == k) {
                isPresent = true;
            }
            if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
                start = start + 1;
                end = end - 1;
                continue;
            }
            // check if left part is sorted
            if (arr[start] <= arr[mid]) {
                if (arr[start] <= k && arr[mid] >= k) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            // check if right part is sorted
            if (arr[mid] <= arr[end]) {
                if (arr[mid] <= k && arr[end] >= k) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return isPresent;
    }
}
