package Search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = { 3, 4, 6, 7, 9, 12, 16, 17 };
        int target = 6;

        System.out.println(iterativeApproach(arr, target));
        int n=arr.length;
        System.out.println(recursiveApproach(arr, target, 0, n-1));
    }


    private static int recursiveApproach(int[] arr, int target, int low, int high) {
        while(low<=high){
            int mid=(low+high)/2;

            // handle the Overflow Case: 
            // int mid=low+(high-low)/2;

            if(arr[mid]==target){
                return mid;
            }
            if(arr[mid]>target)
                return recursiveApproach(arr, target,0,mid-1);
            else{
              return recursiveApproach(arr, target, mid+1, high);
            }
        }
        return -1;
    }


    // TC: O(logN)
    private static int iterativeApproach(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
