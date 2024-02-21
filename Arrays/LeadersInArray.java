package Arrays;

import java.util.ArrayList;
import java.util.List;

public class LeadersInArray {
    public static void main(String[] args) {
        int arr[] = { 10, 22, 12, 3, 0, 6 };
        int n = arr.length;

        System.out.println("BruteForce Approach");
        System.out.println(bruteForceApproach(arr, n).toString());
        System.out.println("Optimized Approach");
        System.out.println(optimizedApproach(arr, n).toString());
    }

    // TC: O(N)  SC: O(N)
    private static List<Integer> optimizedApproach(int[] arr, int n) {
        List<Integer> answer = new ArrayList<>();

        // Last element of an array is always a leader,
        // push into ans array.
        int max = arr[n - 1];
        answer.add(arr[n - 1]);

        // Start checking from the end whether a number is greater
        // than max no. from right, hence leader.
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > max) {
                answer.add(arr[i]);
                max = arr[i];
            }
        }
        return answer;
    }

    // TC: O(N^2) SC: O(N) -> for answer storing
    private static List<Integer> bruteForceApproach(int[] arr, int n) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean leader = true;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    leader = false;
                    break;
                }
            }
            if (leader) {
                answer.add(arr[i]);
            }
        }
        return answer;
    }
}
