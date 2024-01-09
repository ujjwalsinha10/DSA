package Search;

/*
 * Input Format: N = 5, arr[] = {3,5,8,9,15,19}, x = 9
 * Result: 4
 */
public class UpperBound {
    public static void main(String[] args) {
        int arr[] = {3,5,8,9,15,19};
        int x = 9;
        int n = arr.length;

        System.out.println(upperBoundSol(arr, n, x));
    }

    // TC: O(logN)
    private static int upperBoundSol(int[] arr, int n, int x) {
        int low = 0;
        int high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

}
