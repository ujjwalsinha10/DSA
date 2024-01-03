package Arrays;

/*
 * Input: N = 5, array[] = {1,2,3,4,5}
 * Output: 2,3,4,5,1
 */

public class LeftRotateByOne {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        int n=5;
        rotate(arr,n);
        print(arr,n);
    }

    private static void rotate(int[] arr, int n) {
        int temp=arr[0];
        for(int i=0;i<n-1;i++){
            arr[i]=arr[i+1];
        }
        arr[n-1]=temp;
    }

    private static void print(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    
}
