package Search;

/*
 * Input Format: n = 28
 * Result: 5
 */
public class SqrtUsingBinSearch {
    public static void main(String[] args) {
        int num=1;
        System.out.println(getSqrt(num));
    }

    // TC: O(logN)
    private static int getSqrt(int num) {
        int low=1;
        int high=num;
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if((mid*mid)<=num){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
}
