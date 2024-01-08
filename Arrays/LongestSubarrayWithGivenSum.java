package Arrays;

/*
 * Input Format: N = 5, k = 10, array[] = {2,3,5,1,9}
 * Result: 3
 */
public class LongestSubarrayWithGivenSum {
    public static void main(String[] args) {
        int arr[] = { 2, 3, 5, 1, 9 };
        int n = arr.length;
        int k = 10;

        System.out.println(method1(arr, n, k));
        System.out.println(optimalSolution(arr, n, k));
    }

    // TC: O(n^2) SC: O(1)
    private static int method1(int[] arr, int n, int k) {

        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];

                if (sum == k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    // TC: O(2n) SC: O(1)
    private static int optimalSolution(int[] arr, int n, int k) {
        int left=0;
        int right=0;
        int sum=arr[0];
        int maxLen=0;
        //check for the pointer doesnt exceed from the array length
        while(right<n){
            //check for the pointer cross over and the sum : 
            // if: sum exceeds -> remove the starting element from sum & move the left pointer forward
            while(left<=right && sum>k){
                sum-=arr[left];
                left++;
            }

            if(sum==k){
                maxLen=Math.max(maxLen, right-left+1);
            }
            right++;
            //check for the right pointer limit
            if(right<n){
                sum+=arr[right];
            }
        }
        return maxLen;
    }
}
