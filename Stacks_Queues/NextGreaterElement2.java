package Stacks_Queues;

import java.util.Stack;

/*
 * Input: 'a' = [1, 5, 3, 4, 2]
 * Output: NGE = [5, -1, 4, 5, 5]
 */
public class NextGreaterElement2 {
    public static void main(String[] args) {
        int arr[] = { 1, 5, 3, 4, 2 };
        int[] nge = findNGE(arr);
        for(int i=0;i<nge.length;i++){
            System.out.print(nge[i]+" ");
        }
    }

    private static int[] findNGE(int[] arr) {
        int n = arr.length;
        int nge[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2*n - 1; i >= 0; --i) {
            while (!stack.isEmpty() && arr[i%n] >= stack.peek()) {
                stack.pop();
            }
            if(i<n){
                if(!stack.empty()){
                    nge[i]=stack.peek();
                }else{
                    nge[i]=-1;
                }
            }
            stack.push(arr[i%n]);

        }
        return nge;
    }
}
