package Arrays;

/*
 * Input: N = 6, array[] = {3,7,8,9,10,11} , k=3 , left 
 * Output: 9 10 11 3 7 8
 */

public class LeftRotateByKTimes {
    public static void main(String[] args) {
        int n = 7;
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;

        // method1(arr, n, k);
        method2(arr, n, k);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
            
        }
    }

    //TC: O(n)  SC: O(k)
    private static void method1(int[] arr, int n, int k) {
        if (n == 0)
            return;
        k = k % n;
        int temp[]= new int[k];
        for (int i = 0; i < k; i++) {
            temp[i]=arr[i];
        }
        for(int i=k;i<n;i++){
            arr[i-k]=arr[i];
        }
        for(int i=n-k;i<n;i++){
            arr[i]=temp[i-(n-k)];
        }

    }

    // TC:O(2n)  SC:O(1)
    private static void method2(int[] arr, int n, int k) {
        reverse(arr, 0, k-1);
        reverse(arr, k, n-1);
        reverse(arr, 0, n-1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while(start<=end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }

}
