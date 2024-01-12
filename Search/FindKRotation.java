package Search;

/*
 * Input Format: arr = [4,5,6,7,0,1,2,3]
 * Result: 4
 */

public class FindKRotation {
    public static void main(String[] args) {
        int arr[]={4,5,6,7,0,1,2,4};
        int n=arr.length;

        System.out.println(findIndex(arr,n));
    }

    private static int findIndex(int[] arr, int n) {
        int start=0;
        int end=n-1;
        int index=-1;
        int minValue=Integer.MAX_VALUE;
        while(start<=end){
            int mid=(start+end)/2;
            if(arr[start]<=arr[mid]){
                if(arr[start]<minValue){
                    index=start;
                    minValue=arr[start];
                }
                start=mid+1;
            }else{
                if(arr[mid]<minValue){
                    index=mid;
                    minValue=arr[mid];
                }
                end=mid-1;
            }
        }
        return index;
    }
}
