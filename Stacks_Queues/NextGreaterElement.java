package Stacks_Queues;

import java.util.Stack;

/*
 * Input: N = 11, A[] = {3,10,4,2,1,2,6,1,7,2,9}
 * Output: 10,-1,6,6,2,6,7,7,9,9,10
 */
public class NextGreaterElement {
    public static void main(String[] args) {
        int arr[] = { 3,10,4,2,1,2,6,1,7,2,9 };
        int[] nge = findNGE(arr);
        for (int i = 0; i < nge.length; i++) {
            System.out.print(nge[i] + ",");
        }

        System.out.println();
        int[] nge2 = findNGE2(arr);
        for (int i = 0; i < nge2.length; i++) {
            System.out.print(nge2[i] + ",");
        }
    }

    // TC: O(N^2) SC: O(1)
    private static int[] findNGE2(int[] arr) {
        int n=arr.length;
        int nge2[]=new int[n];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]<arr[j]){
                    nge2[i]=arr[j];
                    break;
                }else{
                    nge2[i]=-1;
                }
            }
        }
        return nge2;
    }

    // TC: O(N) SC:O(N)
    private static int[] findNGE(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; --i) {
            while (!stack.isEmpty() && arr[i % n] >= stack.peek()) {
                stack.pop();
            }

            if (i < n) {
                if (!stack.isEmpty()) {
                    nge[i] = stack.peek();
                } else {
                    nge[i] = -1;
                }
            }
            stack.push(arr[i % n]);
        }
        return nge;
    }
}
