package Recursion;

public class ReverseArrayRecusive {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        int n= arr.length;
        reverseArray(arr,0,n-1);
        printArray(arr);
    }

    private static void reverseArray(int[] arr, int start, int end) {
        if(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            reverseArray(arr, start+1,end-1);
        }
        
        
    }

    private static void printArray(int[] arr) {
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
