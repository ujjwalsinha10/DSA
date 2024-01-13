package Search;

/*
 * Input Format: N = 3, M = 27 Result: 3
 * Input Format: N = 4, M = 69 Result: -1
 */

public class FindNthRoot {
    public static void main(String[] args) {
        int n = 4, m = 69;
        System.out.println(NthRoot(n,m));
    }

    private static int NthRoot(int n, int m) {
        int low=1;
        int high=m;
        while(low<=high){
            int mid=(low+high)/2;
            int midN=func(mid,n,m);
            if(midN==1)
                return mid;
            else if(midN==0)
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;
    }

    //Return 1 if mid == m
    //Return 0 if mid < m
    //Return 2 if mid > m
    private static int func(int mid, int n, int m) {
        int ans=1;
        for (int i = 1; i <= n; i++) {
            ans=ans*mid;
            if(ans>m) return 2;
        }
        if(ans==m) return 1;
        else 
        return 0;
    }
}
