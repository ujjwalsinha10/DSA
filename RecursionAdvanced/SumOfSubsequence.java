package RecursionAdvanced;

import java.util.ArrayList;
import java.util.List;

public class SumOfSubsequence {
    public static void main(String[] args) {
        int arr[]={1,2,1};
        int sum=2;
        int n=arr.length;
        List<Integer> al= new ArrayList<>();
        printSubSeq(arr,sum,n,0,al,0);
    }

    private static void printSubSeq(int[] arr, int sum, int n, int i,List<Integer> al, int s) {
        if(i==n){
            if(s==sum){
                System.out.println(al.toString());
            }
            return;
        }
        al.add(arr[i]);
        s+=arr[i];
        printSubSeq(arr, sum, n, i+1, al,s);
        al.remove(al.size()-1);
        s-=arr[i];
        printSubSeq(arr, sum, n, i+1, al,s);
    }
}
