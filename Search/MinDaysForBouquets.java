package Search;

/*
 * Input Format: N = 8, arr[] = {7, 7, 7, 7, 13, 11, 12, 7}, m = 2, k = 3
 * Result: 12
 * Explanation: On the 12th the first 4 flowers and the last 3 flowers would have already bloomed. 
 * So, we can easily make 2 bouquets, 
 * one with the first 3 and another with the last 3 flowers.
 */
public class MinDaysForBouquets {
    public static void main(String[] args) {
        int arr[] = { 7, 7, 7, 7, 13, 11, 12, 7 };
        int m = 2; // no. of bouquets
        int k = 3; // no. of flowers reqd to make bouquets

        System.out.println(getInBruteforce(arr, m, k));
        System.out.println(optimizedApproach(arr, m, k));
    }

    // TC: O((max(arr[])-min(arr[])+1) * N),
    // where {max(arr[]) -> maximum element of the array, min(arr[]) -> minimum
    // element of the array,
    // N = size of the array}
    // SC: O(1)
    private static int getInBruteforce(int[] arr, int m, int k) {
        int n = arr.length;
        long val = m * k;
        if (n < val)
            return -1;

        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, arr[i]);
            maxi = Math.max(maxi, arr[i]);
        }

        for (int i = mini; i <= maxi; i++) {
            if (possible(arr, i, m, k)) {
                return i;
            }
        }
        return -1;
    }

    private static boolean possible(int[] arr, int days, int m, int k) {
        int cnt = 0;
        int noOfB = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {

            if (arr[i] <= days) {
                cnt++;
            } else {
                noOfB += (cnt / k);
                cnt = 0;
            }
        }
        noOfB += (cnt / k);
        return noOfB >= m;
    }

    // TC: O(log(max(arr[])-min(arr[])+1) * N), where {max(arr[]) -> maximum element
    // of the array, min(arr[]) -> minimum element of the array,
    // N = size of the array}.
    // SC: O(1)
    private static int optimizedApproach(int arr[], int k, int m) {
        int n = arr.length;
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, arr[i]);
            maxi = Math.max(maxi, arr[i]);
        }

        int low = mini;
        int high = maxi;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (possible(arr, mid, k, m)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

}
