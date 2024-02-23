package RecursionAdvanced;

public class ArrayReverse {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        int start=0;
        int end=arr.length-1;

        rev(arr,start,end);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
    }

    private static int[] rev(int[] arr, int start, int end) {
        if(arr.length<=1) return arr;
        if(start<=end){
            swap(arr,start, end);
            rev(arr,start+1,end-1);
        }
        
        return arr;
    }

    private static void swap(int[] arr,int start, int end) {
        int temp=arr[start];
        arr[start]=arr[end];
        arr[end]=temp;
    }
}
