package Stacks_Queues;
public class TrappingRainwater {
    public static void main(String[] args) {
        int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(bruteforceApproach(arr));
        System.out.println(betterApproach(arr));
        System.out.println(optimalSolution(arr));
    }

    // Using two-pointer approach
    // TC:O(N) SC:O(1)
    private static int optimalSolution(int[] arr) {
        int n=arr.length;
        int maxLeft=0;
        int maxRight=0;
        int left=0;
        int right=n-1;
        int result=0;
        while(left<=right){
            if(arr[left]<=arr[right]){
                if(arr[left]>=maxLeft){
                    maxLeft=arr[left];
                }else{
                    result+=maxLeft-arr[left];
                }
                left++;
            }else{
                if(arr[right]>=maxRight){
                    maxRight=arr[right];
                }else{
                    result+=maxRight-arr[right];
                }
                right--;
            }
        }
        return result;
    }

    // Using Prefix sum & Suffix sum concept
    // TC: O(3N) ~ O(N) SC: O(N+N)
    private static int betterApproach(int[] arr) {
        int n=arr.length;
        int prefixSum[]= new int[n];
        int suffixSum[]= new int[n];
        prefixSum[0]=arr[0];
        for(int i=1;i<n;i++){
            prefixSum[i]=Math.max(prefixSum[i-1], arr[i]);
        }
        suffixSum[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            suffixSum[i]=Math.max(suffixSum[i+1], arr[i]);
        }
        int waterTrapped=0;
        for(int i=0;i<n;i++){
            waterTrapped+=Math.min(prefixSum[i],suffixSum[i])-arr[i];
        }
        return waterTrapped;
    }

    // TC: O(N^2) SC:O(1)
    private static int bruteforceApproach(int[] arr) {
        int n=arr.length;
        int waterTrapped=0;
        // iterating the array from 1 to n-2 as
        // first and last element can't store the water
        for(int i=1;i<n-1;i++){
            int left=arr[i];
            for(int j=0;j<i;j++){
                left=Math.max(left, arr[j]);
            }
            int right=arr[i];
            for(int j=i+1;j<n-1;j++){
                right=Math.max(right, arr[j]);
            }
            waterTrapped+=Math.min(left, right)-arr[i];
        }
        return waterTrapped;
    }
}
