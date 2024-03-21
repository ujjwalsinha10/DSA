package SlidingWindow_TwoPointer;

/*
 * Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}, k = 4 
 * Output : 39
 */
public class MaxSumSubArrOfK {
    public static void main(String[] args) {
        int arr[]={1,4,2,10,23,3,1,0,20};
        int k=4;
        int res=findMax(arr,k);
        System.out.println(res);
    }

    // TC:O(N) SC:O(1)
    private static int findMax(int[] arr, int k) {
        int n= arr.length;
        int i=0;
        int j=0;
        int max_Sum=Integer.MIN_VALUE;
        int sum=0;
        while(j<n){
            sum+=arr[j];
            if((j-i+1)<k){
                j++;
            }else if((j-i+1)==k){
                max_Sum=Math.max(max_Sum, sum);
                sum-=arr[i];
                j++;
                i++;
            }
        }
        return max_Sum;
    }
}
