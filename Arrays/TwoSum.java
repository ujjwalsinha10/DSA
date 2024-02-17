package Arrays;

/*
 * Input Format: N = 5, arr[] = {2,6,5,8,11}, target = 14
 * Result: YES
 */
public class TwoSum {
    public static void main(String[] args) {
        int arr[] = { 2, 6, 5, 8, 11 };
        int target = 14;
        int[] result = applyTwoSum(arr, target);
        System.out.println(result[0] + "," + result[1]);
    }

    private static int[] applyTwoSum(int[] arr, int target) {
        int start = 0;
        int n = arr.length;
        int end = n - 1;
        while (start <= end) {
            int sum = arr[start] + arr[end];
            if (sum == target) {
                return new int[] { start, end };
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return new int[] { -1, -1 };
    }
}
