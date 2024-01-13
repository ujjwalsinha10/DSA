package Search;

/*
 * Input Format: arr[] = {1,2,3,4,5,6,7,8,5,1}
 * Result: 7
 * arr[i]’ is the peak element, ‘arr[i – 1]’ < ‘arr[i]’ and ‘arr[i + 1]’ < ‘arr[i]’. 
 */

public class PeakElement {
    public static void main(String[] args) {
        int arr[] = { 1,2,3,4,5,6,7,8,5,1};
        int n = arr.length;

        System.out.println(findPeakElement(arr, n));
    }

    private static int findPeakElement(int[] arr, int n) {

        // Edge cases
        if (n == 1)
            return arr[0];

        if (arr[0] > arr[1])
            return arr[0];
        if (arr[n - 1] > arr[n - 2])
            return arr[n - 1];

        int start = 1;
        int end = n - 2;
        while (start <= end) {
            int mid = (start + end) / 2;
            if(arr[mid]>arr[mid+1]  && arr[mid]>arr[mid-1]){
                return arr[mid];
            }
            if(arr[mid]>arr[mid-1]){
                start=mid+1;
            }else if(arr[mid]<arr[mid-1]){
                end=mid-1;
            }else{
                end=mid-1;
            }

        }
        return -1;

    }

}
