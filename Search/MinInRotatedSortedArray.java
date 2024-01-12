package Search;

/**
 * Input Format: arr = [4,5,6,7,0,1,2,3]
 * Result: 0
 */
public class MinInRotatedSortedArray {
    public static void main(String[] args) {
        int arr[]={4,5,6,7,0,1,2,3};
        int n=arr.length;
        System.out.println(findMin(arr,n));
    }

    // TC: O(logN)  SC:O(1)
    private static int findMin(int[] arr, int n) {
        int start=0;
        int end=n-1;
        int result=Integer.MAX_VALUE;
        while(start<=end){
            int mid=(start+end)/2;

            // if the search space is already sorted, start is the min always
            if(arr[start]<=arr[end]){
                result=Math.min(result,arr[start]);
                break;
            }

            //check if the left is sorted
            if(arr[start]<=arr[mid]){
                // find the min between the starting & existing element as this part is sorted 
                result=Math.min(result,arr[start]);
                
                //eliminate  the left half
                start=mid+1;
                
            }else{ // if the right part is sorted

                // keep the minimum
                result=Math.min(result,arr[mid]);

                //eleminate the right half
                end=mid-1;
            }
        }
        return result;
    }

}