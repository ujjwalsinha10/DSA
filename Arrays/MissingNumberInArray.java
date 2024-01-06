package Arrays;

/*
 * Input Format: N = 5, array[] = {1,2,4,5}
 * Result: 3
 */
public class MissingNumberInArray {
    public static void main(String[] args) {
        int arr[] = {1,2,4,5};
        int N=5;
        System.out.println(findNumber(arr, N));
    }

    // TC: O(n), SC: O(1)
    private static int findNumber(int[] arr, int n) {

        int xor1=0;
        int xor2=0;

        for(int i=0;i<n-1;i++){
            xor2=xor2^arr[i];
            xor1=xor1^(i+1);
        }
        xor1=xor1^n;


        return (xor1^xor2);
        
    }
    
}
