package Search;

/*
 * Input Format: N = 5, a[] = {1,2,3,4,5}, k = 3
 * Result: 6
 */
public class SplitArray {
    public static void main(String[] args) {
        int arr[]={10, 20, 30, 40};
        int k=2;
        System.out.println(findbyBruteForce(arr,k));
    }

    private static int findbyBruteForce(int[] arr, int k) {
        int low=arr[0];
        int high=0;
        for(int i=0;i<arr.length;i++){
            low=Math.max(low, arr[i]);
            high+=arr[i];
        }
        for(int maxSum=low;maxSum<=high;maxSum++){
            if(countPartitions(arr,maxSum)==k){
                return maxSum;
            }
        }
        return low;
    }

    private static int countPartitions(int[] arr, int maxSum) {
        int n=arr.length;
        int partitions=1;
        int subArraySum=0;
        for(int i=0;i<n;i++){
            if(subArraySum+arr[i]<=maxSum){
                subArraySum+=arr[i];
            }else{
                partitions++;
                subArraySum+=arr[i];
            }
        }
        return partitions;

    }
}
