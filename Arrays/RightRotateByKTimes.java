package Arrays;

/*
 * Input: N = 6, array[] = {1, 2, 3, 4, 5, 6, 7} , k=3 , right 
 * Output: 5 6 7 1 2 3 4
 */
public class RightRotateByKTimes {
    public static void main(String[] args) {
        int n = 7;
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 4;

        // method1(arr, n, k);
        method2(arr, n, k);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // TC: O(n) SC: O(k)
    private static void method1(int[] arr, int n, int k) {
        k = k % n;
        int temp[] = new int[k];
        // segregate
        for (int i = n - k; i < n; i++) {
            temp[i - n + k] = arr[i];
        }
        // right shift
        for (int i = n - k - 1; i >= 0; i--) {
            arr[i + k] = arr[i];
        }

        // replace first
        for (int i = 0; i < k; i++) {
            arr[i] = temp[i];
        }
    }

    // TC:O(2n) SC:O(1)
    private static void method2(int[] arr, int n, int k) {
        reverse(arr, 0, n - k - 1);
        reverse(arr, n - k, n - 1);
        reverse(arr, 0, n - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

    }

}
