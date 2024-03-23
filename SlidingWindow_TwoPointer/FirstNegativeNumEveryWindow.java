package SlidingWindow_TwoPointer;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Input :  N = 5 A[] = {-8, 2, 3, -6, 10} K = 2
 * Output : -8 0 -6 -6
 */
public class FirstNegativeNumEveryWindow {
    public static void main(String[] args) {
        int arr[]={-8, 2, 3, -6, 10};
        int k=2;
        bruteForceApproach(arr,k);
        System.out.println();
        int[] optimizedApproach = optimizedApproach(arr,k);
        for(int i=0;i<optimizedApproach.length;i++){
            System.out.print(optimizedApproach[i] +" ");
        }
    }

    // TC: O(N)  SC: O(N)
    private static int[] optimizedApproach(int[] arr, int k) {
        int i=0;
        int j=0;
        int length= arr.length;
        int index=0;
        Queue<Integer> q= new LinkedList<>();
        int [] firstNegativeNumber= new int[length-k+1];
        while(j<length){
            if(arr[j]<0){
                q.add(arr[j]);
            }
            if(j-i+1<k){
                j++;
            } else if(j-i+1==k){
                if(q.size()==0){
                    firstNegativeNumber[index++]=0;
                }else{
                    int num=q.peek();
                    firstNegativeNumber[index++]=num;
                    if(num==arr[i]){
                        q.remove();
                    }
                }
                i++;
                j++;
            }
        }
        return firstNegativeNumber;
    }

    private static void bruteForceApproach(int[] arr, int k) {
        int n= arr.length;
        boolean found;
        for(int i=0;i<(n-k+1);i++){
            found=false;
            for(int j=i;j<i+k;j++){
                if(arr[j]<0){
                    System.out.print(arr[j]+" ");
                    found=true;
                    break;
                }
            }
            if(!found){
                System.out.print("0"+" ");
            }
        }
    }
}
