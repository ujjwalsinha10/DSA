package Stacks_Queues;

/*
 * Input: N =6, heights[] = {2,1,5,6,2,3}
 * Output: 10
 */
public class LargestRectangleAreaInHistogram {
    public static void main(String[] args) {
        int arr[]={2,1,5,6,2,3};
        System.out.println(bruteForceApproach(arr));
    }

    // TC:O(N*N) SC:O(1)
    private static int bruteForceApproach(int[] arr) {
        int n=arr.length;
        int maxArea=0;
        for(int i=0;i<n;i++){
            int minHeight=Integer.MAX_VALUE;
            for(int j=i;j<n;j++){
                minHeight=Math.min(minHeight,arr[j]);
                maxArea=Math.max(maxArea, minHeight*(j-i+1));
            }
        }
        return maxArea;
    }
}
