package Sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {13, 46, 24, 52, 20, 9};
        int n=arr.length;
        selectionSortAlgo(arr,n);
        
    }

    private static void selectionSortAlgo(int[] arr, int n) {
        for(int i=0;i<n-1;i++){
            int mini=i;
            for(int j=i;j<n;j++){
                if(arr[j]<arr[mini]){
                    mini=j;
                }
            }
            //swap
            swap(arr, i, mini);

        }

        for(int k=0;k<n;k++){
            System.out.print(arr[k]+" ");
        }
    }

    private static void swap(int[] arr, int i, int mini) {
        int temp=arr[mini];
        arr[mini]=arr[i];
        arr[i]=temp;
    }
    
}
