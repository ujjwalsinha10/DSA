package RecursionAdvanced;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsequence {
    public static void main(String[] args) {
        int arr[] = { 3, 1, 2 };

        int n = arr.length;
        List<Integer> al = new ArrayList<>();
        printSubSeq(0, arr, n, al);
    }

    // TC: O(2^N) SC: O(N)
    private static void printSubSeq(int i, int[] arr, int n, List<Integer> al) {
        // Print the subsequence when reach
        // the leaf of recursion tree
        if (i == n) {
            System.out.println(al.toString());
            return;
        }

        al.add(arr[i]);
        // Subsequence without including
        // the element at current index
        printSubSeq(i + 1, arr, n, al);
        // Backtrack to remove the recently
        // inserted element
        al.remove(al.size() - 1);
        // Subsequence including the element
        // at current index
        printSubSeq(i + 1, arr, n, al);
        return;
    }
}
