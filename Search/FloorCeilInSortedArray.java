package Search;

/*
 * Input Format: n = 6, arr[] ={3, 4, 4, 7, 8, 10}, x= 5
 * Result: 4 7
 * 
 * The floor of x is the largest element in the array which is smaller than or equal to x.
 * The ceiling of x is the smallest element in the array greater than or equal to x.
 */
public class FloorCeilInSortedArray {
    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 7, 8, 10};
        int n = 6, x = 5;

        int[] floor_Ceil = getFloorCeil(arr, n,x);
        System.out.println(floor_Ceil[0]+" "+floor_Ceil[1]);
    }

    private static int[] getFloorCeil(int[] arr, int n, int x) {
        int f=getFloor(arr,n,x);
        int c=getCeil(arr,n,x);
        return new int[] {f,c};
    }

    private static int getCeil(int[] arr, int n, int x) {
        int start=0;
        int end=n-1;
        int ans=-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(arr[mid]>=x){
                ans=arr[mid];
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return ans;
    }

    private static int getFloor(int[] arr, int n, int x) {
        int start=0;
        int end=n-1;
        int ans=-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(arr[mid]<=x){
                ans=arr[mid];
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return ans;
    }
    
}
