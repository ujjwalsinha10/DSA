package Search;

/*
 * Input Format: N = 5, arr[] = {1,2,3,4,5}, limit = 8
 * Result: 3
 */
public class SmallestDivisor {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        int limit = 8;

        System.out.println(findSmallestDivisor(arr, limit));
    }

    // TC: O(log(max(arr[]))*N), where max(arr[]) = maximum element in the array,
    // N = size of the array.
    // SC: O(1)
    private static int findSmallestDivisor(int[] arr, int limit) {
        int n = arr.length;
        if (n > limit)
            return -1;
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, arr[i]);
        }

        int low = 1;
        int high = maxi;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (divisor(arr, mid) <= limit) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int divisor(int[] arr, int div) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += Math.ceil((double) arr[i] / (double) div);
        }
        return sum;
    }
}
