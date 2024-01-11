package Search;

/*
 * Input Format: arr = [4,5,6,7,0,1,2,3], k = 0
 * Result: 4
 */
public class SearchInRotatedArray {
    public static void main(String[] args) {
        int arr[] = { 4, 5, 6, 7, 0, 1, 2, 3 };
        int k = 2;
        int n = arr.length;

        System.out.println(findElementIndex(arr, n, k));
    }

    // TC: O(logN)  SC: O(1) 
    private static int findElementIndex(int[] arr, int n, int k) {
        int low = 0;
        int high = n - 1;
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == k) {
                index = mid;
                return index;
            }
            // if right part is sorted
            if (arr[mid] <= arr[high]) {
                if (k >= arr[mid] && k <= arr[high]) {
                    // element exists
                    low = mid + 1;
                }else{
                    // element does not exist
                    high=mid-1;
                }
            }else{
                // if left part is sorted
                if(arr[mid]>=k && arr[low]<=k){
                    // element exists
                    high=mid-1;
                }else{
                    // element does not exist
                    low=mid+1;
                }
            }

        }
        return index;

    }

}
