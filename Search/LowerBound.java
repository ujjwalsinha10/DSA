package Search;

/*
 * Input Format: N = 5, arr[] = {3,5,8,15,19}, x = 9
 * Result: 3
 */
public class LowerBound {
    public static void main(String[] args) {
        int arr[] = { 3, 5, 8, 15, 19 };
        int x = 9;
        int n = arr.length;

        System.out.println(lowerBoundSol(arr, n, x));
    }

    // TC: O(logN)
    private static int lowerBoundSol(int[] arr, int n, int x) {
        int low = 0;
        int high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

}
