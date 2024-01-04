package Arrays;

/*
 * Input: 1 ,0 ,2 ,3 ,0 ,4 ,0 ,1
 * Output: 1 ,2 ,3 ,4 ,1 ,0 ,0 ,0
 */

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[] arr ={1,1,1,1,1}; //{1 ,0 ,2 ,3 ,0 ,4 ,0 ,1};
        int n = 5;

        moveZeros(arr,n);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] +" ");
        }
    }

    // TC: O(n)  SC: O(1)
    private static void moveZeros(int[] arr, int n) {
        //step1: identify the first zero
        int j=-1;
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                j=i;
                break;
            }
        }
        //no non-zero elements:
        if (j == -1) return ;
        //step 2: check and Replace non-zero element 
        for(int i=j+1;i<n;i++){
            if(arr[i]!=0){
                swap(arr,i,j);
                j++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
