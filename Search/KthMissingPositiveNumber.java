package Search;

/**
 * Input Format: vec[]={4,7,9,10}, k = 4
 * Result: 5
 * Explanation: The missing numbers are 1, 2, 3, 5, 6, 8, 11, 12, ……, and so on.
 * Since 'k' is 4, the fourth missing element is 5.
 */

public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        int arr[]={4,7,9,10};
        int k=4;

        System.out.println(findNumber(arr, k));
    }

    // TC: O(logN) SC: O(1)
    private static int findNumber(int[] arr, int k) {
        int n=arr.length;
        int low=0;
        int high=n-1;
        int missing=-1;
        while(low<=high){
            int mid=(low+high)/2;
            missing=arr[mid]-(mid+1);
            if(missing<k){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return (high+1+k);
    }
}