package Arrays;

/**
 * Input: prices = {1, 1, 0, 1, 1, 1}
 * Output: 3
 */
public class MaxConsequtiveOne {
    public static void main(String[] args) {
        int arr[]= {1, 1, 0, 1, 1, 1,1,1,0,1,1};
        int n=arr.length;
        System.out.println(findCons(arr, n));

    }

    private static int findCons(int[] arr, int n) {
        int max_Count=0;
        int count=0;
        for(int i=0;i<n;i++){
            if(arr[i]==1){
                count++;
            }else{
                count=0;
            }
            if(count>max_Count){
                max_Count=count;
            }
        }
        return max_Count;
    }

}