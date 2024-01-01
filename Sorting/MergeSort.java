package Sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * MergeSort
 */
public class MergeSort {

    public static void main(String[] args) {
        int arr[] = { 9, 4, 7, 6, 3, 1, 5 };
        int n = arr.length;
        mergeSortAlgo(arr, 0, n - 1);
        for(int k=0;k<arr.length;k++){
            System.out.print(arr[k]+" ");
        }
    }

    private static void mergeSortAlgo(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        if(low>=high) return;
        mergeSortAlgo(arr, low, mid);
        mergeSortAlgo(arr, mid + 1, high);
        merge(arr, low, mid, high);
        
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        //for the leftovers
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        //for the leftovers
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        for(int i=low;i<=high;i++){
            arr[i]=temp.get(i-low);
        }

        
    }
}