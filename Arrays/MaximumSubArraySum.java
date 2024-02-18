package Arrays;

/*
 * Input: arr = [-2,1,-3,4,-1,2,1,-5,4] 
 * Output: 6 
 */
public class MaximumSubArraySum {
    public static void main(String[] args) {
        int arr[]={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("Max summation is: "+KadanesAlgorithm(arr));
    }

    private static int KadanesAlgorithm(int[] arr) {
        int maxi=Integer.MIN_VALUE;
        int sum=0;
        int ansStart=-1;
        int ansEnd=-1;
        int start=0;
        for(int i=0;i<arr.length;i++){
            if(sum==0)  {
                start=i;
            }
                
            sum+=arr[i];

            if(sum>maxi){
                maxi=sum;
                ansStart=start;
                ansEnd=i;
            }
            if(sum<0){
                sum=0;
            }
        }

        for(int i=ansStart;i<=ansEnd;i++){
            System.out.print(arr[i]);
        }
        return maxi;
    }
}
